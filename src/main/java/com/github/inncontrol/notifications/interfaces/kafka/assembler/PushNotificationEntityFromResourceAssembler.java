package com.github.inncontrol.notifications.interfaces.kafka.assembler;

import com.github.inncontrol.notifications.domain.model.aggregates.PushNotification;
import com.github.inncontrol.notifications.domain.model.valueobjects.PushNotificationType;
import com.github.inncontrol.shared.interfaces.kafka.resource.PushNotificationResource;
import com.github.inncontrol.notifications.domain.model.validator.PushNotificationTypeValidator;
import lombok.experimental.UtilityClass;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:37
 */
@UtilityClass
public class PushNotificationEntityFromResourceAssembler {

    public PushNotification toEntityFromResource(PushNotificationResource resource) {
        if (!PushNotificationTypeValidator.validate(resource.getType())) {
            throw new IllegalArgumentException("Invalid push notification type: " + resource.getType());
        }
        return PushNotification.builder()
                .title(resource.getTitle())
                .type(PushNotificationType.valueOf(resource.getType().toUpperCase()))
                .message(resource.getMessage())
                .build();
    }
}
