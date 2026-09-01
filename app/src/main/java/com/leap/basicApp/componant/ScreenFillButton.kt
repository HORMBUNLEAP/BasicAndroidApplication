package com.leap.basicApp.componant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R
import com.leap.basicApp.ui.theme.Outline
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFillButton(
){
    var text by remember { mutableStateOf("Hello World") }
    var isCheck by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            MediumTopAppBar(
                navigationIcon = {
                    FilledIconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "Screen Filled Button",
                    )
                },
                actions = {
                    FilledTonalButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications),
                            contentDescription = null
                        )
                    }
                    FilledTonalButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    navigationIconContentColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary

                )
            )

        },
    ) { padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {
            Text(
                text = text
            )
            Spacer(modifier = Modifier.height(56.dp))
            Button(
                modifier = Modifier
                    .height(56.dp) ,
                onClick = {
                    text = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Red,
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.Green
                ),
                enabled = true
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_share_24),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "share"
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FilledTonalButton(
                onClick = {
                    text = "Hello New Text"
                }
            ) {


                Text(
                    text = "share"
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                        painter = painterResource(R.drawable.outline_share_24),
                contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FilledTonalButton(
                onClick = {}
            ) {
                Icon(
                    painter =  painterResource(R.drawable.outline_notifications),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FilledIconToggleButton(
                checked = isCheck,
                onCheckedChange = {value->
                    println("===> $value")
                    isCheck = value
                },
                colors = IconButtonDefaults.filledIconToggleButtonColors(
                    containerColor = if(isCheck) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.inverseOnSurface
                )
            ) {
                if(isCheck){
                    Icon(
                        painter = painterResource(R.drawable.outline_check_small_24),
                        contentDescription = ""
                    )
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = {
                }
            ) {
                Text(
                    text = "Cancel"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                onClick = {}
            ) {
                Text(
                    text = "Ok"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "testing"
                )
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenFillButtonPreview(){
    ScreenFillButton()
}