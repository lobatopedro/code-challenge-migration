package com.example.dummyjson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the DummyJsonClientApplication.
 *
 * This class initializes and runs the Spring Boot application. It serves as the main
 * configuration and launching point for the application by invoking the SpringApplication.run
 * method with the class reference and program arguments.
 */
@SpringBootApplication
public class DummyJsonClientApplication {

    /**
     * The entry point of the application.
     *
     * This method launches the Spring Boot application by invoking the SpringApplication.run method.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(DummyJsonClientApplication.class, args);
    }
}
