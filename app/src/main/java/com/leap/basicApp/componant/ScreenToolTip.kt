package com.leap.basicApp.componant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leap.basicApp.R
import com.leap.basicApp.modelf.ReceiverAccountModel
import com.leap.basicApp.modelf.ToolTipViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenToolTip() {
    val states = rememberTooltipState()
    val scope = rememberCoroutineScope ()

    val toolTipViewModel = ToolTipViewModel()
    var receiver by remember { mutableStateOf<ReceiverAccountModel?>(null) }
    val accountInfo by toolTipViewModel.receiverAccount.collectAsStateWithLifecycle()


    LaunchedEffect(accountInfo) {
        accountInfo.let {
            if(it != null){
                receiver = accountInfo
                println(receiver)
            }
        }


    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        snackbarHost ={

        },
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu),
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
                        text = "Tool Tip"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700),
                )
            )
        },

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pay to"
                )

                TooltipBox(
                    positionProvider = TooltipDefaults.rememberTooltipPositionProvider(),
                    tooltip = {
                        TooltipContent(receiver)
                    },
                    state = states,
                    modifier = Modifier,
                    focusable = true,
                    enableUserInput = true,


                    ) {
                    IconButton(
                        onClick = {
                            scope.launch {
                                toolTipViewModel.getAccountInfo()
                                delay(1000)
                                states.show()
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_infor),
                            contentDescription = null
                        )
                    }

                }
            }
        }

    }
}


@Composable
fun TooltipContent(data: ReceiverAccountModel?){
    val info = """
        Account Name : ${data?.accountName}
        Account Number : ${data?.accountNumber}
        Receiver Bank Name : ${data?.receiverAccount}
    """.trimIndent()
    Column(

    ) {
        Text(text = info)
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenToolTipPreview(){
    ScreenToolTip()

}