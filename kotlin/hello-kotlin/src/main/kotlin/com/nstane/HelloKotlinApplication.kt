package com.nstane

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class HelloKotlinApplication

fun main(args: Array<String>) {
    runApplication<HelloKotlinApplication>(*args)
}
