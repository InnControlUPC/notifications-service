package com.github.inncontrol.notifications.application.commandservice;

import com.github.inncontrol.notifications.domain.command.SendGlobalPushNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendMailNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendUserPushNotificationCommand;
import com.github.inncontrol.notifications.domain.services.NotificationCommandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:16
 */
@Service
@AllArgsConstructor
@Slf4j
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void handle(SendGlobalPushNotificationCommand command) {
        messagingTemplate.convertAndSend(command.getTopic(), command.getPushNotification());
        log.info("Sent notification to topic {}", command.getTopic());
    }

    @Override
    public void handle(SendUserPushNotificationCommand command) {
        String destination = String.format("/user/%s/notifications", command.getUserId());
        messagingTemplate.convertAndSend(destination, command.getPushNotification());
        log.info("Sent notification to user {} at destination {}", command.getUserId(), destination);
    }

    @Override
    public void handle(SendMailNotificationCommand command) {

    }
}
