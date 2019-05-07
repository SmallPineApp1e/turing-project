package com.turing.turing.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * @author Jack
 * @date 2019-05-05-13:00
 */
public class UploadFileConfig {

    private String uploadFolder = "/home/upload/";

    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        return factory.createMultipartConfig();
    }

}
