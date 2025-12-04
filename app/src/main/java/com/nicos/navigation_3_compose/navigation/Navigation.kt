package com.nicos.navigation_3_compose.navigation

import androidx.compose.runtime.Composable
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
import com.nicos.navigation_3_compose.screens.ScreenC
import com.nicos.navigation_3_compose.screens.ScreenD

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
            when (key) {
                is ScreenA -> NavEntry(key) {
                    ScreenA(navigator)
                }

                is ScreenB -> NavEntry(key) {
                    ScreenB(navigator)
                }

                is ScreenC -> NavEntry(key) {
                    ScreenC(navigator)
                }

                is ScreenD -> NavEntry(key) {
                    ScreenD(navigator)
                }

                else -> error("")
            }*/

            entry<ScreenA> {
                ScreenA(navigator)
            }
            entry<ScreenB> {
                ScreenB(navigator)
            }
            entry<ScreenC> {
                ScreenC(navigator)
            }
            entry<ScreenD> {
                ScreenD(navigator)
            }
        }
    )
}