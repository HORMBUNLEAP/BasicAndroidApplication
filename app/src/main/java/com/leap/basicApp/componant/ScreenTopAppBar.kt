package com.leap.basicApp.componant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopAppBar(){
    val isDialop= remember { mutableStateOf(false) }
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
                        text = stringResource(R.string.app_name)
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            println("you clicked icon")
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_share_24),
                            contentDescription = "Share"
                        )
                    }
                    IconButton(
                        onClick = {
                            println("you clicked icon")
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon),
                            contentDescription = "Close"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        }
    ) { padding->
        Column(
            modifier = Modifier.padding(padding),

        ) { }

    }
}
@Preview(showBackground = true)
@Composable
fun ScreenTopAppPreview(){
    ScreenTopAppBar()
}