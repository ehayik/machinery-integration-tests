package com.github.eljaiek.machinery.tests.notifications;

import static com.github.eljaiek.machinery.config.core.KeyOperators.removePrefix;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.HOST;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.PASSWORD;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.PORT;
import static com.github.eljaiek.machinery.tests.notifications.MailSenderKeys.USERNAME;

import com.github.eljaiek.machinery.config.core.ConfigMap;
import com.github.eljaiek.machinery.config.core.ConfigMaps;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class JavaMailSenderFactory {

    private final ConfigMaps configMaps;

    @SuppressWarnings("unused")
    JavaMailSender create() {
        var configMap = configMaps.groupBy("mail");
        return setProperties(createWithConfig(configMap), configMap);
    }

    private static JavaMailSenderImpl createWithConfig(ConfigMap configMap) {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(configMap.getValueAsText(HOST));
        mailSender.setPort(configMap.getValueAsInt(PORT));
        mailSender.setUsername(configMap.getValueAsText(USERNAME));
        mailSender.setPassword(configMap.getValueAsText(PASSWORD));
        return mailSender;
    }

    private static JavaMailSender setProperties(
            JavaMailSenderImpl mailSender, ConfigMap configMap) {
        var properties = configMap.groupBy("mail.properties", removePrefix(".")).toMap();
        mailSender.getJavaMailProperties().putAll(properties);
        return mailSender;
    }
}
