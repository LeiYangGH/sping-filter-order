package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {
    protected static final Logger log = LogManager.getLogger();

    @PostMapping("/")
    public String greet(@RequestBody final WelcomeMessage msg) {
        log.info(msg);
        return "Hello " + msg.from;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String addStudent(HttpMessageNotReadableException e) {
        log.error(e.getMessage());
        return "greeting from @ExceptionHandler";
    }
}
