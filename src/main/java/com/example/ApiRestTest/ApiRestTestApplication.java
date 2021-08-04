package com.example.ApiRestTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.example.ApiRestTest.addresses"})
@SpringBootApplication
public class ApiRestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestTestApplication.class, args);
	}

}
