package com.nstane.userservice.controller

import com.nstane.userservice.entities.User
import com.nstane.userservice.repositories.UserRepository
import com.nstane.userservice.services.userdetails.LocalUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*


@RestController("/api/user")
class UserController(
        @Autowired val passwordEncoder: PasswordEncoder,
        @Autowired val userDetailsService: LocalUserDetailsService
) {

    @GetMapping
    fun users() = userDetailsService.findAll()

    @PostMapping
    fun register(@RequestBody user: User) = run {
        user.setPassWord(passwordEncoder.encode(user.password))
        userDetailsService.save(user)
    }

    /*@InitBinder
    fun initBinder(binder: WebDataBinder) {
        binder.addValidators(UserValidator())
    }*/

    /*@ModelAttribute
    fun csrfToken(exchange: ServerWebExchange): Mono<CsrfToken>? {
        val csrfToken: Mono<CsrfToken> = exchange.getAttribute<Mono<CsrfToken>>(CsrfToken::class.java.getName())!!
        return csrfToken.doOnSuccess(Consumer<CsrfToken> { token: CsrfToken? ->
            exchange.attributes[CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME] = token
        })
    }*/
}
