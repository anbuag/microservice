package com.spring.california;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.california")
public class CaliforniaInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaliforniaInformationApplication.class, args);
	}

}
