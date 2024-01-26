package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("character/2")
    suspend fun doLogin(): Response<PersonajeResponse>
}