package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerView() {
    val myList = listOf(
        "Aris", "Pepe", "Manolo", " Jaime "
    );
    LazyColumn {
        item {
            Text(text = "Primer item")
        }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }

    }
}