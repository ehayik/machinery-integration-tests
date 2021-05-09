package com.github.eljaiek.machinery.tests.notifications;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Target(TYPE)
@Retention(RUNTIME)
@Configuration
@Import(NotificationsConfiguration.class)
public @interface EnableNotifications {}
