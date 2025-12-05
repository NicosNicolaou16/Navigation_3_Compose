package com.nicos.navigation_3_compose.screens.composes

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.nicos.navigation_3_compose.navigation.screen_routes.TopLevelRoute.Companion.screenARoot
import com.nicos.navigation_3_compose.navigation.screen_routes.TopLevelRoute.Companion.screenBRoot
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.Navigator

@Composable
fun MainBottomNavigationView(
    navigator: Navigator,
    currentRoute: String?,
) {
    val items = mutableListOf(
        screenARoot,
        screenBRoot,
    )
    NavigationBar(
        containerColor = Color.DarkGray,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(
                            id = item.name
                        )
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.name),
                        fontSize = 9.sp,
                        color = Color.White,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.White,
                    indicatorColor = Color.LightGray
                ),
                alwaysShowLabel = true,
                selected = currentRoute == item.route.toString(),
                onClick = {
                    navigator.navigateToBottomNavItem(item.route)
                }
            )
        }
    }
}