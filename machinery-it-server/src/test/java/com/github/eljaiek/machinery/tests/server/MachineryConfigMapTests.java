package com.github.eljaiek.machinery.tests.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.eljaiek.machinery.config.core.ConfigMap;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class MachineryConfigMapTests extends BaseIntegrationTests {

    @Test
    @SuppressWarnings("java:S2699")
    void contextLoads() {
        // When
        ResponseEntity<ConfigMap> resp =
                restTemplate.getForEntity(
                        buildUrl("/notifications/config/mailSender"), ConfigMap.class);

        // Then
        assertThat(resp.getStatusCodeValue()).isNotEqualTo(404);
    }
}
