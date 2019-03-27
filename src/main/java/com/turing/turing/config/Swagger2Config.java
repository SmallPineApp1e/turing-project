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
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：图灵二轮考核接口文档")
                        .description("描述：用于图灵团队的招新及对团队进行介绍,具体包括前台用户,后台管理模块...")
                        .contact(new Contact("一只袜子", null, null))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.turing.turing"))
                .paths(PathSelectors.any())
                .build();
    }

}
