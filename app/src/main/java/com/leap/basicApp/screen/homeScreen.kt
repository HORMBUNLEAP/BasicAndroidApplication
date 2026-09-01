package com.leap.basicApp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable

fun HomeScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        containerColor = MaterialTheme.colorScheme.primary
    ) { _->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                 .background(
                    color = MaterialTheme.colorScheme.primary
                )
                .padding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ,
        ) {
            for (i in 1..10){
                Text(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                    text = "${i}/.Hello",
                    fontSize = 23.sp
                )
            }

        }

    }
}

@Preview(showBackground = false)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}