package com.github.eljaiek.machinery.tests.notifications;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.github.eljaiek.machinery.config.core.ConfigMap;
import com.github.eljaiek.machinery.config.core.ConfigMaps;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class NotificationSendersConfigController {

    private final ConfigMaps configMaps;

    @SuppressWarnings({"unused", "java:S3751"})
    @GetMapping("/notifications/config/mailSender")
    ResponseEntity<ConfigMap> getMailServerConfigMap() {
        var configMap = configMaps.groupBy("mail");
        return configMap.isEmpty() ? notFound().build() : ok(configMap);
    }
}
