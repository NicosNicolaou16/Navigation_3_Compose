package com.nicos.navigation_3_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nicos.navigation_3_compose.navigation.Navigation
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenA
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.Navigator
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.navigationState
import com.nicos.navigation_3_compose.screens.MainBottomNavigationView
import com.nicos.navigation_3_compose.ui.theme.Navigation_3_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationState = ScreenA.navigationState()

            val navigator = remember { Navigator(navigationState) }

            Navigation_3_ComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    bottomBar = {
                        MainBottomNavigationView(
                            navigator = navigator,
                            currentRoute = navigator.state.stacksInUse.lastOrNull().toString(),
                        )
                    }) { innerPadding ->
                    Navigation(
                        navigator = navigator,
                        navigationState = navigationState
                    )
                }
            }
        }
    }
}