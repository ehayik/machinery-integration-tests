package com.github.eljaiek.machinery.tests.server;

import static java.lang.String.format;

import com.gtihub.eljaiek.machinery.web.i8ln.MessageBundle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ZooController {

    private final MessageBundle messageBundle;

    @GetMapping("/zoo/welcome")
    @SuppressWarnings("unused")
    String welcome() {
        return format(
                "%s, %s", messageBundle.getMessage("hello"), messageBundle.getMessage("open"));
    }
}
