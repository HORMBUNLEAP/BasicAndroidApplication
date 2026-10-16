package com.leap.basicApp.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.leap.basicApp.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.util.LoadingUtil


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(
    homeVM: HomeVM = HomeVM(),
    onClickItem: (Any) -> Unit = {}
){
    val componentList by homeVM.componentList.collectAsStateWithLifecycle()

    LaunchedEffect(componentList) {
        when(val state = componentList){
            is BaseUiState.Loading, BaseUiState.None  -> LoadingUtil.showLoading()
            is BaseUiState.Success -> LoadingUtil.hideLoading()
            is BaseUiState.Error -> LoadingUtil.hideLoading()
            else -> {

            }
        }
    }

    Scaffold(
        topBar = {
             TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "My app"
                    )
                },
                actions = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) {paddingValues ->
        when(val state = componentList){
            is BaseUiState.Success ->{
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),

                    ) {
                        items(
                            state.data.size,
                            key = { index -> state.data[index].id }) { index ->
                            val item = state.data[index]
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(
                                        onClick = {
                                            onClickItem(item.route)
                                        }
                                    )
                                    .padding(horizontal = 16.dp, vertical = 8.dp),

                                ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = item.title,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = item.description,
                                    textAlign = TextAlign.Left,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                              }
                            HorizontalDivider()
                    }
                }
            }
            else -> {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHomePreview(){
    ScreenHome()
}
