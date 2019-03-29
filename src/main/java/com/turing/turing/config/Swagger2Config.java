package com.turing.turing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jack
 * @date 2019-03-27-18:54
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket guestControllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("前台用户API接口文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("图灵二轮考核接口文档")
                        .description("用于图灵团队的招新及对团队进行介绍,用户可投递简历,看到团队的各种信息")
                        .contact(new Contact("曾智杰",null , "jie534838094@163.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turing.turing.guest"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket adminControllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理API接口文档")
                .apiInfo(new ApiInfoBuilder()
                        .title("图灵二轮考核接口文档")
                        .description("用于图灵团队的各项信息管理")
                        .contact(new Contact("曾智杰", null, "jie534838094@163.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turing.turing.admin"))
                .paths(PathSelectors.any())
                .build();
    }

}
