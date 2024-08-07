package com.example.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class MyAppApplication {
	public static void main(String[] args) {

		SpringApplication.run(MyAppApplication.class, args);
	}

}
