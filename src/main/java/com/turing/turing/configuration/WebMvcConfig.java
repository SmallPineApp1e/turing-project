package com.turing.turing.configuration;

import com.turing.turing.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jack
 * @date 2019-03-31-18:29
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private String uploadFolder = "/home/upload/";
//    private String uploadFolder = "d://upload/";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin*").addPathPatterns("/pageAdmin*")
                .excludePathPatterns("/adminLogin");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/html/**")
                .addResourceLocations("classpath:/html/");

        registry.addResourceHandler("/static/img/**")
                .addResourceLocations("classpath:/static/img/")
                .addResourceLocations("file:///"+uploadFolder);

        registry.addResourceHandler("/static/css/**")
                .addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/static/js/**")
                .addResourceLocations("classpath:/static/js/");

    }

}
