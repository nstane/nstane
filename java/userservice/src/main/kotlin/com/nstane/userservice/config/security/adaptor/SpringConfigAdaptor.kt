package com.nstane.userservice.config.security.adaptor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SpringConfigAdaptor(@Qualifier("localUserDetailsService") @Autowired val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(this.userDetailsService)?.passwordEncoder(getPasswordEncoder()).runCatching { throw Exception("Invalid User Name or password") }
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests {
            it.antMatchers("/api/**").authenticated()
                    .antMatchers("/dashboard").hasRole( "ADMIN") // Roles in DB should start with ROLE_
                    .antMatchers("/", "/register","/demo", "/home").permitAll()
                    .and().formLogin()
                    .and().httpBasic()
                    .and().logout()
                    .logoutUrl("/logout").permitAll()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
        }
        http?.csrf()?.disable()  // disable CSRF for post request Note : this should not be disabled

        http?.headers()?.frameOptions()?.disable()  // enable h2db console this also not be disabled
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder = DelegatingPasswordEncoder(BCRYPE, mapOf(Pair(BCRYPE, BCryptPasswordEncoder())))

    companion object {
        const val BCRYPE = "bcrypt"
    }
}
