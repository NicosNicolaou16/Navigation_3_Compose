package com.nicos.navigation_3_compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nicos.navigation_3_compose.navigation.screen_routes.ScreenC
import com.nicos.navigation_3_compose.navigation.screen_routes.navigation_3.Navigator

@Composable
fun ScreenA(navigator: Navigator) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Screen A",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(paddingValues)
                    .wrapContentSize(Alignment.Center)
            )
            Button(onClick = {
                navigator.navigate(ScreenC)
            }) {
                Text(text = "Navigate to Screen C")
            }
        }
    }
}