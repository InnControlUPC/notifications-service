package com.github.inncontrol.notifications.domain.command;

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
public class SendMailNotificationCommand {

    private String to;

    private String subject;

    /**
     * The body of the email notification a html formatted string.
     */
    private String body;
}
