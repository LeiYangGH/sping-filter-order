package com.example.demo.wrapper;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//https://stackoverflow.com/questions/7318632/java-lang-illegalstateexception-getreader-has-already-been-called-for-this-re
public class MyFilter implements Filter {
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(httpServletRequest);
    chain.doFilter(cachedRequest, response);
  }
}
