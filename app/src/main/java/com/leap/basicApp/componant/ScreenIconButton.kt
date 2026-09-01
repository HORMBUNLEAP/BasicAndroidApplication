package com.leap.basicApp.componant

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.leap.basicApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  ScreenIconButton(){
    var interactionSpurce = remember { MutableInteractionSource() }
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
                        text = "Icon Button",
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
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            navigationIconContentColor = colorResource(R.color.purple_700)
//        )


    ) { padding ->
        Row (
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center



        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.inverseOnSurface
                ),
                interactionSource = interactionSpurce
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            FilledIconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            FilledTonalButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedIconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ScreenIconButtonPreview(){
    ScreenIconButton()
}