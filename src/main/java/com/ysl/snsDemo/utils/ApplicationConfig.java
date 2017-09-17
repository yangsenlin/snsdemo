package com.ysl.snsDemo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ysl.snsDemo.interceptor.LogInterceptor;

@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 注册自定义拦截器
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
