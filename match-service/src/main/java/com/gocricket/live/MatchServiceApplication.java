package com.gocricket.live;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MatchServiceApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(MatchServiceApplication.class, args);
	}
	@Bean
    ApplicationRunner runner(Environment env) {
        return args -> {
            System.out.println("API URL: " + env.getProperty("api.url"));
            System.out.println("API Offset: " + env.getProperty("api.offset"));
            System.out.println("API Key: " + env.getProperty("api.key"));
        };
    }

}
