package com.github.eljaiek.machinery.tests.notifications;

import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.ALIAS;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.ENABLED;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.HOST;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.PASSWORD;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.PORT;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.USERNAME;

import com.github.eljaiek.machinery.config.core.ConfigMaps;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
class NotificationsConfiguration {

    @Bean
    CommandLineRunner initializeMailSenderConfig(ConfigMaps configMaps) {
        return args -> {
            var entries =
                    Map.of(
                            ALIAS,
                            "Administrator",
                            ENABLED,
                            "true",
                            HOST,
                            "smtp.gmail.com",
                            PORT,
                            "587",
                            USERNAME,
                            "admin@gmail.com",
                            PASSWORD,
                            "admin123");

            var configMap = configMaps.of(entries);
            configMap.put("mail.properties.mail.transport.protocol", "smtp");
            configMap.put("mail.properties.mail.smtp.auth", "true");
            configMap.put("mail.properties.mail.smtp.starttls.enable", "true");
            configMap.put("mail.properties.mail.debug", "true");
            configMap.save();
        };
    }
}
