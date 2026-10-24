package com.nicos.navigation_3_compose.navigation.screen_routes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nicos.navigation_3_compose.R

data class TopLevelRoute<T : Any>(
    @StringRes val name: Int,
    val route: T,
    @DrawableRes val icon: Int
) {

    companion object {
        internal val screenARoot = TopLevelRoute(
            name = R.string.screen_a,
            route = ScreenA,
            icon = android.R.drawable.star_on,
        )

        internal val screenBRoot = TopLevelRoute(
            name = R.string.screen_b,
            route = ScreenB,
            icon = android.R.drawable.star_off,
        )
    }
}
