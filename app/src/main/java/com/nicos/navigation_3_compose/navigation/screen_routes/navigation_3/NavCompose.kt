package com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack

@Composable
fun NavKey.navigationState(): NavigationState {
    return NavigationState(
        backStacks = rememberNavBackStack(this)
    )
}