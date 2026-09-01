package com.leap.basicApp.homework

import android.R.attr.label
import android.R.attr.text
import android.hardware.camera2.params.MeteringRectangle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.createFromText
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R
import com.leap.basicApp.model.datelist
import org.w3c.dom.Text
import com.leap.basicApp.model.foodList
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ScreenABA(){
    var selectedIndex by remember { mutableStateOf(0) }
    val option = listOf( "My Alert","Transactions", "Announcements" )
    val foods = foodList
    var text by remember { mutableStateOf(0) }
    val date = datelist

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.icon),
                            contentDescription = ""
                        )
                        Text("Notifications")

                    }

                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
    ) {padding ->
        Column(
            modifier = Modifier.padding(padding).fillMaxWidth(),
        ) {
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10 .dp),
            ) {
                option.forEachIndexed { index, value ->
                    SegmentedButton(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },

                        label = {
                            Text(
                                modifier = Modifier,
                                text = value,
                                fontSize = 12.sp
                            )
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primary,
                            inactiveBorderColor = MaterialTheme.colorScheme.error
                        )
                    )
                }

            }
            when(selectedIndex){
                0 ->{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.Top

                    ) {

                        items(foods.size) {
                                index->
                            val itemDate = date.getOrNull(index)?.formattedDate ?: ""
                            Text(
                                text = itemDate
                            )

                            Box(
                                modifier = Modifier.fillMaxWidth()
                                    .height(140.dp),
                                contentAlignment = Alignment.BottomStart,

                                ){
                                Image(
                                    painter = painterResource(foods[index].image),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                                foods.forEach { index ->
                                    Text(
                                        text = index.description,
                                        color = MaterialTheme.colorScheme.error,
                                        fontSize = 8.sp,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
                1->{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.Top

                    ) {
                        items(10) { i ->
                            Text(
                                text = "Transaction #${i + 1}",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
                2->{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.Top

                    ) {
                        items(10) { i ->
                            Text(
                                text = "Announcement #${i + 1}",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }

                }



            }
        }

//        LazyVerticalGrid(
//            modifier = Modifier.padding(padding),
//            columns = GridCells.Fixed(1),
//            contentPadding = PaddingValues(8.dp),
//            verticalArrangement = Arrangement.spacedBy(24.dp),
//            horizontalArrangement = Arrangement.spacedBy(10.dp)
//        ) {
//            items(foods.size) { index ->
//                Box(
//                    modifier = Modifier.fillMaxWidth()
//                        .height(180.dp),
//                    contentAlignment = Alignment.BottomStart,
//
//                    ) {
//                    Image(
//                        painter = painterResource(id = foods[index].image),
//                        contentDescription = "background",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                    foods.forEach { index ->
//                        Text(
//                            text = index.description,
//                            color = MaterialTheme.colorScheme.error,
//                            fontSize = 24.sp,
//                            modifier = Modifier.padding(16.dp)
//                        )
//                    }
//
//                }
//
//            }
//
//
//
//        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenABAPreview(){
    ScreenABA()
}