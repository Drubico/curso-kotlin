package com.example.jetpackcomposeinstagram.login.data

import com.example.jetpackcomposeinstagram.login.data.network.LoginService
import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse

class LoginRepository {
    private val api = LoginService()
    suspend fun doLogin(user: String, password: String): PersonajeResponse? = api.doLogin(user, password)
}