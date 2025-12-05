@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.nicos.navigation_3_compose.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
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
    paddingValues: PaddingValues,
) {
    val sceneStrategy = rememberListDetailSceneStrategy<NavKey>()

    NavDisplay(
        backStack = navigationState.stacksInUse,
        onBack = {
            navigator.goBack()
        },
        sceneStrategy = sceneStrategy,
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
                ScreenARoot(navigateToScreenC = { id ->
                    navigator.navigate(ScreenC(id = id))
                })
            }
            entry<ScreenB> {
                ScreenBRoot(navigateToScreenD = {
                    navigator.navigate(ScreenD)
                })
            }
            entry<ScreenC>(
                // Apply only to ScreenC
                metadata = NavDisplay.transitionSpec {
                    // Slide new content right, keeping the old content in place underneath
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(1000)
                    ) togetherWith ExitTransition.KeepUntilTransitionsFinished
                } + NavDisplay.popTransitionSpec {
                    // Slide old content right, revealing the new content in place underneath
                    EnterTransition.None togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { it },
                                animationSpec = tween(1000)
                            )
                } + NavDisplay.predictivePopTransitionSpec {
                    // Slide old content right, revealing the new content in place underneath
                    EnterTransition.None togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { it },
                                animationSpec = tween(1000)
                            )
                }
            ) {
                ScreenCRoot(id = it.id)
            }
            entry<ScreenD> {
                ScreenDRoot()
            }
        },
        // Apply to all screens
        transitionSpec = {
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(1000)
            ) togetherWith ExitTransition.KeepUntilTransitionsFinished
        },
        popTransitionSpec = {
            EnterTransition.None togetherWith slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(1000)
            )
        },
        predictivePopTransitionSpec = {
            EnterTransition.None togetherWith slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(1000)
            )
        },
    )
}