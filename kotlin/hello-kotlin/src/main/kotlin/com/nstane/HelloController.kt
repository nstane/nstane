package com.nstane

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class HelloController {
	@GetMapping("/")
	fun hello() : String {
		return "Hello";
	}
}