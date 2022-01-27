package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.ContentCachingRequestWrapper;

@RestController
public class GreetController {
  protected static final Logger log = LogManager.getLogger();

  @PostMapping("/")
  public String greet(@RequestBody final WelcomeMessage msg) {
    log.info(msg);
    return "Hello " + msg.from;
  }

  @ExceptionHandler({ HttpMessageNotReadableException.class })
  public String addStudent(HttpMessageNotReadableException e, ContentCachingRequestWrapper cachedRequest) {
    log.error(e.getMessage());
    try {
      String requestBody = IOUtils.toString(cachedRequest.getContentAsByteArray(), cachedRequest.getCharacterEncoding());
      log.error(requestBody);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "greeting from @ExceptionHandler";
  }
}
/**/