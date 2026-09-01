package com.leap.basicApp.screen

import android.graphics.drawable.PaintDrawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R
import com.leap.basicApp.storage.visaCardArray
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenHorizontalPager(){
    val accounts = visaCardArray
    val pagerStats = rememberPagerState(pageCount = { accounts.size})


    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        containerColor = MaterialTheme.colorScheme.primary
        topBar = {
            TopAppBar(
                title ={
                    Text("Horizontal Pager")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White

                ),
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "MoreVert"
                        )
                    }
                }
            )

        },

    ) { padding->
        HorizontalPager(
            modifier = Modifier
                .wrapContentHeight()
                .padding(paddingValues = padding),
            state = pagerStats,
            contentPadding = PaddingValues(16.dp),
            pageSpacing = 8.dp
        ) {pager->
            val account = accounts[pager]
            Box(
                modifier = Modifier
                    .height(250.dp)

                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface),

                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.rectangle_19),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(16.dp),

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            ,
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween
                    ) {
                        Text(
                            text =account.cardHolderName,
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = 16.sp
                        )

                        Text(
                            text = "${account.cardType}"
                        )

                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text ="Balance",
                        color = MaterialTheme.colorScheme.surface,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth( )
                            ,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text ="${account.currencyCode}",
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = 12.sp
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text =account.availableBalance.toString() ,
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "MoreVert"
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
fun ScreenHorizontalPagerPerview(){
    ScreenHorizontalPager()
}