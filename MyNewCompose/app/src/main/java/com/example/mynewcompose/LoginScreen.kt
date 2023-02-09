package com.example.mynewcompose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.ui.theme.MyNewComposeTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


// Se puede ver solo la preview sin necesidad de ser llamada
// hay varias propiedades
// name -> nombre
// heightDp -> alto
// width -> ancho
// showbackground -> bool que muestra fondo de pantalla
// showSystemUi -> Muestra la vista desde el telefono
// apiLevel -> muestra como se veria en esa version de android porque podria cambiar
// locale -> muestra la traduccion
// device-> Devices.    Muestra el componente en un movil diferente
// las preview no pueden recibir parametros (se puede hacer un bypass)
// Ejemplo de componente en otra funcaion
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        Greeting("Android")
    }
}

