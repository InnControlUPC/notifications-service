package com.github.inncontrol.utils.factory;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: inncontrol-backend
 * Date: 7/7/25 @ 01:27
 */
public interface EmailFactory {

    void sendEmail(String to, String subject, String body);
}
