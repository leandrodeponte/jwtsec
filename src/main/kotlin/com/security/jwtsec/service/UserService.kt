package com.security.jwtsec.service

import com.security.jwtsec.domain.User
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService {

    val users = listOf(
        User(
            id = UUID.fromString("71d32f8e-3ab4-11ee-be56-0242ac120002"),
            name = "John",
            password = "$2a$12\$vVaOxmI2i4JsooIwct3I.uxVOX96L8fCtASlwLoMiBJJOzsYyPr4C"
        ),
        User(
            id = UUID.fromString("71d3324a-3ab4-11ee-be56-0242ac120002"),
            name = "Albert",
            password = "$2a$12\$vVaOxmI2i4JsooIwct3I.uxVOX96L8fCtASlwLoMiBJJOzsYyPr4C"
        ),
        User(
            id = UUID.fromString("71d333b2-3ab4-11ee-be56-0242ac120002"),
            name = "Bruno",
            password = "$2a$12\$vVaOxmI2i4JsooIwct3I.uxVOX96L8fCtASlwLoMiBJJOzsYyPr4C"
        )
    )

    fun findByName(name : String) =
        users.firstOrNull { it.name == name }

}
