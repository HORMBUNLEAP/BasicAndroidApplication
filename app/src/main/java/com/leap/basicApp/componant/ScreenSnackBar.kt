package com.leap.basicApp.componant

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBar() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val snackBar = remember { SnackbarHostState() }
//    LaunchedEffect(Unit) {
//        snackBar.showSnackbar("Screen Snack Bar Launch Successfully")
//
//    }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        snackbarHost ={
            SnackbarHost(snackBar)
        },
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
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
                        text = "Snack Bar"
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
            Button(
                onClick = {
                    coroutineScope.launch {
                        snackBar.showSnackbar("Screen Snack Bar Launch Successfully")

                    }

                }
            ) {
                Text(
                    text = "Message"
                )
            }
            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {
                    coroutineScope.launch {
                        val result = snackBar.showSnackbar(
                            message = "Message",
                            actionLabel = "Action",
                            withDismissAction = true,
                            duration = SnackbarDuration.Short,
                        )
                        when(result){
                            SnackbarResult.ActionPerformed -> {
                                println("Action Performance")
                            }
                            SnackbarResult.Dismissed -> {
                                println("Diminished")
                            }
                        }

                    }

                }
            ) {
                Text(
                    text = "Snack Bar Message"
                )
            }
            Button(
                onClick = {
                    coroutineScope.launch {
                        Toast.makeText(context, "Toast Message", Toast.LENGTH_SHORT).show()
                    }

                }
            ) {
                Text(
                    text = "Show Teast Message"
                )
            }


        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenSnackBarPreview(){
    ScreenSnackBar()

}