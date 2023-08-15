package com.security.jwtsec.domain

import java.util.UUID

data class User (
    val id : UUID,
    val name : String,
    val password : String
)