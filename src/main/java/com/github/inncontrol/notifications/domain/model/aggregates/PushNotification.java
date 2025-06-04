package com.github.inncontrol.notifications.domain.model.aggregates;

import com.github.inncontrol.notifications.domain.model.valueobjects.PushNotificationType;
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
public final class PushNotification {
    private String title;
    private String message;
    private PushNotificationType type;
}
