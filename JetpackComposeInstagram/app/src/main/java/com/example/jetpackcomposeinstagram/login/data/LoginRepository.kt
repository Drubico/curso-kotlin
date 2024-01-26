package com.example.jetpackcomposeinstagram.login.data

import com.example.jetpackcomposeinstagram.login.data.network.LoginService
import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginService: LoginService
){
    suspend fun doLogin(user: String, password: String): PersonajeResponse? = loginService.doLogin(user, password)
}