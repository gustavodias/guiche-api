package com.jvge.guicheapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class GuicheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuicheApiApplication.class, args);
	}

}
