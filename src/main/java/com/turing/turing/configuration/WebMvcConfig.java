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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin*").addPathPatterns("/pageAdmin*")
                .excludePathPatterns("/adminLogin");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:META-INF/resources/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:META-INF/resources/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:META-INF/resources/swagger-ui.html");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:webapp/static/");


    }

}
