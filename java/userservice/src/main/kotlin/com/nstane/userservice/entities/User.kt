package com.nstane.userservice.entities

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.*

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var userName: String,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        var password: String,
        val active: Boolean,
        val roles: String
) {
        fun setPassWord(password: String) {
                this.password = password
        }
}
