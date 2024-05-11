package com.example.skillconnect.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.skillconnect.R
import com.example.skillconnect.ui.screens.freelancer.formScreen.BasicDetailsFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.FormScreenViewModel
import com.example.skillconnect.ui.screens.freelancer.formScreen.FreelancerFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.SocialLinksFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.TechDetailsFormScreen
import com.example.skillconnect.ui.screens.freelancer.home.HomeScreen
import com.example.skillconnect.ui.screens.freelancer.message.MessageListScreen
import com.example.skillconnect.ui.screens.freelancer.profile.ProfileScreen
import com.example.skillconnect.ui.screens.freelancer.project.ProjectScreen
import com.example.skillconnect.ui.screens.freelancer.signIn.SignInScreen
import com.example.skillconnect.ui.screens.welcome.GetStartedScreen
import com.example.skillconnect.ui.screens.welcome.WelcomeScreen
import com.example.skillconnect.ui.viewModel.AuthViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    formScreenViewModel: FormScreenViewModel,
    onBottomBarVisibilityChanged: (Boolean) -> Unit
) {
    val formScreenUiState by formScreenViewModel.uiState.collectAsState()
    NavHost(navController = navController, startDestination = "welcomeScreen") {

        composable("welcomeScreen") {
            onBottomBarVisibilityChanged(false)
            WelcomeScreen(navigateToNext = { navController.navigate(it) })
        }

        composable("getStartedScreen") {
            onBottomBarVisibilityChanged(false)
            GetStartedScreen(navController = navController)
        }

        composable("signInScreen") {
            onBottomBarVisibilityChanged(false)
            SignInScreen(viewModel = authViewModel, navigateTo = { navController.navigate(it) })
        }
        composable("signUpScreen") {
            onBottomBarVisibilityChanged(false)
            FreelancerFormScreen(
                navController = navController,
                formScreenViewModel = formScreenViewModel
            )
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
                navigateToNext = { navController.navigate(it) },
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

        composable("projectScreen") {
            onBottomBarVisibilityChanged(true)
            ProjectScreen()
        }

        composable("messageListScreen") {
            onBottomBarVisibilityChanged(true)
            MessageListScreen()
        }

        composable("profileScreen") {
            onBottomBarVisibilityChanged(true)
            ProfileScreen(onLogOut = {
                authViewModel.logout()
                navController.navigate(Routes.SignInScreen.route) {
                    popUpTo(0)
                }
            })
        }

        composable(Routes.FreelancerBasicDetailsScreen.route) {
            BasicDetailsFormScreen(
                modifier = Modifier.fillMaxSize(),
                onNextButtonClicked = { navController.navigate(Routes.FreelancerSocialLinksScreen.route) },
                name = formScreenUiState.name,
                onNameChange = { formScreenViewModel.updateName(it) },
                emailId = formScreenUiState.email,
                onEmailChange = { formScreenViewModel.updateEmail(it) },
                password = formScreenUiState.password,
                onPasswordChange = { formScreenViewModel.updatePassword(it) },
                confirmPassword = formScreenUiState.confirmPassword,
                onConfirmPasswordChange = { formScreenViewModel.updateConfirmPassword(it) },
            )
        }
        composable(Routes.FreelancerSocialLinksScreen.route) {
            SocialLinksFormScreen(
                modifier = Modifier.fillMaxSize(),
                onNextButtonClicked = { navController.navigate(Routes.FreelancerTechDetailsScreen.route) },
                onBackButtonClicked = { navController.navigate(Routes.FreelancerBasicDetailsScreen.route) },
                github = formScreenUiState.github,
                onGithubChange = { formScreenViewModel.updateGithub(it) },
                linkedIn = formScreenUiState.linkedIn,
                onLinkedInChange = { formScreenViewModel.updateLinkedIn(it) },
                twitter = formScreenUiState.twitter,
                onTwitterChange = { formScreenViewModel.updateTwitter(it) },
            )
        }
        composable(Routes.FreelancerTechDetailsScreen.route) {
            TechDetailsFormScreen(
                modifier = Modifier.fillMaxSize(),
                onSubmitButtonClicked = {
                    authViewModel.signUp(
                        name = formScreenUiState.name,
                        email = formScreenUiState.email,
                        github = formScreenUiState.github,
                        linkedIn = formScreenUiState.linkedIn,
                        twitter = formScreenUiState.twitter,
                        skills = formScreenViewModel.skills,
                        password = formScreenUiState.password
                    )
                    navController.navigate(Routes.SignInScreen.route)
                },
                onBackButtonClicked = { navController.navigate(Routes.FreelancerSocialLinksScreen.route) },
                skillList = formScreenViewModel.skills,
                onSkillAdded = { formScreenViewModel.addSkill() },
                onSkillChange = { index, value ->
                    formScreenViewModel.updateSkill(index, value)
                },
                onSkillRemoved = { formScreenViewModel.removeSkill(it) }
            )

        }

    }
}