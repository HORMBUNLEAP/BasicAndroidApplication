package com.leap.basicApp.componant

import android.database.MergeCursor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCards(){

    var scroolState = rememberScrollState()
    val isDialop= remember { mutableStateOf(false) }
    var product by remember {
        mutableStateOf(
        ProductModel(
        id = "001",
        name = "Sport Shoes",
        price = 100.8,
        size = 44.5f,
        color = "White",
        orderCount = 0,
        image = R.drawable.nirkoun
    )) }
    if(isDialop.value){
        AlertDialog(
            title = {
                Text(
                    text = "Alert ",

                )
            },
            onDismissRequest = {
                println("DismiiRequest")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        isDialop.value = false
                    }
                ) {
                    Text(
                        text = "Okay",
                        )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.airplay_tv),
                    contentDescription = null
                )
            },
            text = {
                Text(
                    text = "This is a simple Dialog description."
                )
            },
            shape = RoundedCornerShape(8.dp),
            dismissButton = {
                FilledTonalButton(
                    onClick = {
                        isDialop.value = false
                    }
                ) {
                    Text(
                        text = "Cancel ",
                    )
                }
            }
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            isDialop.value = true
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close),
                            contentDescription = "Close"
                        )
                    }
                },

                title = {
                    Text(
                        text = stringResource(R.string.lbl_cards)
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700),
                    titleContentColor = colorResource(R.color.teal_200)
                )
            )
        }
    ) { padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(state = scroolState),

        ) {
            for (i in 1..20) {
                ElevatedCard (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(160.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryFixedVariant,
                        contentColor = MaterialTheme.colorScheme.inverseOnSurface
                    ),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 8.dp,
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary
                                )
                                .clip(shape = RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(150.dp),
                                painter = painterResource(product.image),
                                contentDescription = "",
                            )
                        }
                        Column(

                            modifier = Modifier.weight(1f),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 8.dp),
                                    text = product.name,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_delete),
                                        contentDescription = "Icon delete fro card"
                                    )

                                }
                            }
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Price : ${product.priceDisplay}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.errorContainer
                            )
                            Spacer(modifier = Modifier.weight(1f).padding(10.dp))
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Size : ${product.size}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                            Row(
                                modifier = Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,

                                ) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = "Color: ${product.color}",
                                    fontSize = 12.sp
                                )
                                // icon -
                                IconButton(
                                    onClick = {
                                        if (product.orderCount > 0) {
                                            product =
                                                product.copy(orderCount = product.orderCount - 1)
                                        }
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_minus),
                                        contentDescription = "Icon delete fro card"
                                    )

                                }
                                Text(
                                    modifier = Modifier.size(24.dp),

                                    text = "${product.orderCount}",
                                    textAlign = TextAlign.Center,

                                    )
                                // icon +
                                IconButton(
                                    onClick = {
                                        product = product.copy(orderCount = product.orderCount + 1)
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_plus),
                                        contentDescription = "Icon delete fro card"
                                    )

                                }
                            }
                        }
                    }

                }
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ScreenCardsPreview(){
    ScreenCards()
}
data class ProductModel(
    val id : String,
    val name: String,
    val price: Double,
    val size: Float,
    val color: String,
    var orderCount: Int,
    @DrawableRes val image: Int,
)

val ProductModel.priceDisplay get() = "$ $price"

var product = ProductModel(
    id = "001",
    name = "Sport Shoes",
    price = 100.8,
    size = 44.5f,
    color = "White",
    orderCount = 0,
    image = R.drawable.nirkoun
)