package org.lwason.sbprj.config;

import lombok.extern.slf4j.Slf4j;
import org.lwason.sbprj.filter.MyServletFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyInitConfig {

    @Bean
    @ConditionalOnMissingBean(MyServletFilter.class)
    FilterRegistrationBean<MyServletFilter> getMyServletFilter() {
        FilterRegistrationBean<MyServletFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyServletFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }

}
