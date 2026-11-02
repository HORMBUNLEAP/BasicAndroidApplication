package com.leap.basicApp.util

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.leap.basicApp.feature.badge.ScreenBadge01
import com.leap.basicApp.feature.home.ScreenHome
import com.leap.basicApp.feature.profile.ScreenProfile
import kotlinx.serialization.Serializable


data object HomeScreen
data object BadgeScreen

@Serializable
data class UserProfile(val id: String)

@Composable
fun AppNavigation(){
    val backStack = remember { mutableStateListOf<Any>(HomeScreen) }
    
    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when (key) {
                is HomeScreen -> NavEntry(key) {
                    ScreenHome(
                        onClickItem = { route ->
                            backStack.add(route)
                        },
                        onClickProfile = { id ->
                            backStack.add(UserProfile(id.toString()))
                        }
                    )
                }
                is BadgeScreen -> NavEntry(key) {
                    ScreenBadge01(
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                is UserProfile -> NavEntry(key) {
                    ScreenProfile(
                        id = key.id,
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                else -> NavEntry(Unit) {
                    Text("Unknown Route")
                }
            }
        }
    )

    if (LoadingUtil.isLoading.value) {
        LoadingContent()
    }
}
