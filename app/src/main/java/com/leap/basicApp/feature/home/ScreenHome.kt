package com.leap.basicApp.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leap.basicApp.R
import com.leap.basicApp.model.BaseUiState
import com.leap.basicApp.util.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome01(
    homeVM: HomeVM = viewModel(),
    onClickItem: (Any) -> Unit = {},
    onClickProfile: (id: Int) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val componentList by homeVM.componentList.collectAsStateWithLifecycle()

    LaunchedEffect(componentList) {
        when (componentList) {
            is BaseUiState.Loading,
            is BaseUiState.None,
            null -> LoadingUtil.showLoading()
            is BaseUiState.Success -> LoadingUtil.hideLoading()
            is BaseUiState.Error -> LoadingUtil.hideLoading()
            else -> LoadingUtil.hideLoading()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            println("===== onDispose =====")
            homeVM.onDispose()
        }
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> println("---> ON_CREATE")
                Lifecycle.Event.ON_START -> println("---> ON_START")
                Lifecycle.Event.ON_DESTROY -> println("---> ON_DESTROY")
                Lifecycle.Event.ON_PAUSE -> println("---> ON_PAUSE")
                Lifecycle.Event.ON_RESUME -> println("---> ON_RESUME")
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickProfile(1) }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = null
                        )
                    }
                },
                title = { Text(text = "My app") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) { paddingValues ->
        val currentState = componentList
        if (currentState is BaseUiState.Success) {
            val itemsList = currentState.data

            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                items(
                    count = itemsList.size,
                    key = { index -> itemsList[index].id }
                ) { index ->
                    val item = itemsList[index]
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { onClickItem(item.route) })
                            .padding(horizontal = 16.dp, vertical = 8.dp)
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
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenHomePreview() {
    ScreenHome01(
        onClickItem = {},
        onClickProfile = {}
    )
}