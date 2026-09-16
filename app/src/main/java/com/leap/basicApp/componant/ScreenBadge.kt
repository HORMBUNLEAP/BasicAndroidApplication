package com.leap.basicApp.componant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leap.basicApp.R
import com.leap.basicApp.model.BadgeViewModel
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBadge(
    badgeViewModel: BadgeViewModel = BadgeViewModel()
){

    val  messageUiState by badgeViewModel.messageUiState.collectAsStateWithLifecycle()
    var isHaveNotification  by remember { mutableStateOf(true ) }
    var badgeCount by remember {mutableStateOf(0)}
    var message by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        badgeViewModel.requestData()

    }
    LaunchedEffect(key1 = messageUiState) {
        when(val state = messageUiState){
            is BaseUiState.Loading, BaseUiState.None ->{
                LoadingUtil.showLoading()
            }
            is BaseUiState.Success->{
                LoadingUtil.hideLoading()
                message = state.data
            }
            is BaseUiState.Error->{
                LoadingUtil.hideLoading()
            }
            is BaseUiState.ErrorWithException->{
                LoadingUtil.hideLoading()
            }
        }
    }

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
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Message $message")
        }

    }
}
@Preview(showBackground = false)
@Composable

fun ScreenBadgePreview(){
    ScreenBadge()
}
