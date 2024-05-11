package com.example.skillconnect.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.skillconnect.R
import com.example.skillconnect.ui.screens.freelancer.home.HomeScreen
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
            HomeScreen(userAvatar = {
                // Provide an image preview for the user avatar with a circular clip
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape), // Clip the image to circle
                    painter = painterResource(id = R.drawable.profile_image), // Placeholder for actual image
                    contentDescription = "User avatar"
                )
            },
                userName = "John Doe",
                userPosition = "Software Engineer",
                navigateToNext =  {navController.navigate(it)},
                notificationSection = {
                    // Provide a preview for the notification section
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                })
        }

    }
}