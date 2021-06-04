package com.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com")
public class FlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyApplication.class, args);
	}

}
