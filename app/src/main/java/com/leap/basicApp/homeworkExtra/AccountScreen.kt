package com.leap.basicApp.homeworkExtra


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(){
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },

                title = {
                    Text(
                        text = "Account"
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            println("you clicked icon")
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications),
                            contentDescription = "Notification"
                        )
                    }
                    IconButton(
                        onClick = {
                            println("you clicked icon")
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.more01),
                            contentDescription = "More"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        }
    ){padding ->


        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .background(color = colorResource(R.color.smoke_white)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Accounts",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "គណនី",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )

                    }
                    IconButton(
                        modifier = Modifier
                            .background(
                                shape = CircleShape,
                                color = colorResource(R.color.gray),
                            ),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_add),
                            contentDescription = "Search"

                        )
                    }

                }
            }
            Column() {
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(
                            color = colorResource(R.color.black_zin),
                            shape = RoundedCornerShape(20.dp)
                        ),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Total Balance",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(".")
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "សមតុល្យសរុប",
                                color = Color.White
                            )

                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row (
                            modifier = Modifier,
                        ) {
                            Text(
                                text = "$",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(
                                modifier = Modifier.width(5.dp)
                            )
                            Text(
                                text = "23,140.50",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            // ----------------- USD Box -----------------
                            Column(
                                modifier = Modifier
                                    .height(65.dp)
                                    .weight(1f)
                                    .background(
                                        color = colorResource(R.color.gray),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(start = 15.dp, top = 10.dp, end = 15.dp)
                                        .fillMaxSize(),
                                ) {
                                    Text(
                                        text = "USD · ដុល្លារ",
                                        color = Color(0xFF9EAEC3),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "$15,695.50",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(15.dp))

                            // ----------------- KHR Box -----------------
                            Column(
                                modifier = Modifier
                                    .height(65.dp)
                                    .weight(1f)
                                    .background(
                                        color = colorResource(R.color.gray),
                                        shape = RoundedCornerShape(20.dp)
                                    ),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .fillMaxSize(),
                                ) {
                                    Text(
                                        modifier = Modifier.padding(top = 15.dp),
                                        text = "KHR · រៀល",
                                        color = Color(0xFF9EAEC3),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = "៛29,780,000",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = "Converted at $1 = ៛4,000 (Sample Rate)"
                                ,
                                color = colorResource(R.color.red),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium

                            )
                        }


                    }
                }
            }

        }

    }

}




@Preview(showBackground = true, heightDp = 1000) // Giving it a fixed phone height helps the preview render scrollable content
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}