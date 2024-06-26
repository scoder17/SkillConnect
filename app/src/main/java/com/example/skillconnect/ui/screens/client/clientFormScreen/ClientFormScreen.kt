package com.example.skillconnect.ui.screens.client.clientFormScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.skillconnect.R
import com.example.skillconnect.ui.navigation.Routes
import com.example.skillconnect.ui.screens.freelancer.formScreen.BasicDetailsFormScreen
import com.example.skillconnect.ui.theme.SkillConnectTheme


enum class FreelancerFormScreenType {
    ClientBasicDetails,
    ClientSocialLinks,
    ClientTechDetails
}

@Composable
fun ClientFormScreenTopBar(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "banner",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ClientFormScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    clientFormScreenViewModel: ClientFormScreenViewModel = viewModel()
) {
    val clientFormScreenUiState by clientFormScreenViewModel.uiState.collectAsState()
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

//            composable(FreelancerFormScreenType.ClientTechDetails.name) {
//                TechDetailsFormScreen(
//                    modifier = Modifier.fillMaxSize(),
//                    onSubmitButtonClicked = { navController.navigate(FreelancerFormScreenType.ClientBasicDetails.name) },
//                    onBackButtonClicked = { navController.navigate(FreelancerFormScreenType.ClientSocialLinks.name) },
//                    skillList = formScreenViewModel.skills,
//                    onSkillAdded = { formScreenViewModel.addSkill()},
//                    onSkillChange = { index, value->
//                        formScreenViewModel.updateSkill(index,value)
//                    }
//                )
//
//            }

}

@Preview
@Composable
fun ClientFormScreenPreview(modifier: Modifier = Modifier) {
    SkillConnectTheme {
        ClientFormScreen()
    }
}