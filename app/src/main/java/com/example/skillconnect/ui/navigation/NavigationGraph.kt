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
import com.example.connectly.ui.screens.client.clientProject.ClientProjectScreen
import com.example.skillconnect.R
import com.example.skillconnect.model.FreeLancerData
import com.example.skillconnect.ui.screens.client.addProjectScreen.AddNewProjectScreen
import com.example.skillconnect.ui.screens.client.addProjectScreen.AddNewProjectScreen2
import com.example.skillconnect.ui.screens.client.addProjectScreen.AddNewProjectScreen3
import com.example.skillconnect.ui.screens.client.addProjectScreen.AddNewProjectScreenUIState
import com.example.skillconnect.ui.screens.client.addProjectScreen.AddNewProjectScreenViewModel
import com.example.skillconnect.ui.screens.client.home.ClientHomeScreen
import com.example.skillconnect.ui.screens.client.searchScreen.ClientSearchScreen
import com.example.skillconnect.ui.screens.client.clientFormScreen.ClientBasicDetailsFormScreen
import com.example.skillconnect.ui.screens.client.clientFormScreen.ClientFormScreen
import com.example.skillconnect.ui.screens.client.clientFormScreen.ClientFormScreenViewModel
import com.example.skillconnect.ui.screens.client.clientFormScreen.ClientSocialLinksFormScreen
import com.example.skillconnect.ui.screens.client.clientProfile.ClientProfileScreen
import com.example.skillconnect.ui.screens.client.home.ClientIncomeScreen
import com.example.skillconnect.ui.screens.client.signIn.ClientSignInScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.BasicDetailsFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.FormScreenViewModel
import com.example.skillconnect.ui.screens.freelancer.formScreen.FreelancerFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.SocialLinksFormScreen
import com.example.skillconnect.ui.screens.freelancer.formScreen.TechDetailsFormScreen
import com.example.skillconnect.ui.screens.freelancer.home.HomeScreen
import com.example.skillconnect.ui.screens.freelancer.home.IncomeScreen
import com.example.skillconnect.ui.screens.freelancer.message.MessageListScreen
import com.example.skillconnect.ui.screens.freelancer.profile.ProfileScreen
import com.example.skillconnect.ui.screens.freelancer.project.ProjectScreen
import com.example.skillconnect.ui.screens.freelancer.search.SearchScreen
import com.example.skillconnect.ui.screens.freelancer.signIn.SignInScreen
import com.example.skillconnect.ui.screens.welcome.GetStartedScreen
import com.example.skillconnect.ui.screens.welcome.WelcomeScreen
import com.example.skillconnect.ui.viewModel.AuthViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    formScreenViewModel: FormScreenViewModel,
    clientFormScreenViewModel: ClientFormScreenViewModel,
    addNewProjectScreenViewModel: AddNewProjectScreenViewModel,
    onBottomBarVisibilityChanged: (Boolean) -> Unit
) {
    val formScreenUiState by formScreenViewModel.uiState.collectAsState()
    val clientFormScreenUiState by clientFormScreenViewModel.uiState.collectAsState()
    NavHost(navController = navController, startDestination = "welcomeScreen") {

        composable("welcomeScreen") {
            onBottomBarVisibilityChanged(false)
            WelcomeScreen(navigateToNext = { navController.navigate(it) })
        }

        composable("searchScreen") {
            onBottomBarVisibilityChanged(true)
            SearchScreen(authViewModel = authViewModel)
        }

        composable("clientSearchScreen") {
            onBottomBarVisibilityChanged(true)
            ClientSearchScreen(authViewModel = authViewModel)
        }

        composable("getStartedScreen") {
            onBottomBarVisibilityChanged(false)
            GetStartedScreen(navController = navController)
        }

        composable("signInScreen") {
            onBottomBarVisibilityChanged(false)
            SignInScreen(viewModel = authViewModel, navigateTo = { navController.navigate(it) })
        }

        composable(Routes.ClientSignInScreen.route) {
            onBottomBarVisibilityChanged(false)
            ClientSignInScreen(
                viewModel = authViewModel,
                navigateTo = { navController.navigate(it) })
        }
        composable("freeLancerSignUpScreen") {
            onBottomBarVisibilityChanged(false)
            FreelancerFormScreen(
                navController = navController,
                formScreenViewModel = formScreenViewModel
            )
        }
        composable(Routes.ClientSignUpScreen.route) {

            onBottomBarVisibilityChanged(false)
            ClientFormScreen(
                navController = navController,
                clientFormScreenViewModel = clientFormScreenViewModel
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

        composable("clientHomeScreen") {
            onBottomBarVisibilityChanged(true)
            ClientHomeScreen(navigateToNext = { navController.navigate(it) })
        }

        composable("projectScreen") {
            onBottomBarVisibilityChanged(true)
            ProjectScreen()
        }

        composable("incomeScreen") {
            onBottomBarVisibilityChanged(true)
            IncomeScreen()
        }

        composable("messageListScreen") {
            onBottomBarVisibilityChanged(true)
            MessageListScreen()
        }

        composable("profileScreen") {
            onBottomBarVisibilityChanged(true)
            ProfileScreen(onLogOut = {
                authViewModel.logout()
                navController.navigate(Routes.GetStartedScreen.route) {
                    popUpTo(0)
                }
            }, currentFreelancer = authViewModel.currentfreelancer ?: FreeLancerData())
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
        composable(Routes.ClientBasicDetailsScreen.route) {
            BasicDetailsFormScreen(
                modifier = Modifier.fillMaxSize(),
                onNextButtonClicked = { navController.navigate(Routes.ClientSocialLinksScreen.route) },
                name = clientFormScreenUiState.name,
                onNameChange = { clientFormScreenViewModel.updateName(it) },
                emailId = clientFormScreenUiState.email,
                onEmailChange = { clientFormScreenViewModel.updateEmail(it) },
                password = clientFormScreenUiState.password,
                onPasswordChange = { clientFormScreenViewModel.updatePassword(it) },
                confirmPassword = clientFormScreenUiState.confirmPassword,
                onConfirmPasswordChange = { clientFormScreenViewModel.updateConfirmPassword(it) },
            )
        }
        composable(Routes.ClientSocialLinksScreen.route) {
            ClientSocialLinksFormScreen(
                modifier = Modifier.fillMaxSize(),
                onSubmitButtonClicked = {
                    authViewModel.signUpClient(
                        name = clientFormScreenUiState.name,
                        email = clientFormScreenUiState.email,
                        linkedIn = clientFormScreenUiState.linkedIn,
                        twitter = clientFormScreenUiState.twitter,
                        password = clientFormScreenUiState.password
                    )
                    navController.navigate(Routes.ClientSignInScreen.route)
                },
                onBackButtonClicked = {
                    navController.navigate(Routes.ClientBasicDetailsScreen.route)
                },
                linkedIn = clientFormScreenUiState.linkedIn,
                twitter = clientFormScreenUiState.twitter,
                onLinkedInChange = { clientFormScreenViewModel.updateLinkedIn(it) },
                onTwitterChange = { clientFormScreenViewModel.updateTwitter(it) },
            )
        }
        composable(Routes.AddNewProjectScreen.route) {
            AddNewProjectScreen(
                addNewProjectScreenViewModel = addNewProjectScreenViewModel,
                onNextClicked = { navController.navigate(Routes.AddNewProjectScreen2.route) })
        }
        composable(Routes.AddNewProjectScreen2.route) {
            AddNewProjectScreen2(
                addNewProjectScreenViewModel = addNewProjectScreenViewModel,
                onNextClick = { navController.navigate(Routes.AddNewProjectScreen3.route) },
                onBackClick = { navController.navigate(Routes.AddNewProjectScreen.route) })
        }
        composable(Routes.AddNewProjectScreen3.route) {
            AddNewProjectScreen3(
                addNewProjectScreenViewModel = addNewProjectScreenViewModel,
                onNavigateBack = { navController.navigate(Routes.AddNewProjectScreen2.route) },
                onSubmitButtonClicked = {})
        }

        composable("clientIncomeScreen") {
            onBottomBarVisibilityChanged(false)
            ClientIncomeScreen()
        }

        composable("clientProjectScreen") {
            onBottomBarVisibilityChanged(false)
            ClientProjectScreen()
        }

        composable("clientProfileScreen") {
            onBottomBarVisibilityChanged(true)
            ClientProfileScreen(onLogOut = {
                authViewModel.logout()
                navController.navigate(Routes.GetStartedScreen.route) {
                    popUpTo(0)
                }})
        }
    }
}