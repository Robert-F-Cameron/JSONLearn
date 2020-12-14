package com.galvanize.FlightEndpoints;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.JavaBean;

@Configuration
public class Config {
    @Bean
    public WordCounter wordCounter() {
        return new WordCounter();
    }
}
