package com.leap.basicApp.componant

import android.widget.CheckBox
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenChips(){
    data class CheckModel(
        val id: Int,
        var checked: Boolean,
        val label : String,
        var enabled: Boolean
    )
    data class chipModel(
        val id : Int,
        val label: String,
        var selected: Boolean,
    )
    var isActive by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    var checked by remember { mutableStateOf(false) }
    var checkList by remember { mutableStateOf<List<CheckModel>>(listOf(
        CheckModel(id = 1, checked = false, label = "Pickles", enabled = true),
        CheckModel(id = 2, checked = false, label = "Milk", enabled = true),
        CheckModel(id = 3, checked = false, label = "Bread", enabled = true),
        CheckModel(id = 4, checked = false, label = "Eggs", enabled = true),
        CheckModel(id = 5, checked = false, label = "Cheese", enabled = true),
        CheckModel(id = 6, checked = false, label = "Apples", enabled = true),
        CheckModel(id = 7, checked = false, label = "Coffee", enabled = true),
        CheckModel(id = 8, checked = false, label = "Butter", enabled = true),
        CheckModel(id = 9, checked = false, label = "Tomatoes", enabled = true),
        CheckModel(id = 10, checked = false, label = "Pasta", enabled = false)
    )) }

    val chip by remember { mutableStateOf(listOf(
        chipModel(
            id = 1,
            label = "Red",
            selected = false,
        ),
        chipModel(
            id = 2,
            label = "Blue",
            selected = false,
        ),
        chipModel(
            id = 3,
            label = "Green",
            selected = false,
        ),
        chipModel(
            id = 4,
            label = "Yellow",
            selected = false,
        ),
        chipModel(
            id = 5,
            label = "Orange",
            selected = false,
        ),
        chipModel(
            id = 6,
            label = "Purple",
            selected = false
        ),
        chipModel(
            id = 7,
            label = "Pink",
            selected = false
        ),
        chipModel(
            id = 8,
            label = "Black",
            selected = false
        ),
        chipModel(
            id = 9,
            label = "Black",
            selected = false,
        ),
        chipModel(
            id = 10,
            label = "White",
            selected = false,
        )
        )
    )}
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
                        text = "Chips"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700),
                )
            )
        },

    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp),
            ) {
                AssistChip(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        isActive = !isActive
                    },
                    label = {
                        Text(
                            text = "Hello person"
                        )
                    },
                    leadingIcon = {
                        if(isActive) {
                            Icon(
                                painter = painterResource(R.drawable.outline_check_small_24),
                                contentDescription = ""
                            )
                        }
                        else{
                            null
                        }
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.icon),
                            contentDescription = ""
                        )
                    },
                    enabled = true,
                    shape = RoundedCornerShape(0.dp),
                    elevation =AssistChipDefaults.assistChipElevation(
                            elevation = 0.dp,
                        pressedElevation = 12.dp
                    ),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                        disabledContainerColor = MaterialTheme.colorScheme.primary,
                        trailingIconContentColor = MaterialTheme.colorScheme.error,
                        leadingIconContentColor = MaterialTheme.colorScheme.inversePrimary,
                        disabledLabelColor = MaterialTheme.colorScheme.error,
                        disabledLeadingIconContentColor = MaterialTheme.colorScheme.error,
                    )

                )
                Spacer(modifier = Modifier.width(8.dp))
                AssistChip(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {},
                    label = {
                        Text(
                            text = "Hello person"
                        )
                    }
                )
            }
//            LazyRow(
//
//            ) {
//                items(chip.size){ index->
//                    FilterChip(
//                        selected = true,
//
//                    ){
//
//                    }
//                }
//            }

            Spacer(modifier = Modifier.height(16.dp))
            checkList.forEach{value ->
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(64.dp)
                        .clickable(
                            onClick = {
                                checkList = checkList.map { item->
                                    if(item.id == value.id){
                                        item.copy(checked = !item.checked)
                                    }else{
                                        item
                                    }
                                }
                            }
                        ),

                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = value.checked,
                        onCheckedChange = { isCheck ->
                            checkList = checkList.map { item->
                                if(item.id == value.id){
                                    item.copy(checked = isCheck)
                                }else{
                                    item
                                }
                            }

                        },
                        modifier = Modifier,
                        enabled = value.enabled,
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colorScheme.primary,
                            uncheckedColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        interactionSource = interactionSource,
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = value.label,
                        textDecoration = if (value.checked) TextDecoration.LineThrough else null
                    )

                }
                HorizontalDivider()
            }

        }

    }
}
@Preview(showBackground = false)
@Composable
fun ScreenChipsPreview(){
    ScreenChips()

}