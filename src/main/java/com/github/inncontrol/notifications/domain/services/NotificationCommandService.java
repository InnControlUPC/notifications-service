package com.github.inncontrol.notifications.domain.services;

import com.github.inncontrol.notifications.domain.command.SendGlobalPushNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendMailNotificationCommand;
import com.github.inncontrol.notifications.domain.command.SendUserPushNotificationCommand;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:16
 */
public interface NotificationCommandService {

    void handle(SendGlobalPushNotificationCommand command);

    void handle(SendUserPushNotificationCommand command);

    void handle(SendMailNotificationCommand command);
}
