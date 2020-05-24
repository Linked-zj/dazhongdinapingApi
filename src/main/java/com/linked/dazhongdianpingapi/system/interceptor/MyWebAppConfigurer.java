package com.linked.dazhongdianpingapi.system.interceptor;

import com.linked.dazhongdianpingapi.system.interceptor.customInterceptors.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: Cookie
 * @Date: 2019/1/15 10:41
 * @Description: 基础拦截器
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
