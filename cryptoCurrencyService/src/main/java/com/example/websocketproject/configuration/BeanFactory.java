package com.example.websocketproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class BeanFactory {
    private static final String CURRATE_URL = "https://api.coinpaprika.com";

    @Bean
    public RestTemplate currateRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(CURRATE_URL));
        return restTemplate;
    }
}
