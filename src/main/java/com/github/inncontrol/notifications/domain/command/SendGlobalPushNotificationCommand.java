package com.github.inncontrol.notifications.domain.command;

import com.github.inncontrol.notifications.domain.model.aggregates.PushNotification;
import lombok.*;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendGlobalPushNotificationCommand {

    private String topic;

    private PushNotification pushNotification;
}
