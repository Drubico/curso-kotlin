package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.data.LoginRepository
import com.example.jetpackcomposeinstagram.login.data.network.response.PersonajeResponse

class LoginUseCase {
    private val repository = LoginRepository()

    // invoke se llama en el viewModel (un caso de uso puede llamar a otro)
    // el invoke es como un metodo que se llama cuando se instancia la clase

    suspend operator fun invoke(user: String, password: String): PersonajeResponse? = repository.doLogin(user, password)
}