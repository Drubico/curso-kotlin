package com.example.jetpackcomposecatalogo.model

import androidx.annotation.DrawableRes

data class Superhero(
    var superheroName: String,
    var realname: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
