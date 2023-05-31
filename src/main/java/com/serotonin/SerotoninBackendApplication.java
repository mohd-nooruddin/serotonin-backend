package com.serotonin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.serotonin.service,com.serotonin.controller")
public class SerotoninBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerotoninBackendApplication.class, args);
		System.out.println("Server Started");
	}

}
