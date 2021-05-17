package com.github.eljaiek.machinery.tests.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class MachineryWebI8lnTests extends BaseIntegrationTests {

    static final String ENDPOINT = "/zoo/welcome";

    @Test
    void shouldReturnDefaultMessage() {
        // When
        ResponseEntity<String> resp = restTemplate.getForEntity(buildUrl(ENDPOINT), String.class);

        // Then
        assertThat(resp.getBody()).isEqualTo("Hello, The Zoo is open");
    }

    @Test
    void shouldReturnExpectedMessage() {
        // Given
        var url =
                uriBuilderWithPath(ENDPOINT)
                        .query("lng={locale}")
                        .buildAndExpand("fr")
                        .toUriString();

        // When
        ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);

        // Then
        assertThat(resp.getBody()).isEqualTo("Bonjour, Le Zoo est ouvert");
    }
}
