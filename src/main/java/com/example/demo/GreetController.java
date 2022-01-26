package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    protected static final Logger log = LogManager.getLogger();

    @PostMapping("/")
    public String greet(@RequestBody final WelcomeMessage msg) {
        log.info(msg);
        return "Hello " + msg.from;
    }
}
