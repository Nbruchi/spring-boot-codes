package com.bruce.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
    @Bean
    public FirstClass firstClass(){
        return new FirstClass("First bean");
    }

    @Bean
    public FirstClass secondBean(){
        return new FirstClass("Second bean");
    }

    @Bean
    public FirstClass thirdBean(){
        return new FirstClass("Third bean");
    }
}
