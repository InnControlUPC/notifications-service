package com.github.inncontrol.notifications.domain.model.validator;

import com.github.inncontrol.notifications.domain.model.valueobjects.PushNotificationType;
import lombok.experimental.UtilityClass;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:32
 */
@UtilityClass
public class PushNotificationTypeValidator {

    public boolean validate(String notificationType) {
        if (notificationType == null || notificationType.isEmpty()) {
            return false;
        }

        try {
            PushNotificationType.valueOf(notificationType.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
