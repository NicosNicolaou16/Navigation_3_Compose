package com.nicos.navigation_3_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenA
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenB
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenC
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenD
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.NavigationState
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.Navigator
import com.nicos.navigation_3_compose.screens.ScreenARoot
import com.nicos.navigation_3_compose.screens.ScreenBRoot
import com.nicos.navigation_3_compose.screens.ScreenCRoot
import com.nicos.navigation_3_compose.screens.ScreenDRoot

@Composable
fun Navigation(
    navigator: Navigator,
    navigationState: NavigationState,
) {
    NavDisplay(
        backStack = navigationState.stacksInUse,
        onBack = {
            navigator.goBack()
        },
        entryProvider = entryProvider { /*key ->

            // Using NavEntry
            when (key) {
                /// Bottom Navigation View
                is ScreenA -> NavEntry(key) {
                    ScreenARoot(
                        navigateToScreenC = { id ->
                            navigator.navigate(ScreenC(id = id))
                        },
                    )
                }

                /// Bottom Navigation View
                is ScreenB -> NavEntry(key) {
                    ScreenBRoot(
                        navigateToScreenD = {
                            navigator.navigate(ScreenD)
                        },
                    )
                }

                is ScreenC -> NavEntry(key) {
                    ScreenCRoot(id = key.id)
                }

                is ScreenD -> NavEntry(key) {
                    ScreenDRoot()
                }

                else -> error("no route found for $key")
            }*/

            // entryProvider DSL
            entry<ScreenA> {
                ScreenARoot(navigateToScreenC =  {  id ->
                    navigator.navigate(ScreenC(id = id))
                })
            }
            entry<ScreenB> {
                ScreenBRoot(navigateToScreenD = {
                    navigator.navigate(ScreenD)
                })
            }
            entry<ScreenC> {
                ScreenCRoot(id = it.id)
            }
            entry<ScreenD> {
                ScreenDRoot()
            }
        }
    )
}