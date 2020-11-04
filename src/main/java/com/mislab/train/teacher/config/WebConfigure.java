package com.mislab.train.teacher.config;

import com.mislab.train.teacher.common.TeaLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张烈文
 */
@Configuration
public class WebConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TeaLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/teacher/**");

    }



}
