package com.example.demo.commonlog;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

//https://www.baeldung.com/spring-http-logging
@Configuration
public class RequestLoggingFilterConfig {
  protected static final Logger log = LogManager.getLogger();

  @Bean
  public MyRequestLoggingFilter logFilter() {
    return new MyRequestLoggingFilter();
  }
}