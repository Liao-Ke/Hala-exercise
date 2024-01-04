package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//等同于<context:component-scan base-package="com.itheima.controller"/>
@ComponentScan("com.itheima.controller")
//等同于<mvc:annotation-driven/>，还不完全相同
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("static/**")
                .addResourceLocations("/static/");
        registry.addResourceHandler("image/**")
                .addResourceLocations("/files/");
        super.addResourceHandlers(registry);
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}


