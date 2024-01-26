package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService
@Inject constructor(
    private val loginClient: LoginClient
){
    suspend fun doLogin(user: String, password: String):PersonajeResponse? {

        // no tocas Dispatchers.Main porque es el hilo principal de la app
        // IO se usa para consumo de datos o persistencia de datos
        return withContext(Dispatchers.IO) {
            val response =loginClient.doLogin()
            response.body()
        }
    }
}