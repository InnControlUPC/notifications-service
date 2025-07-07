package com.github.inncontrol.utils.factory.impl;

import com.github.inncontrol.utils.factory.EmailFactory;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.transactional.SendContact;
import com.mailjet.client.transactional.SendEmailsRequest;
import com.mailjet.client.transactional.TransactionalEmail;
import com.mailjet.client.transactional.response.SendEmailsResponse;
import com.mailjet.client.transactional.response.SentMessageStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 7/7/25 @ 01:28
 */
@Service
@AllArgsConstructor
@Slf4j
public class MailJetEmailProvider implements EmailFactory {

    private final MailjetClient client;

    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            TransactionalEmail message = TransactionalEmail.builder()
                    .to(new SendContact(to))
                    .from(new SendContact("no-reply@llantatech.org.pe", "InnControl - Nueva Tarea"))
                    .htmlPart(body)
                    .subject(subject)
                    .build();

            SendEmailsRequest request = SendEmailsRequest.builder()
                    .message(message)
                    .build();

            SendEmailsResponse response = request.sendWith(client);
            if (Arrays.stream(response.getMessages()).anyMatch(m -> m.getStatus() != SentMessageStatus.SUCCESS)) {
                throw new RuntimeException("Error al enviar el correo con Mailjet");
            } else {
                log.info("Correo enviado exitosamente a: {} con Mailjet", to);
            }
        } catch (Exception e) {
            log.error("Error al enviar el correo con Mailjet: {}", e.getMessage(), e);
        }
    }
}
