package com.leap.basicApp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenBox(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        containerColor = MaterialTheme.colorScheme.primary
        topBar = {
            TopAppBar(
                title ={
                    Text("Box ")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    ) { padding->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.DarkGray)
            ,
            contentAlignment = Alignment.Center


        ){
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(color = Color.Blue)
            )
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(200.dp)
                    .background(color = Color.Red)
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenBoxPerview(){
    ScreenBox()
}