package com.ccm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CreditCardManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardManageApplication.class, args);
	}
}
