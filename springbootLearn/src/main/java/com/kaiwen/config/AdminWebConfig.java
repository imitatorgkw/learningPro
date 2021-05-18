package com.kaiwen.config;

import com.kaiwen.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer配置类其实是Spring内部的一种配置方式
 * 采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制
 * @Configuration用于定义配置类，可替换xml配置文件
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截的路径,把静态资源也拦住了
                .excludePathPatterns("/", "/hello", "/images/**");//放行的路径

    }
}
