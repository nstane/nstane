package com.nstane.userservice.services.userdetails

import com.nstane.userservice.entities.User
import com.nstane.userservice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.function.Supplier

@Service
class LocalUserDetailsService(
        @Autowired
        val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(userName: String?): UserDetails = LocalUserDetails(
            userRepository.finByUserName(userName).orElseThrow {
                UsernameNotFoundException("Invalid username or password")
            }
    )

    fun save(user: User) = userRepository.save(user)

    fun findAll() = userRepository.findAll()
}

class LocalUserDetails(val user: User):UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>  = mutableListOf(SimpleGrantedAuthority(user.roles))

    override fun isEnabled(): Boolean = user.active

    override fun getUsername(): String = user.userName

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = user.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}
