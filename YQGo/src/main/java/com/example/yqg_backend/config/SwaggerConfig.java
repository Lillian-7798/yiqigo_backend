package com.example.yqg_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("User")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.yqg_backend.controller"))
                .build();
    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact=new Contact("Group 19",null,null);
        return new ApiInfo("一起购API文档",
                "一起购API文档",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}

