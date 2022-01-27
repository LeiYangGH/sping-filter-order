package com.example.demo.commonlog;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

public class MyRequestLoggingFilter extends CommonsRequestLoggingFilter {
  public MyRequestLoggingFilter() {
    this.setIncludeQueryString(true);
    this.setIncludePayload(true);
    this.setMaxPayloadLength(10000);
    this.setIncludeHeaders(false);
    this.setAfterMessagePrefix("REQUEST DATA : ");
  }

  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(request);
    logger.info("beforeRequest");
    try {
      logger.info(IOUtils.toString(cachedRequest.getReader()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    super.beforeRequest(cachedRequest, message);
  }
}
