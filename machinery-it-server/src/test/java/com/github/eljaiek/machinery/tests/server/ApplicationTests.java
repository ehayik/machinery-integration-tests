package com.github.eljaiek.machinery.tests.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.github.eljaiek.machinery.config.core.ConfigMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTests {

    @LocalServerPort int port;
    @Autowired TestRestTemplate restTemplate;

    @Test
    @SuppressWarnings("java:S2699")
    void contextLoads() {
        ResponseEntity<ConfigMap> resp =
                restTemplate.getForEntity(
                        "http://localhost:" + port + "/notifications/config/mailSender",
                        ConfigMap.class);
        assertThat(resp.getStatusCodeValue()).isNotEqualTo(404);
    }
}
