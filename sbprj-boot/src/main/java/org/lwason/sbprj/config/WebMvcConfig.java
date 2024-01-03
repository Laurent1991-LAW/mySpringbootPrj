package org.lwason.sbprj.config;

import lombok.extern.slf4j.Slf4j;
import org.lwason.sbprj.filter.FilterA;
import org.lwason.sbprj.filter.FilterB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${plt.authority.isAFilter}")
    private Boolean isFilterA;

    @Resource
    FilterA filterA;
    @Resource
    FilterB filterB;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       if (Objects.isNull(this.isFilterA)) {
           // throw exception
       }
       registry.addInterceptor(this.isFilterA ? filterA : filterB);
    }

    //@EventListener
    //public void onRefreshedScope() {
        // remove filterA and filterB
        // codes...
        // re-add filter based on new 'isFilterA' value
        // codes...
    //}

}
