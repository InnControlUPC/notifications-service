package com.github.inncontrol.notifications.domain.model.valueobjects;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:17
 */
public enum PushNotificationType {
    /**
     * Notification type for general messages.
     */
    GENERAL,

    /**
     * Notification type for alerts.
     */
    ALERT,

    /**
     * Notification type for warnings.
     */
    WARNING,

    /**
     * Notification type for errors.
     */
    ERROR,

    /**
     * Notification type for informational messages.
     */
    INFO


}