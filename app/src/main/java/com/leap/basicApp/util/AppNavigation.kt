package com.leap.basicApp.util

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.leap.basicApp.feature.badge.ScreenBadge
import com.leap.basicApp.feature.home.ScreenHome
import com.leap.basicApp.feature.home.ScreenHomePreview


data object HomeScreen
data object BadgeScreen

@Composable
fun AppNavigation(){
        val backStack = remember { mutableStateListOf<Any>(HomeScreen) }
        NavDisplay(
                backStack = backStack,
                onBack = {
                                backStack.removeLastOrNull()

                },
                entryProvider = { key->
                        when(key){
                                is HomeScreen -> NavEntry(key){
                                        ScreenHome(

                                        )
                                }
                                is BadgeScreen -> NavEntry(key){
                                        ScreenBadge()
                                }
                                else -> NavEntry(Unit) {
                                        Text("Unknown Route")
                                }
                        }
                }
        )
}