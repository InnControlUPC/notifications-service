package com.github.inncontrol.utils.factory.config.mailjet;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: backend_spring
 * Date: 2/9/25 @ 22:57
 */
@Slf4j
@Configuration
public class MailJetConfiguration {

    @Bean
    public ClientOptions getMailJetClientOptions(
    ) {
        return ClientOptions.builder()
                .apiKey("a60c8ea5e99f88265f16ad592bb7b557")
                .apiSecretKey("aeeab131e54f11d024504840daf551b3")
                .build();
    }

    @Bean
    public MailjetClient getMailJetClient(ClientOptions clientOptions) {
        log.info("Initializing Mailjet client");
        log.info("Mailjet API Key: {}", clientOptions.getApiKey());
        log.info("Mailjet API Secret Key: {}", clientOptions.getApiSecretKey());
        return new MailjetClient(clientOptions);
    }

}
