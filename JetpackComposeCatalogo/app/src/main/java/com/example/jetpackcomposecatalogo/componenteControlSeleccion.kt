package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySwitch() {
    var estado by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = estado,
        onCheckedChange = { estado = !estado },
        enabled = false,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.1f,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow
        )
    )
}

@Composable
fun MyCheckBox() {
    var estado by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = estado,
        onCheckedChange = { estado = !estado },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red, uncheckedColor = Color.Yellow, checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var estado by rememberSaveable { mutableStateOf(true) }
    Column(Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(8.dp)) {
            Checkbox(checked = estado, onCheckedChange = { estado = !estado })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ejemplo 1")
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Checkbox(checked = estado, onCheckedChange = { estado = !estado })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ejemplo 2")
        }
    }
}