package com.example.yqg_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //路径与图片上传路径一致
        registry.addResourceHandler("/image/**").addResourceLocations("file:C:/Users/YUXU/Desktop/YQG_backend/YQGo/src/main/resources/static/image/");
    }
}
