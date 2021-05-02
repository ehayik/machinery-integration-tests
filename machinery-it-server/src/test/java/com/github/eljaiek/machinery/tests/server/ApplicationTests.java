package com.github.eljaiek.machinery.tests.server;

import com.gtihub.eljaiek.machinery.web.i8ln.MessageBundle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    MessageBundle messageBundle;

    @Test
    @SuppressWarnings("java:S2699")
    void contextLoads() {
    }
}
