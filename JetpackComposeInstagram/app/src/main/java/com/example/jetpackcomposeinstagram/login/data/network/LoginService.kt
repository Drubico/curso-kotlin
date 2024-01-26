package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.core.network.RetrofitHelper
import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String):PersonajeResponse? {

        // no tocas Dispatchers.Main porque es el hilo principal de la app
        // IO se usa para consumo de datos o persistencia de datos
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()
        }
    }
}