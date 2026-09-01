package com.leap.basicApp.componant

import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCheckBox(){
    data class CheckModel(
        val id: Int,
        var checked: Boolean,
        val label : String,
        var enabled: Boolean
    )

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
                        text = "Check Box"
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
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
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
fun ScreenCheckBoxPreview(){
    ScreenCheckBox()

}