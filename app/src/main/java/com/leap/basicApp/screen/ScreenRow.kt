package com.leap.basicApp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable

fun ScreenRow(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { padding->
        Column(
            modifier = Modifier
                .padding(padding )
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(0.5f)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically


            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .weight(0.5f),
                    text = "Hello Row",
                    fontSize = 23.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 22.dp)
                        .padding(vertical = 21.dp)
                        .weight(0.5f),

                    text = "Hello Row",
                    fontSize = 23.sp
                )
            }


        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenRowPreview(){
    ScreenRow()
}