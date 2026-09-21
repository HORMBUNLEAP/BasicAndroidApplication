package com.leap.basicApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leap.basicApp.componant.ScreenBottomSheet
import com.leap.basicApp.componant.ScreenCheckBox
import com.leap.basicApp.componant.ScreenFillButton
import com.leap.basicApp.componant.ScreenIconButton
import com.leap.basicApp.componant.ScreenLoadingAndProgress
import com.leap.basicApp.componant.ScreenToolTip
import com.leap.basicApp.feature.home.ScreenHome
import com.leap.basicApp.screen.ScreenHorizontalPager
import com.leap.basicApp.screen.ScreenLazyHorizontalGird
import com.leap.basicApp.screen.ScreenLazyRowPreviewP2
import com.leap.basicApp.screen.ScreenLazyVerticalGrid
import com.leap.basicApp.ui.theme.BasicAndroidApplicationTheme
import com.leap.basicApp.util.AppNavigation
import com.leap.basicApp.util.LoadingContent
import com.leap.basicApp.util.LoadingUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
//            if (LoadingUtil.isLoading.value) {
//                LoadingContent()
//            }
            //ScreenLazyRowPreviewP2()
//            ScreenLazyVerticalGrid()
//            ScreenLazyHorizontalGird()
//            ScreenHorizontalPager()
//            ScreenIconButton()
//            ScreenFillButton()
//            ScreenCheckBox()
//            ScreenBottomSheet()
//            ScreenLoadingAndProgress()
//            ScreenToolTip()
//            ScreenHome()

        }



    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicAndroidApplicationTheme {
        Greeting("Android")
    }
}