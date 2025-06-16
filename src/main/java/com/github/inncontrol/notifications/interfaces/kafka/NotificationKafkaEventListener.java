package com.github.inncontrol.notifications.interfaces.kafka;

import com.github.inncontrol.notifications.domain.command.SendGlobalPushNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendMailNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendUserPushNotificationCommand;
import com.github.inncontrol.notifications.domain.model.aggregates.PushNotification;
import com.github.inncontrol.notifications.domain.services.NotificationCommandService;
import com.github.inncontrol.notifications.interfaces.kafka.assembler.PushNotificationEntityFromResourceAssembler;
import com.github.inncontrol.shared.interfaces.kafka.resource.PushNotificationResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:39
 */
@Slf4j
@Component
@AllArgsConstructor
public class NotificationKafkaEventListener {

    private final NotificationCommandService notificationCommandService;

    @KafkaListener(topics = "notifications", groupId = "${spring.kafka.consumer.group-id}")
    public void on(PushNotificationResource resource, @Value("${inncontrol.notifications.global.topic}") String globalTopic) {
        log.info("Received notification resource: {}", resource);

        boolean isMailNotification = resource.getToMail() != null && !resource.getToMail().isEmpty();

        if (isMailNotification) {
            notificationCommandService.handle(SendMailNotificationCommand.builder()
                    .to(resource.getToMail())
                    .subject(resource.getTitle())
                    .body(resource.getMessage())
                    .build());
            return;
        }

        PushNotification pushNotification = PushNotificationEntityFromResourceAssembler.toEntityFromResource(resource);

        if (resource.isBroadcast()) {
            notificationCommandService.handle(SendGlobalPushNotificationCommand.builder()
                    .pushNotification(pushNotification)
                    .topic(globalTopic)
                    .build());
        } else {
            notificationCommandService.handle(SendUserPushNotificationCommand.builder()
                    .userId(resource.getUserId())
                    .pushNotification(pushNotification)
                    .build());
        }
    }
}
