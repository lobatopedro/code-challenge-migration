package com.example.dummyjson.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Test class for performing a health check on the application's /actuator/health endpoint.
 *
 * This test ensures that the application responds with the correct status and includes
 * necessary health components like disk space when the health endpoint is accessed.
 *
 * Annotations:
 * - {@code @AutoConfigureWebTestClient}: Configures a WebTestClient for testing web requests.
 * - {@code @SpringBootTest}: Boots the application context and provides a full integration test
 *   environment. The {@code webEnvironment} is set to {@code RANDOM_PORT} to start the server
 *   on a random available port.
 *
 * Test Methods:
 * - {@code testHealthCheck}: Verifies that the health endpoint responds with an HTTP 200 status,
 *   confirms the application health status is "UP," and checks for the presence of health components,
 *   including the disk space component with its status as "UP."
 */
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthCheckTest {

    private static final String HEALTH_ENDPOINT = "/actuator/health";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testHealthCheck() {
        webTestClient.get()
                .uri(HEALTH_ENDPOINT)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP")
                .jsonPath("$.components").exists()
                .jsonPath("$.components.diskSpace.status").isEqualTo("UP");
    }

}
