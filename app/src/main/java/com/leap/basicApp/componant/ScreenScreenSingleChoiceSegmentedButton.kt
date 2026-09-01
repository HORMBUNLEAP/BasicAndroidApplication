package com.leap.basicApp.componant

import android.R.attr.value
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
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
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
fun ScreenMultiChoiceSegmentedButton(){
    val selectedOptions = remember { mutableStateListOf(false, false, false) }
    val options = listOf("walk", "run","sleep")

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Multi Choice Segmented Button"
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
            MultiChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            ) {
                options.forEachIndexed { index, value ->
                    SegmentedButton(
                        shape = RoundedCornerShape(8.dp),
                        checked = selectedOptions[index],
                        modifier = Modifier.weight(1f),
                        onCheckedChange = { isChange ->
                            selectedOptions[index]= isChange
                            println(selectedOptions)
                        },
                        label = { 
                            when(value){
                                "walk"->{
                                    Icon(
                                        painter = painterResource(R.drawable.airplay_tv),
                                        contentDescription = ""
                                    )
                                }
                                "run"->{
                                    Icon(
                                        painter = painterResource(R.drawable.close),
                                        contentDescription = null
                                    )
                                }
                                "sleep"->{
                                    Icon(
                                        painter = painterResource(R.drawable.outline_notifications),
                                        contentDescription = ""
                                    )
                                }
                            }
                        },
                        icon = {
                            SegmentedButtonDefaults.Icon(selectedOptions[index])
                        }

                    )
                }
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
fun ScreenMultiChoiceSegmentedButtonPreview(){
    ScreenMultiChoiceSegmentedButton()
}