package com.github.eljaiek.machinery.tests.server;

import com.github.eljaiek.machinery.tests.notifications.EnableNotifications;
import com.gtihub.eljaiek.machinery.web.i8ln.MessageBundle;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableNotifications
@SpringBootApplication
public class Application {

    @Autowired MessageBundle messageBundle;

    @PostConstruct
    @SuppressWarnings("unused")
    void init() {
        messageBundle.register("classpath:zoo");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
