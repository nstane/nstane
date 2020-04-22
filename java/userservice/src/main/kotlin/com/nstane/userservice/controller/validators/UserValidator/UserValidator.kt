package com.nstane.userservice.controller.validators.UserValidator

import org.springframework.validation.Errors
import org.springframework.validation.Validator

class UserValidator : Validator {
    override fun validate(p0: Any, p1: Errors) {
        //TODO("Not yet implemented")
    }

    override fun supports(p0: Class<*>): Boolean = false
}
