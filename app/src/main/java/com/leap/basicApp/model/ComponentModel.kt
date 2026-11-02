package com.leap.basicApp.model

import androidx.compose.runtime.Immutable

@Immutable
data class ComponentModel(
    val id: Int ,
    val title: String,
    val description: String,
    val route : Any,
    )