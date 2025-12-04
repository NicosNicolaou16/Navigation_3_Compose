package com.nicos.navigation_3_compose.navigation.screen_routes

import com.nicos.navigation_3_compose.R

data class TopLevelRoute<T : Any>(val name: Int, val route: T, val icon: Int) {

    companion object {
        internal val shipRoute = TopLevelRoute(
            name = R.string.screen_a,
            route = ScreenA,
            icon = android.R.drawable.star_on,
        )

        internal val processesRoute = TopLevelRoute(
            name = R.string.screen_b,
            route = ScreenB,
            icon = android.R.drawable.star_off,
        )
    }
}
