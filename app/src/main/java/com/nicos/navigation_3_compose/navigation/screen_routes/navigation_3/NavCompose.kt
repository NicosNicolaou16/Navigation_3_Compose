package com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey

@Composable
fun NavKey.navigationState(): NavigationState {
    return remember {
        NavigationState(
            backStacks = mutableStateListOf<NavKey>(this)
        )
    }
}