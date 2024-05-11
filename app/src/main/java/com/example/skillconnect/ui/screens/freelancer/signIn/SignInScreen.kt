package com.example.skillconnect.ui.screens.freelancer.signIn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillconnect.ui.navigation.Routes
import com.example.skillconnect.ui.viewModel.AuthViewModel

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    if (viewModel.checkIfLoggedIn()) {
        navigateTo(Routes.HomeScreen.route)
    }
    Box(modifier = modifier.fillMaxSize()) {
        var password by remember { mutableStateOf(TextFieldValue()) }
        var email by remember { mutableStateOf(TextFieldValue()) }
        Column {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") }
            )
            Button(
                onClick = {
                    viewModel.signIn(email.text, password.text)
                    if (viewModel.checkIfLoggedIn()) {
                        navigateTo(Routes.HomeScreen.route)
                    }
                },
                enabled = email.text.isNotEmpty() && password.text.isNotEmpty()
            ) {
                Text("Sign In")
            }

            Text(
                "Already have an account? Sign Up",
                color = Color.Blue,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navigateTo("signUpScreen")
                    }
            )
        }
        if (viewModel.inProgress) {
            CircularProgress()
        }
    }
}

@Composable
fun CircularProgress(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .alpha(0.5f)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator()
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInScreenPreview() {
    val viewModel: AuthViewModel = hiltViewModel()
    SignInScreen(viewModel = viewModel, navigateTo = {})
}