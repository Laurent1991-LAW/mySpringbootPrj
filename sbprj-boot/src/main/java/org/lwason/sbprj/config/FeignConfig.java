package org.lwason.sbprj.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor getHeaderInterceptor() {
        return template -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (!Objects.isNull(attributes)) {
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (!Objects.isNull(headerNames)) {
                    while(headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String value =  request.getHeader(name);
                        template.header(name,value);
                    }
                }
            }
        };
    }

}
