package com.nicos.navigation_3_compose.navigation.screen_routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object ScreenA : NavKey

@Serializable
data object ScreenB : NavKey

@Serializable
data class ScreenC(val id: Int) : NavKey

@Serializable
data object ScreenD : NavKey