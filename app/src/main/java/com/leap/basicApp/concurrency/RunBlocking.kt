package com.leap.basicApp.concurrency

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds


fun main(){
    runBlocking{
        launch {
            delay(100)
        }
        println("Start Blocking")
        delay(1000.milliseconds)
        println("End Blocking")
    }
}