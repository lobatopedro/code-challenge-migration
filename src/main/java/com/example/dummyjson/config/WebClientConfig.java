package com.example.dummyjson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for setting up and providing WebClient instances
 * used for making HTTP calls. This class leverages the Spring Framework's
 * configuration and dependency injection capabilities to create and manage
 * beans for application use.
 */
@Configuration
public class WebClientConfig {

    @Value("${dummyjson-api.base-url}")
    private String baseUrl;

    /**
     * Creates and configures a {@link WebClient} instance with the base URL
     * specified by the "dummyjson.base-url" property.
     *
     * This bean is qualified as "dummyJsonWebClient" and is intended for use
     * in performing HTTP operations against the configured base URL.
     *
     * @return an instance of {@link WebClient} preconfigured with the base URL.
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
