package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Red,
        contentColor = Color.Green,
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

// surface -> es practicamente lo mismo que una card

@Composable
fun MyBadgeBox() {
    Column(Modifier.fillMaxWidth()) {

        BadgedBox(
            badge = { Badge(backgroundColor = Color.Blue, contentColor = Color.Green) { Text("4") } },
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        }
    }
}