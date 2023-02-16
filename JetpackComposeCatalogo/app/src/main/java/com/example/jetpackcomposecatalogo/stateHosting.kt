package com.example.jetpackcomposecatalogo

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

// Objetivo, quitar estados de los composable

@Composable
fun MyTextFieldWithoutState(names:String, onValueChange:(String) -> Unit){
    TextField(value = names, onValueChange ={onValueChange(it)} )
}