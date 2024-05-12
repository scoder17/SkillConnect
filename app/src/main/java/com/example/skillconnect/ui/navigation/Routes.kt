package com.example.skillconnect.ui.navigation

sealed class Routes(val route: String) {
    data object WelcomeScreen : Routes("welcomeScreen")
    data object GetStartedScreen : Routes("getStartedScreen")
    data object HomeScreen : Routes("homeScreen")
    data object ClientHomeScreen : Routes("clientHomeScreen")
    data object SearchScreen : Routes("searchScreen")
    data object ClientSearchScreen : Routes("clientSearchScreen")
    data object MessageListScreen : Routes("messageListScreen")
    data object ProjectScreen : Routes("projectScreen")
    data object ProfileScreen : Routes("profileScreen")
    data object SignInScreen : Routes("signInScreen")
    data object ClientSignInScreen : Routes("clientSignInScreen")
    data object ClientSignUpScreen : Routes("clientSignUpScreen")
    data object FreelancerSignUpScreen : Routes("freeLancerSignUpScreen")
    data object FreelancerBasicDetailsScreen : Routes("freelancerBasicDetailsScreen")
    data object FreelancerSocialLinksScreen : Routes("freelancerSocialLinksScreen")
    data object FreelancerTechDetailsScreen : Routes("freelancerTechDetailsScreen")
    data object ClientBasicDetailsScreen : Routes("clientBasicDetailsScreen")
    data object ClientSocialLinksScreen : Routes("clientSocialLinksScreen")
    data object IncomeScreen : Routes("incomeScreen")


    data object AddNewProjectScreen : Routes("addNewProjectScreen")
    data object AddNewProjectScreen2 : Routes("addNewProjectScreen2")
    data object AddNewProjectScreen3 : Routes("addNewProjectScreen3")
}