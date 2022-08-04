package vn.codegym.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messageError");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
