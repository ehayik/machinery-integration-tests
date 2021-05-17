package com.github.eljaiek.machinery.tests.server;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract class BaseIntegrationTests {

    @LocalServerPort int port;
    @Autowired TestRestTemplate restTemplate;

    String buildUrl(String endpointUrl) {
        return uriBuilderWithPath(endpointUrl).build().toString();
    }

    UriComponentsBuilder uriBuilderWithPath(String endpointUrl) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(port)
                .path(endpointUrl);
    }
}
