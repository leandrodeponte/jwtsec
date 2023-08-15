package com.security.jwtsec.controller

import com.security.jwtsec.service.TokenService
import com.security.jwtsec.service.UserService
import com.security.jwtsec.service.HashService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController (
    private val hashService: HashService,
    private val tokenService: TokenService,
    private val userService: UserService,
) {

    @PostMapping("/login")
    fun login(@RequestBody payload: LoginDto): LoginResponseDto {
        val user = userService.findByName(payload.name) ?: throw ApiException(400, "Login failed")

        if (!hashService.checkBcrypt(payload.password, user.password)) {
            throw ApiException(400, "Login failed")
        }

        return LoginResponseDto(
            name = user.name,
            token = tokenService.createToken(user)
        )

    }
}

data class LoginDto(
    val name : String,
    val password : String
)

data class LoginResponseDto(
    val name : String,
    val token : String
)


