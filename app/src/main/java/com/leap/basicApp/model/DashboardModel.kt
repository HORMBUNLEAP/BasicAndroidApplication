package com.leap.basicApp.model

import androidx.annotation.ColorRes
import androidx.compose.ui.res.colorResource
import com.leap.basicApp.R

data class DashboardModel(
    val id: String,
    val label: String,
    val labelKH: String,
    val iconRes: Int,
    val isEnable: Boolean,
) {
}

data class PromotionModel(
    val label: String,
    val functionKHR: String,
    val date : String,
    val colorRes: Int
)
