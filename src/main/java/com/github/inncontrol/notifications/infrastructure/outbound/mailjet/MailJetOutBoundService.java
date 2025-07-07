package com.github.inncontrol.notifications.infrastructure.outbound.mailjet;

import com.github.inncontrol.utils.factory.impl.MailJetEmailProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 6/4/25 @ 16:46
 */
@Service
@AllArgsConstructor
@Getter
public class MailJetOutBoundService {

    private final MailJetEmailProvider provider;
}
