package com.leap.basicApp.componant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSingleChoiceSegmentedButton(){
    var label by remember { mutableStateOf(0) }
    val option = listOf("Day", "Week","Month")
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Single Choice Segment Button"
                    )

                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        },

    ) {padding->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16 .dp),
            ) {
                option.forEachIndexed { index, value ->
                    SegmentedButton(
                        selected = if (label == index) true else false,
                        onClick = {
                            label = index
                        },

                        label = {
                            Text(
                                text = value
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


            when(label){
                0->{
                    for (i in 1..10){
                        Text(
                            text = "Day ${i}"
                        )
                    }
                }
                1->{
                    for (i in 1..10){
                        Text(
                            text = "Week ${i}"
                        )
                    }
                }
                2->{
                    for (i in 1..10){
                        Text(
                            text = "Month ${i}"
                        )
                    }

                }
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
fun ScreenSingleChoiceSegmentedButtonPreview(){
    ScreenSingleChoiceSegmentedButton()
}