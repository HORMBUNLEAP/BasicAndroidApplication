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
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
fun ScreenBadge(){
    var isHaveNotification  by remember { mutableStateOf(true ) }
    var badgeCount by remember {mutableStateOf(0)}
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "This is Badge"
                    )

                },
                    actions = {
                          IconButton(
                        onClick = {
                            isHaveNotification = false
                        }
                        ) {
                            BadgedBox(

                                 badge = {
                                     if(isHaveNotification){
                                         Badge(

                                         )
                                     }

                                 }
                            ) {

                                    Icon(
                                        painter = painterResource(R.drawable.outline_notifications) ,
                                        contentDescription = "Notification",
                                    )
                            }
                        }
                        IconButton(
                                 onClick = {
                                     isHaveNotification = false
                                 }
                                 ) {
                            BadgedBox(

                                badge = {
                                    if(badgeCount > 0){
                                        Badge(

                                        ) {
                                            Text(
                                                text = "${badgeCount}"
                                            )
                                        }
                                    }

                                }
                            ) {

                                    Icon(
                                        painter = painterResource(R.drawable.outline_notifications) ,
                                        contentDescription = "Notification",
                                    )
                                }

                        }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        },
        bottomBar = {
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                   badgeCount++
                }
            ) {
                Text(
                    text = "Update Badge"
                )
            }
        }

    ) {padding->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }

    }
}
@Preview(showBackground = false)
@Composable
fun ScreenBadgePreview(){
    ScreenBadge()
}