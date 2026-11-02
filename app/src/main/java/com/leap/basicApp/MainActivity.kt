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

import com.leap.basicApp.util.AppNavigation
import com.leap.basicApp.util.LoadingContent
import com.leap.basicApp.util.LoadingUtil
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    private val currentDateTime = LocalDateTime.now()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("====> MainActivity onCreate $currentDateTime")
        enableEdgeToEdge()
        setContent {
            AppNavigation()


        }

    }

    override fun onStart() {
        super.onStart()
        println("====> MainActivity onStart")
    }

    override fun onPause() {
        super.onPause()
        println("====> MainActivity onPause")
    }

    override fun onResume() {
        super.onResume()
        println("====> MainActivity onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("====> MainActivity onDestroy $currentDateTime")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        println("===> Leave Hint")
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

@Composable
fun BasicAndroidApplicationTheme(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}