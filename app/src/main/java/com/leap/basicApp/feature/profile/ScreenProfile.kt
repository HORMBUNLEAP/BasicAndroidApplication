package com.leap.basicApp.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leap.basicApp.R
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenProfile(
    id: String,
    userVM: UserVM = UserVM(),
    onBack: () -> Unit
){
    val userUiState by userVM.userUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        userVM.getUserDetail(id.toIntOrNull() ?: 0)
    }
    LaunchedEffect(userUiState) {
        when(val state = userUiState){
            is BaseUiState.Loading -> LoadingUtil.showLoading()
            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
                println("====> User : ${state.data}")
            }
            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println("====> Error : ${state.message}")
            }
            else -> {}
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back_ios),
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
                        text = "MY Profile"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        },

    ) {paddingValues ->
        when(val state = userUiState){
            is BaseUiState.Success -> {
                val user = state.data
                if (user != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Userid : ${user.id}")
                        HorizontalDivider()
                        Text(text = "Name : ${user.name}")
                        HorizontalDivider()
                        Text(text = "Email : ${user.email}")
                        HorizontalDivider()
                        Text(text = "Age : ${user.age}")
                        HorizontalDivider()
                    }
                }
            }
            else -> {}
        }

    }

}