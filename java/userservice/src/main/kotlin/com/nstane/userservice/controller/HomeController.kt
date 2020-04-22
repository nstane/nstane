package com.nstane.userservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    @GetMapping("/")
    fun home() = "home"

    @GetMapping("/errorpage")
    fun error() = "error"

    @GetMapping("/dashboard")
    fun dashboard() = "dashboard"
}
