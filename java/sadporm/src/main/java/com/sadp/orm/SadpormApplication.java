package com.sadp.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sadp.orm.dto.User;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SadpormApplication {

	public static void main(String[] args) {
		SpringApplication.run(SadpormApplication.class, args);
	}

	@Component
	@Order(value = 1)
	class UserComponent implements CommandLineRunner {
		@Autowired
		private com.sadp.orm.repo.UserRepository userRepo;

		@Override
		public void run(String... arg0) throws Exception {
			userRepo.save(new User("Naren"));
			System.out.println(
					"---------------------------------------------------------------------------------------------");
			for (User person : userRepo.findAll()) {
				System.out.println(person.toString());
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}
	}
}
