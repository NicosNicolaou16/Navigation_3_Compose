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
import com.nicos.navigation_3_compose.screens.ScreenA
import com.nicos.navigation_3_compose.screens.ScreenB
import com.nicos.navigation_3_compose.screens.ScreenCRoot
import com.nicos.navigation_3_compose.screens.ScreenD
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
            // Way with the when() {} (without entryProvider {})
            when (key) {
                /// Bottom Navigation View
                is ScreenA -> NavEntry(key) {
                    ScreenA(
                        navigateToScreenC = { id ->
                            navigator.navigate(ScreenC(id = id))
                        },
                    )
                }

                /// Bottom Navigation View
                is ScreenB -> NavEntry(key) {
                    ScreenB(
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

            // Way with entryProvider {}
            /*entry<ScreenA> {
                ScreenA(navigator)
            }
            entry<ScreenB> {
                ScreenB(navigator)
            }
            entry<ScreenC> {
                ScreenC(navigator, id = it.id)
            }
            entry<ScreenD> {
                ScreenD(navigator)
            }*/
        }
    )
}