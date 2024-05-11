package com.example.skillconnect.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.connectly.ui.screens.freelancer.home.HomeScreen
import com.example.skillconnect.ui.screens.welcome.GetStartedScreen
import com.example.skillconnect.ui.screens.welcome.WelcomeScreen

@Composable
fun NavigationGraph(navController: NavHostController, onBottomBarVisibilityChanged: (Boolean) -> Unit) {

    NavHost(navController = navController, startDestination = "welcomeScreen") {

        composable("welcomeScreen") {
            onBottomBarVisibilityChanged(false)
            WelcomeScreen(navigateToNext = {navController.navigate(it)})
        }

        composable("getStartedScreen") {
            onBottomBarVisibilityChanged(false)
            GetStartedScreen(navController = navController)
        }

        composable("homeScreen") {
            onBottomBarVisibilityChanged(true)
            HomeScreen()
        }

    }
}