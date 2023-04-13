package com.benfica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.benfica.controller"})
@ComponentScan({"com.benfica.service"})
@EntityScan(basePackages = {"com.benfica.model"})
@EnableJpaRepositories(basePackages = "com.benfica.repository")
public class BenficaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenficaApiApplication.class, args);
	}

}
