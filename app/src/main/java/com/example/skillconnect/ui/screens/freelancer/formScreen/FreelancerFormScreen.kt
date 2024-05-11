package com.example.skillconnect.ui.screens.freelancer.formScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skillconnect.R
import com.example.skillconnect.ui.navigation.Routes
import com.example.skillconnect.ui.theme.SkillConnectTheme


@Composable
fun FreelancerFormScreenTopBar(modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "banner",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FreelancerFormScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    formScreenViewModel: FormScreenViewModel
) {
    val formScreenUiState by formScreenViewModel.uiState.collectAsState()
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

@Preview
@Composable
fun FreelancerFormScreenPreview(modifier: Modifier = Modifier) {
    SkillConnectTheme {
        FreelancerFormScreen(
            navController = rememberNavController(),
            formScreenViewModel = viewModel()
        )
    }
}