package com.leap.basicApp.componant

import android.widget.CheckBox
import android.widget.RadioButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R
import kotlinx.coroutines.selects.select
import androidx.compose.material3.RadioButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadioButton(){
    val listOfSugar = listOf<OptionalModel>(
        OptionalModel(id = sugar.PERCENTAGE_00.code, label = "No Sugar"),
        OptionalModel(id = sugar.PERCENTAGE_25.code, label = "25%"),
        OptionalModel(id = sugar.PERCENTAGE_50.code,label = "50%"),
        OptionalModel(id = sugar.PERCENTAGE_75.code, label = "75%"),
        OptionalModel(id = sugar.PERCENTAGE_100.code, label = "100%"),
    )
    val listOfSelection = listOf<OptionalModel>(
        OptionalModel(id = size.SMALL.code, selected = false, label = "Small"),
        OptionalModel(id = size.MEDIUM.code, selected = false, label = "Medium"),
        OptionalModel(id = size.LARGE.code, selected = false, label = "Large"),
        OptionalModel(id = size.EXTRA_LARGE.code, selected = false, label = "Extra Large"),
    )
    val (selectSizeIndex, setSelectSizeIndex) =  remember { mutableStateOf(1) }
    val (selectSugarIndex, setSelectSugarIndex) =  remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back ),
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications),
                            contentDescription = ""
                        )
                    }
                },
                title = {
                    Text(
                        text = "Radio Button"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700),
                )
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text("Order Now")

            }
        }

    ) {padding->
         Column(
             modifier = Modifier
                 .padding(padding)
                 .fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.Start
         ) {
             /*
             Choose Select Sugar of Drink
              */
             Text(
                 modifier = Modifier.padding(horizontal = 16.dp),
                 text = "Sugar List",
                 fontSize = 16.sp,

             )
             listOfSugar.forEachIndexed { index, size ->
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(56.dp)
                         .clickable(
                             onClick = {
                                 setSelectSugarIndex(index)
                             }
                         ),
                     verticalAlignment = Alignment.CenterVertically

                 ) {
                     RadioButton(
                         onClick = {
                             setSelectSugarIndex(index)
                         },
                         selected = index == selectSugarIndex
                     )
                     Text(
                         text = size.label
                     )
                 }

             }
             HorizontalDivider()

             /*
             Section Select Size of Drink
              */
             Text(
                 modifier = Modifier.padding(16.dp),
                 text = "Select Size",
                 fontSize = 16.sp,
                 fontWeight = FontWeight.Bold
             )
             listOfSelection.forEachIndexed { index, size ->
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(56.dp)
                         .clickable(
                             onClick = {
                                 setSelectSizeIndex(index)
                             }
                         ),
                     verticalAlignment = Alignment.CenterVertically

                 ) {
                     RadioButton(
                         onClick = {
                             setSelectSizeIndex(index)
                         },
                         selected = index == selectSizeIndex
                     )
                     Text(
                         text = size.label
                     )
                 }
                 HorizontalDivider()
             }


         }
    }
}
/*
Use all case
 */
data class OptionalModel(
    val id : String,
    val selected: Boolean = false,
    val label : String,
    val enabled: Boolean = true
)
enum class size(val code: String){
    SMALL ("01"),
    MEDIUM("02"),
    LARGE("03"),
    EXTRA_LARGE("04")
}
enum class sugar(val code: String){
    PERCENTAGE_00 ("00"),
    PERCENTAGE_25 ("25"),
    PERCENTAGE_50 ("50"),
    PERCENTAGE_75 ("75"),
    PERCENTAGE_100 ("100"),

}

@Preview(showBackground = false)
@Composable
fun ScreenRadioButtonPreview(){
    ScreenRadioButton()

}