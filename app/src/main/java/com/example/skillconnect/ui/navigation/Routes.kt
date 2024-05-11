package com.example.skillconnect.ui.navigation

sealed class Routes(val route: String) {
    object WelcomeScreen : Routes("welcomeScreen")
    object GetStartedScreen : Routes("getStartedScreen")
    object HomeScreen : Routes("homeScreen")
    object MessageListScreen : Routes("messageListScreen")
    object ProjectScreen : Routes("projectScreen")
    object ProfileScreen : Routes("profileScreen")

}