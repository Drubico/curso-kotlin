package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.data.CheckInfo
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldExample()                }
            }
        }
    }

    @Composable
    fun getOptions(title: List<String>): List<CheckInfo> {
        return title.map {
            var status by rememberSaveable {
                mutableStateOf(false)
            }
            CheckInfo(title = it, selected = status, onCheckedChange = { status = it })
        }
    }

    @Composable
    fun MyComplexLayout() {
        Column(Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 1", color = Color.Blue)
            }
            MySpacer(size = 80)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Ejemplo 2")
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Ejemplo 3")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Red),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = "Ejemplo 4", textAlign = TextAlign.Center)
            }
        }
    }

    @Composable
    fun MySpacer(size: Int) {
        Spacer(modifier = Modifier.size(size.dp))
    }


    @Composable
    fun MyColumn() {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Red))
            Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Cyan))
            Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Black))
            Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
        }
    }

    @Composable
    fun MyRow() {
        Row(
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Red))
            Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Cyan))
            Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Black))
            Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
            Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
            Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
            Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
        }
    }

    // * Modifier.fillMaxSize() -> Toda la pantalla
// * contentAlignment = Alignment.Center -> Las cosas al centro
    @Composable
    fun MyBox() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Cyan)
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.BottomCenter
            ) {

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetpackComposeCatalogoTheme {
            // MyBox()
            // MyColumn()
            // MyRow()
            //MyComplexLayout()
            // MyStateExample()
            MyText()
        }
    }
}