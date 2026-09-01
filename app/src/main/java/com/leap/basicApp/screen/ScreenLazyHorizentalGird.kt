package com.leap.basicApp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R
import com.leap.basicApp.ui.font.fontFamily
import com.leap.basicApp.ui.font.fontFamily

@Composable

fun ScreenLazyHorizontalGird(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        containerColor = MaterialTheme.colorScheme.primary
    ) { padding->
        Column(
            modifier = Modifier.padding(padding )
                .fillMaxSize(),

        ) {
            LazyHorizontalGrid(
                modifier = Modifier
                    .height(192.dp + 16.dp + 24.dp)
                    .border(width =2.dp,color = Color.Red)
                ,

                contentPadding = PaddingValues(5.dp),
                rows = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(30){index->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(64.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(R.drawable.nirkoun),
                            contentDescription = "Image 01",
                        )
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(
                                text = "Destiny",
                                fontSize = 16.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold

                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically

                            ) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle ,
                                    contentDescription = "",
                                )
                                Text(
                                    text = "Mann Doss ",
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Normal
                                )
                                VerticalDivider()
                                Text(
                                    text = " 130M Plays",
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Light 
                                )
                            }


                        }
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                                onClick = {}
                                ) {
                            Icon(
                                painter = painterResource(R.drawable.more01 ),
                                contentDescription = ""
                            )
                        }

                    }
                }
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenLazyHorizentalGirdPreview(){
    ScreenLazyHorizontalGird()
}