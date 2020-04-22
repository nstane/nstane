package com.budgetShoe

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class BudgetShoeApplication

public fun main(args: Array<String>) {
	SpringApplication.run(BudgetShoeApplication::class.java, *args)
}
