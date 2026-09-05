package com.leap.basicApp.componant

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.collection.mutableIntIntMapOf
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.leap.basicApp.ui.theme.PrimaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTabs() {
    val scope = rememberCoroutineScope ()
    var selectedIndex by remember { mutableIntStateOf(TabIndex.Overview.index) }
    val scrollState = rememberScrollState()
    val pagerStats = rememberPagerState(pageCount =  { tab.size})

    LaunchedEffect(pagerStats) {
        snapshotFlow { pagerStats.currentPage }
            .collect { page->
                selectedIndex = page
            }
    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),

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
                        text = "Tabs Component"
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
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            PrimaryTabRow(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth(),
                selectedTabIndex = selectedIndex,
            ) {
                TabHeader(selectedIndex, tab) {
                    selectedIndex = it
                    scope.launch {
                        pagerStats.animateScrollToPage(
                            page = selectedIndex,
                            animationSpec = TweenSpec(500)
                        )
                    }
                }

            }
            HorizontalPager(
                modifier = Modifier
                    .weight(1f),
                state = pagerStats,
                contentPadding = PaddingValues(16.dp),
                pageSpacing = 8.dp
            ) {
                when (selectedIndex) {
                    TabIndex.Overview.index -> {
                        OverviewContent(modifier = Modifier.weight(1f))

                    }

                    TabIndex.Home.index -> {
                        HomeContentTab(modifier = Modifier.weight(1f))
                    }

                    TabIndex.Back.index -> {
                        BackContent(modifier = Modifier.weight(1f))
                    }

                }
            }


        }



    }
}
@Composable
fun TabHeader(selectedIndex: Int,tabs: List<TabModel>, onClick:(Int)-> Unit){
    for (index in tab.indices) {
        Tab(
            modifier = Modifier.fillMaxWidth(),
            selected = selectedIndex == index,
            onClick = {
                onClick(index)
            },
            text = {
                Text(text = tab[index].label)
            },
//            icon = {
//                Icon(
//                    painter = painterResource(tab[index].icon),
//                    contentDescription = "",
//                )
//            }

        )
    }
}
@Composable
fun OverviewContent(modifier: Modifier){
    LazyColumn(
    ) {
        items(100){
            Text(
                modifier = Modifier.padding(10.dp),
                text = "${it +1}/. This content overview $it"
            )
            HorizontalDivider()
        }

    }
}
@Composable
fun BackContent(modifier: Modifier){
    LazyColumn(
        
    ) {
        items(100){
            Text(
                modifier = Modifier.padding(10.dp),
                text = "${it +1}/. This content back $it"
            )
            HorizontalDivider()
        }

    }
}
@Composable
fun HomeContentTab(modifier: Modifier){
    LazyColumn(

    ) {
        items(100){
            Text(
                modifier = Modifier.padding(10.dp),
                text = "${it +1}/. This content home $it"
            )
            HorizontalDivider()
        }

    }
}

enum class TabIndex(val index: Int){
    Overview(0),
    Home(1),
    Back(2)
}
data class TabModel(
    val label : String,
    @DrawableRes val icon: Int,
)
val tab = listOf<TabModel>(
    TabModel(label = "Overview", icon = R.drawable.outline_notifications),
    TabModel(label = "Home", icon = R.drawable.ic_home),
    TabModel(label = "Back", icon = R.drawable.ic_arrow_back),

    )
@Preview(showBackground = false)
@Composable
fun ScreenTabsPreview(){
    ScreenTabs()

}