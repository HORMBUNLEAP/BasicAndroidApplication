package com.leap.basicApp.screen

import android.graphics.ColorSpace
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.leap.basicApp.R
import com.leap.basicApp.model.foodList


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenLazyRowP2(){
    val foods = foodList
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title ={
                    Text("Lazy Row ")
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
        floatingActionButton = {

        },
        bottomBar = {

        }
    ) { padding->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            item {
                LazyRow (
                    modifier = Modifier.padding(paddingValues = padding)
                ) {
                    items(foods.size){
                        index->
                        Box(
                            modifier = Modifier.size(120.dp),
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(
                                        color = MaterialTheme.colorScheme.secondary,
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                                contentDescription = "Localized description"
//                            )
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(foods[index].image),
                                    contentDescription = foods[index].label,
                                )
                                Text(
                                    text = "ClassRoom C++",
                                    fontSize = 16.sp
                                )

                            }
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.Red)

                                ,
                                contentAlignment = Alignment.Center,

                            ){
                                Text(
                                    text = "${foods[index].id}",
                                    fontWeight = FontWeight.Bold,


                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenLazyRowPreviewP2(){
    ScreenLazyRowP2()
}