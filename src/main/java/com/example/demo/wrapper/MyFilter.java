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
//@Order(Ordered.LOWEST_PRECEDENCE)
public class MyFilter implements Filter {
    protected static final Logger log = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
//can work for both valid and both invalid request, but log after response
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(httpServletRequest);
//        chain.doFilter(cachedRequest, response);
//        String requestBody = IOUtils.toString(cachedRequest.getContentAsByteArray(), cachedRequest.getCharacterEncoding());
//        log.info(requestBody);
//    }

    //log before response, but only work for invalid request
    //for valid request: Required request body is missing
//    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(httpServletRequest);
//        String requestBody = IOUtils.toString(cachedRequest.getContentAsByteArray(), cachedRequest.getCharacterEncoding());
//        String requestBody = IOUtils.toString(cachedRequest.getInputStream(), cachedRequest.getCharacterEncoding());
        String requestBody = IOUtils.toString(cachedRequest.getReader());
        log.info(requestBody);
        chain.doFilter(cachedRequest, response);
    }
}
