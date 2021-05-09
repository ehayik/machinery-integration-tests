package com.github.eljaiek.machinery.tests.server;

import com.github.eljaiek.machinery.tests.notifications.EnableNotifications;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableNotifications
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
