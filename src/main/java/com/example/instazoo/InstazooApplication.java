package com.example.instazoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.instazoo.service", "com.example.instazoo.security"})
@SpringBootApplication
public class InstazooApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstazooApplication.class, args);
	}

}
