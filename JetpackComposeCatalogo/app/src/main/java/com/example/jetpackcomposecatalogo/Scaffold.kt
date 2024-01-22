package com.example.jetpackcomposecatalogo

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val corutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                (corutineScope.launch {

                    when (it) {
                        "back" -> scaffoldState.snackbarHostState.showSnackbar("Back")
                        "search" -> scaffoldState.snackbarHostState.showSnackbar("Search")
                        "close" -> scaffoldState.snackbarHostState.showSnackbar("Close")
                    }
                })
            }, onClickDrawer = {
                corutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        scaffoldState = scaffoldState,
        bottomBar = {
            MyBottomNavigation()
        },
        floatingActionButton = {
            MyFAB()
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            MyDrawer {
                corutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        drawerGesturesEnabled = false,
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit = {}) {
    TopAppBar(title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("close") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "close")
            }
        })
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableIntStateOf(0) }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = "home"
            )

        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Filled.Favorite, contentDescription = "Favorite"
            )

        }, label = { Text(text = "FAV") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Filled.Person, contentDescription = "person"
            )

        }, label = { Text(text = "Person") })
    }
}


@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ }, backgroundColor = Color.Yellow, contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit = {}) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primer item", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable {
                    onCloseDrawer()
                }
        )
        Text(
            text = "Segundo item", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable {
                    onCloseDrawer()
                }
        )
        Text(
            text = "Tercero item", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable {
                    onCloseDrawer()
                }
        )
        Text(
            text = "Cuarto item", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable {
                    onCloseDrawer()
                }
        )
    }
}