package com.security.jwtsec.controller

class ApiException(httpCode : Int, message : String) : Exception(message)