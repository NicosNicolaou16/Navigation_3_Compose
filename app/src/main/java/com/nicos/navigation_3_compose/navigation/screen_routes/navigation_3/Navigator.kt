package com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3

import androidx.navigation3.runtime.NavKey

class Navigator(val state: NavigationState) {
    fun navigate(route: NavKey) {
        state.stacksInUse.add(route)
    }

    fun navigateToBottomNavItem(route: NavKey) {
        state.stacksInUse.clear()
        state.stacksInUse.add(route)
    }

    fun goBack() {
        state.stacksInUse.removeLastOrNull()
    }
}