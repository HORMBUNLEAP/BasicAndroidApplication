package com.leap.basicApp.componant

import android.widget.CheckBox
import android.widget.DatePicker
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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.leap.basicApp.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDatePicker(){
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis ?.let{
        convertMillisToDate(it, DateTimeFormatPattern.yyyy_MM_dd.format)
    }
    var showDatePicker by remember { mutableStateOf(false) }
    LaunchedEffect(datePickerState) {
        println("==> Selected : $selectedDate")
    }
    LaunchedEffect(Unit) { }

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
        bottomBar = {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                onClick = {
                    showDatePicker = true
                }
            ) {
                Text("Open Date Picker")

            }

        }

    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(

                text = "$selectedDate",
                fontSize = 16.sp,

            )
            if(showDatePicker) {
                Popup(
                    onDismissRequest = {
                        showDatePicker = false
                    }
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                    ) {
                        DatePicker(
                            modifier = Modifier.padding(16.dp),
                            state = datePickerState,
                            title = {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    text = "Selected Date of Birth",
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp
                                )
                            },
                            showModeToggle = true,
                            colors = DatePickerDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedDayContainerColor = MaterialTheme.colorScheme.error

                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),

                        ) {
                            FilledTonalButton(
                                onClick = {
                                    showDatePicker = false
                                }
                            ) {
                                Text("Cancel")
                            }
                            TextButton(
                                onClick = {
                                    showDatePicker= false
                                }
                            ) {
                                Text("Ok")
                            }
                        }
                    }
                }
            }


        }

    }
}

fun convertMillisToDate(millis: Long, pattern: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return formatter.format(Date(millis))
}
enum class DateTimeFormatPattern(val format: String){
    DD_MM_YYYY("dd/MM/yyyy"),
    yyyy_MM_dd("yyyy-MM-dd"),
    MM_dd_yyyy("MM/dd/yyyy"),
    yyyyMMdd("yyyy/MM/dd"),
}
@Preview(showBackground = false)
@Composable
fun ScreenDatePickerPreview(){
    ScreenDatePicker()

}