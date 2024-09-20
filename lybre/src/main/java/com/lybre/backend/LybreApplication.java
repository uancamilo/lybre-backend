package com.lybre.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LybreApplication {

	public static void main(String[] args) {

		SpringApplication.run(LybreApplication.class, args);
		System.out.println("Mensaje");
	}

}
