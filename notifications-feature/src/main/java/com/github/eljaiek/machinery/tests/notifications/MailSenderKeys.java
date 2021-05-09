package com.github.eljaiek.machinery.tests.notifications;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
final class MailSenderKeys {
    static final String ALIAS = "mail.alias";
    static final String ENABLED = "mail.enabled";
    static final String HOST = "mail.host";
    static final String PORT = "mail.port";
    static final String USERNAME = "mail.username";
    static final String PASSWORD = "mail.password";
}
