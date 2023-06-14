package com.rentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.rentals")
@PropertySource("classpath:mysql.properties")
public class ZoominRentalsApplication {

	@Autowired
	//The config data in mysql.properties is added in Environment, if @PropertySource("classpath:mysql.properties") is given
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(ZoominRentalsApplication.class, args);
	}

}
