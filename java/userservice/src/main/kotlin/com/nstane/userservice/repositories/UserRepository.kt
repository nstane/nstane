package com.nstane.userservice.repositories

import com.nstane.userservice.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {

    @Query("Select u from User u where u.userName = ?1 ")
    fun finByUserName(userName: String?): Optional<User>
}
