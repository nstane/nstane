package com.nstane.userservice

import com.nstane.userservice.entities.User
import com.nstane.userservice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
@EnableJpaRepositories
class UserserviceApplication(
		@Autowired
		val userRepository: UserRepository,
		@Autowired
		val passwordEncoder: PasswordEncoder
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		userRepository.save(User(1, "admin", passwordEncoder.encode("admin"), true, "ROLE_ADMIN"))
	}
}

fun main(args: Array<String>) {
	runApplication<UserserviceApplication>(*args)
}
