package com.example.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Configuration
public class RequestFilters implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtFilters())
                //拦截的路径
                .addPathPatterns("/**")
                //排除登录接口
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/test");

    }
}
