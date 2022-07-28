package com.wtmcodex.samplequotes.ui.features

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wtmcodex.samplequotes.ui.features.Destinations.Home
import com.wtmcodex.samplequotes.ui.features.home.HomeScreen

@Composable
fun SampleQuotesApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    NavHost(navController = navController, startDestination = Home) {
        composable(Home) {
            HomeScreen(
                openSearch = actions.openSearch
            )
        }
    }
}