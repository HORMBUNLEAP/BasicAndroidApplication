package com.leap.basicApp.homeworkExtra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R
import com.leap.basicApp.model.DashboardModel
import com.leap.basicApp.model.PromotionModel
import com.leap.basicApp.ui.theme.BasicAndroidApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()
    val items = arrayListOf<DashboardModel>(
        DashboardModel(
            id = "001",
            label = "Transfer",
            labelKH = "ផ្ទេរ",
            iconRes = R.drawable.transfer_mon,
            isEnable = true
        ),
        DashboardModel(
            id = "002",
            label = "Pay Bill",
            labelKH = "បង់វិក្កយបត្រ",
            iconRes = R.drawable.pay_bill,
            isEnable = true
        ),
        DashboardModel(
            id = "003",
            label = "Top Up",
            labelKH = "បញ្ចូលទឹកប្រាក់",
            iconRes = R.drawable.top_up,
            isEnable = true
        ),
        DashboardModel(
            id = "004",
            label = "Scan QR",
            labelKH = "ស្កេន",
            iconRes = R.drawable.qrcode,
            isEnable = true
        ),
        DashboardModel(
            id = "005",
            label = "Loans",
            labelKH = "កម្ចី",
            iconRes = R.drawable.loan,
            isEnable = true
        ),
        DashboardModel(
            id = "006",
            label = "Cards",
            labelKH = "កាត",
            iconRes = R.drawable.card,
            isEnable = true
        ),
        DashboardModel(
            id = "007",
            label = "Exchange",
            labelKH = "ប្តូរប្រាក់",
            iconRes = R.drawable.exchange,
            isEnable = true
        ),
        DashboardModel(
            id = "008",
            label = "More",
            labelKH = "ផ្សេងៗ",
            iconRes = R.drawable.more01,
            isEnable = true
        )
    )
    val promotion = arrayListOf<PromotionModel>(
        PromotionModel(
            label = "0% fee transfers",
            functionKHR = "ផ្ទេរមិនគិតកម្រៃ",
            date = "Until Oct 31",
            colorRes = R.color.black_zin
        ),
        PromotionModel(
            label = "Earn 4.5",
            functionKHR = "ផ្ទេរមិនគិតកម្រៃ",
            date = "Until Oct 31",
            colorRes = R.color.purple_700
        )

    )

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
                        text = "Account Bank Tab"
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
    ) {


        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .background(color = colorResource(R.color.smoke_white)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(16.dp, 5.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF0F172A)), // Dark blue/black background
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "SK",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(
                        modifier = Modifier.width(240.dp)
                    ) {
                        Text(
                            "សួស្តី · Good morning",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "Sokha Kim",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                    }
                    FilledIconButton(
                        onClick = {}
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.outline_notifications),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
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
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Saving",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(".")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "សន្សំ **** 4821",
                            color = Color.White
                        )
                        Button(
                            onClick = {},
                            contentPadding = PaddingValues(
                                horizontal = 12.dp,
                                vertical = 3.dp
                            ),
                        ) {
                            Text(

                                text = "Default"
                            )
                        }

                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Available Balance",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "$12,480,50",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        HorizontalDivider(thickness = 2.dp)
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "KHR",
                                fontSize = 14.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(".")
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "រៀល *** 1190",
                                color = Color.White
                            )
                        }
                        Text(
                            text = "៛25,600,000",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )

                    }
                    Button(
                        onClick = {},
                        contentPadding = PaddingValues(
                            horizontal = 12.dp,
                            vertical = 3.dp
                        )
                    ) {
                        Text(

                            text = "All Accounts"
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(0.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Banking Services",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "សេវាធនាគារ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(230.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(20.dp),

                        ),
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    for (rowItems in items.chunked(4)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            for (item in rowItems) {

                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .size(56.dp)
                                            .background(
                                                color = colorResource(R.color.blue_200), // Calls the color from the current list item
                                                shape = RoundedCornerShape(16.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {

                                        Icon(
                                            modifier = Modifier.size(32.dp),
                                            painter = painterResource(id = item.iconRes),
                                            contentDescription = item.label
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 6.dp),
                                        text = item.label,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        maxLines = 1
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 2.dp),
                                        text = item.labelKH,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 11.sp,
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Promotions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "ប្រម៉ូលសិន",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }

            // Removed redundant LazyColumn wrapper that caused IllegalStateException due to nested vertical scrolling
            LazyRow(
                modifier = Modifier,
            ) {
                items(promotion.size) { index ->
                    Box(
                        modifier = Modifier
                            .width(280.dp)
                            .height(130.dp)
                            .background(
                                color = colorResource(id = promotion[index].colorRes),
                                shape = RoundedCornerShape(16.dp)
                            ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 0.dp),
                        ) {
                            Text(
                                text = promotion[index].label,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .weight(1f),
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = promotion[index].functionKHR,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Light,
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(".")
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = promotion[index].date,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Light,
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Schedule",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "កាលវិភាគ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(240.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(20.dp),
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 0.dp)
                ) {
                    // Item 1
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), // Takes 1/3 of the height
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row() {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(70.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(52.dp)
                                        .background(
                                            color = colorResource(id = R.color.smoke_white),
                                            shape = RoundedCornerShape(size = 16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(-5.dp)
                                    ) {
                                        Text(
                                            text = "Oct",
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp
                                        )
                                        Text(
                                            text = "20",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        )
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(-5.dp)
                                ) {
                                    Text(
                                        text = "Rent",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Standing order",
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp
                                    )

                                }

                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "-$350.00",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        thickness = 1.dp,
                        color = Color.LightGray.copy(alpha = 0.5f)
                    )

                    // Item 2
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), // Takes 1/3 of the height
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row() {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(70.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(52.dp)
                                        .background(
                                            color = colorResource(id = R.color.smoke_white),
                                            shape = RoundedCornerShape(size = 16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(-5.dp)
                                    ) {
                                        Text(
                                            text = "Oct",
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp
                                        )
                                        Text(
                                            text = "25",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        )
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(-5.dp)
                                ) {
                                    Text(
                                        text = "Electricity bill",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Auto pay",
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp
                                    )

                                }

                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "-៛1330.00",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = Color.LightGray.copy(alpha = 0.5f)
                    )

                    // Item 3
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), // Takes 1/3 of the height
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row() {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(70.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(52.dp)
                                        .background(
                                            color = colorResource(id = R.color.smoke_white),
                                            shape = RoundedCornerShape(size = 16.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(-5.dp)
                                    ) {
                                        Text(
                                            text = "Nov",
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp
                                        )
                                        Text(
                                            text = "01",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        )
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(-5.dp)
                                ) {
                                    Text(
                                        text = "Loan repayment",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Due in 16 days",
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp
                                    )

                                }

                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "-$350.00",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Promotions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "ប្រម៉ូលសិន",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(120.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(16.dp)
                    ),
            )
            {
                Row(
                    modifier = Modifier,

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (i in 1..4) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(16.dp)
                                .weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(58.dp)
                                    .background(
                                        color = colorResource(R.color.blue_200), // Calls the color from the current list item
                                        shape = RoundedCornerShape(100)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(R.drawable.top_up),
                                    contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                modifier = Modifier.padding(top = 6.dp),
                                text = "hello",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                maxLines = 1
                            )
                        }
                    }

                }
            }
        }
    }

}




@Preview(showBackground = true, heightDp = 2000) // Giving it a fixed phone height helps the preview render scrollable content
@Composable
fun HomeScreenPreview() {
    BasicAndroidApplicationTheme { // Or whatever your app theme is called
        HomeScreen()
    }
}