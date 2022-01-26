package com.example.demo.wrapper;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//https://stackoverflow.com/questions/43859654/spring-boot-custom-filter-is-not-working
@Configuration
public class Filters {

    @Bean
    public FilterRegistrationBean myFilterBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        return filterRegistrationBean;
    }


}
