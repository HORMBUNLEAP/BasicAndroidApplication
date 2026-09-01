package com.leap.basicApp.componant

import android.R.attr.text
import androidx.compose.material3.Surface
import android.view.Surface
import android.widget.CheckBox
import android.widget.DatePicker
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import com.leap.basicApp.R
import com.leap.basicApp.ui.theme.Surface
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationDrawer(){
    data class NavigationBarItem(
        val id : Int,
        @DrawableRes val icon: Int,
        val label: String,
        var selected: Boolean = false
    )
    var selectedItem by remember { mutableStateOf(0) }
    var navigationItemList by remember { mutableStateOf<List<NavigationBarItem>>(listOf(
        NavigationBarItem(id = 1, icon = R.drawable.ic_home, label = "Home"),
        NavigationBarItem(id = 2, icon = R.drawable.ic_plus, label = "Add"),
        NavigationBarItem(id = 1, icon = R.drawable.outline_settings_24, label = "setting"),
    )) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope ()
    var text01 by remember { mutableStateOf("") }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent ={
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(0.dp),
                windowInsets = WindowInsets.navigationBars
            ){
                DrawerContent{ menuItem->
                    text01 = menuItem.label
                    scope.launch {
                        when (menuItem.id){
                            1->{
                                // navigation to home
                            }
                            2->{
                                // navigation to setting
                            }
                        }
                        drawerState.close()
                    }

                }
            }
        } ,
        gesturesEnabled = true,
        modifier = Modifier,


    ) {

        Scaffold(
            modifier = Modifier.navigationBarsPadding(),
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isOpen) {
                                        drawerState.close()
                                    }else{
                                        drawerState.open()
                                    }
                                }
                            },

                            ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_more_24),
                                contentDescription = ""
                            )
                        }
                    },

                    title = {
                        Text(
                            text = "Navigation Drawer"
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        navigationIconContentColor = colorResource(R.color.purple_700)
                    )
                )
            },
            bottomBar = {
                NavigationBar() {
                    navigationItemList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = false,
                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(item.label)
                            },
                            onClick = {
                                selectedItem = index
                            },
                        )
                    }

                }
            }


        ) { padding ->
            when(selectedItem){
                0->{
                    HomeContent(Modifier.padding(padding))
                }
                1->{
                    NotificationContent(Modifier.padding(padding))
                }


            }
            Column (
                modifier = Modifier.padding(padding)
            ) {
                Text(
                    text = text01
                )
            }


        }
    }
}
data class MenuModel(
    val id: Int,
    val label: String,
    @DrawableRes val leadingIcon: Int,
    @DrawableRes val trailing: Int,
    var selected : Boolean = false,
)
@Composable
fun DrawerContent(onClick: (menuItem: MenuModel)-> Unit){

    var menuList01 by remember {
        mutableStateOf<List<MenuModel>>(
            listOf(
                MenuModel(
                    id = 1,
                    label = "Transfer",
                    leadingIcon = R.drawable.outline_transfer_within_a_station_24,
                    trailing = R.drawable.close,
                ),
                MenuModel(
                    id = 2,
                    label = "My Accounts",
                    leadingIcon = R.drawable.ic_manage_accounts_24,
                    trailing = R.drawable.ic_plus,
                ),
                MenuModel(
                    id = 3,
                    label = "Pay Bills",
                    leadingIcon = R.drawable.outline_notifications,
                    trailing = R.drawable.outline_notifications,
                ),
                MenuModel(
                    id = 4,
                    label = "Cards",
                    leadingIcon = R.drawable.outline_settings_24,
                    trailing = R.drawable.ic_arrow_back,
                ),
                MenuModel(
                    id = 5,
                    label = "Notifications",
                    leadingIcon = R.drawable.outline_notifications,
                    trailing = R.drawable.airplay_tv,
                ),
                MenuModel(
                    id = 6,
                    label = "Transaction History",
                    leadingIcon = R.drawable.airplay_tv,
                    trailing = R.drawable.outline_settings_24,
                ),
                MenuModel(
                    id = 7,
                    label = "Security & Privacy",
                    leadingIcon = R.drawable.ic_home,
                    trailing = R.drawable.close,
                ),
                MenuModel(
                    id = 8,
                    label = "Settings",
                    leadingIcon = R.drawable.ic_minus,
                    trailing = R.drawable.close,
                ),
                MenuModel(
                    id = 9,
                    label = "Help & Support",
                    leadingIcon = R.drawable.ic_delete,
                    trailing = R.drawable.airplay_tv,
                ),
                MenuModel(
                    id = 10,
                    label = "Logout",
                    leadingIcon = R.drawable.outline_align_center_24,
                    trailing = R.drawable.outline_align_center_24,

                    )
            )
        )
    }
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .systemBarsPadding()
            .background(color = MaterialTheme.colorScheme.secondary),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Drawer Title",
                color = Color.Red,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        HorizontalDivider()
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
        ) {
            menuList01.forEachIndexed { index, item ->
                NavigationDrawerItem(
                    label = {

                        Text(
                            text = item.label,
                            color = Color.Black,
                            fontSize = 16.sp,

                        )
                    },
                    onClick = {
                        onClick(item)
                    },
                    selected = item.selected,
                    icon = {
                        Icon(
                            painter = painterResource(item.trailing),
                            contentDescription = ""
                        )
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.error,
                        unselectedTextColor = MaterialTheme.colorScheme.error
                    )
                )
                HorizontalDivider()
            }
        }
    }
}
@Composable
fun HomeContent(
    modifier: Modifier
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {
        items(100){

            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .height(36.dp),
                text = "This is Content Home ${it+1}",
                textAlign = TextAlign.Left
            )
            HorizontalDivider()
        }
    }

}
@Composable
fun NotificationContent(
    modifier: Modifier
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {
        items(100) {
        ElevatedCard(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    text = "This is Content Notification ${it + 1}",
                    textAlign = TextAlign.Left
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                }
            }
            }
        }

    }

}



@Preview(showBackground = false)
@Composable
fun ScreenNavigationDrawerPreview(){
    ScreenNavigationDrawer()

}
