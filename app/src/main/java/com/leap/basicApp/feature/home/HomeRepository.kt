package com.leap.basicApp.feature.home

import com.leap.basicApp.model.ComponentModel
import com.leap.basicApp.util.BadgeScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

class HomeRepository {
    val componentList = listOf(
        ComponentModel(id = 1, title = "Badge", description = "Click here to see abdge", route = BadgeScreen)

    )
    suspend fun GetComponentList(): Flow<List<ComponentModel>>{
        delay(2000.milliseconds)
        return  flow{
            emit(componentList)
        }
    }
}