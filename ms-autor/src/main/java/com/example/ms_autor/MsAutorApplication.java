package com.example.ms_autor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsAutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAutorApplication.class, args);
	}

}
