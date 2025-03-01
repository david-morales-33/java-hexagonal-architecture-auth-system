package com.dmx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.dmx.auth")
@ComponentScan(basePackages = {"com.dmx.auth", "com.dmx.server"})
@EnableJpaRepositories(basePackages = "com.dmx.auth")
public class AuthencicationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthencicationSystemApplication.class, args);
	}

}
