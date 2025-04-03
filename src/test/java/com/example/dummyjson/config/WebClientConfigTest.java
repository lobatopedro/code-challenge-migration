package com.example.dummyjson.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private WebClient webClient;

    @Test
    void testWebClientConfig(){
        Assertions.assertNotNull(webClient);
    }
}
