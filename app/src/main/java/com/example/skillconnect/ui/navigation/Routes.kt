package com.example.skillconnect.ui.navigation

sealed class Routes(val route: String) {
    data object WelcomeScreen : Routes("welcomeScreen")
    data object GetStartedScreen : Routes("getStartedScreen")
    data object HomeScreen : Routes("homeScreen")
    data object MessageListScreen : Routes("messageListScreen")
    data object ProjectScreen : Routes("projectScreen")
    data object ProfileScreen : Routes("profileScreen")
    data object SignInScreen : Routes("signInScreen")
    data object SignUpScreen : Routes("signUpScreen")
    data object FreelancerBasicDetailsScreen : Routes("freelancerBasicDetailsScreen")
    data object FreelancerSocialLinksScreen : Routes("freelancerSocialLinksScreen")
    data object FreelancerTechDetailsScreen : Routes("freelancerTechDetailsScreen")

}