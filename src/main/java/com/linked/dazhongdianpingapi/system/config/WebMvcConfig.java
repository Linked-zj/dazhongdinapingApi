package com.linked.dazhongdianpingapi.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author Lin
 * @date 2020/1/5
 */
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${uploadpicture.dir}")
    private String imagesPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").
                addResourceLocations("classpath:"+imagesPath);

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

