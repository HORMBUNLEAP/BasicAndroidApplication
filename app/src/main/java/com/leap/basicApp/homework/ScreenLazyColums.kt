package com.leap.basicApp.homework

import android.hardware.camera2.params.MeteringRectangle
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.createFromText
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable

fun ScreenLazyColum(){
    data class Account01(
        val principle: Double,
        val interestAmount: Double,
        val currency: String,
    ){
        operator fun plus(amount: Account01): Account01{
            return Account01(principle = principle+amount.principle,interestAmount = interestAmount+ amount.interestAmount, currency)
        }
    }
    val accountList = listOf(
        Account01(1000.0, 50.0, "USD"),
        Account01(1500.0, 75.0, "KHR"),
        Account01(2000.0, 100.0, "USD"),
        Account01(2500.0, 125.0, "KHR"),
        Account01(3000.0, 150.0, "USD"),
        Account01(3500.0, 175.0, "KHR"),
        Account01(4000.0, 200.0, "USD"),
        Account01(4500.0, 225.0, "KHR"),
        Account01(5000.0, 250.0, "USD"),
        Account01(5500.0, 275.0, "KHR")
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { padding->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            /*
            - 1. item: just using row column sample only
            - 2. items : don't use the loop for caught data from index
            - 3. itemIndex :

             */
            item{
                Box(
                    modifier = Modifier.fillMaxWidth().height(100.dp)
                        .background(color = Color.Red),

                )
            }

            itemsIndexed(
                items = accountList,
                key = {_, item-> item.principle  },
            ){

                _, account->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(56.dp)
                        .background(color = MaterialTheme.colorScheme.primary.copy(0.2f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "${account.principle}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "${account.interestAmount}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = account.currency,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                }
            }
        }


    }
}

@Preview(showBackground = false)
@Composable
fun LazyColumPreview(){
    ScreenLazyColum()
}