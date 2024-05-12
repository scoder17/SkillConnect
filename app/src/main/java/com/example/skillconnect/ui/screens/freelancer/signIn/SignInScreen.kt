package com.example.skillconnect.ui.screens.freelancer.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.skillconnect.R
import com.example.skillconnect.ui.navigation.Routes
import com.example.skillconnect.ui.screens.client.signIn.CircularProgress
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
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.freelancersignin),
                contentDescription = "Sign In Logo freelancer",
                modifier = Modifier.width(500.dp).height(400.dp)
//                    .size(500.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Welcome back!",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Spacer(modifier = Modifier.weight(1f))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
//                    .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
//                    .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Don't have an account? Sign Up",
                        color = Color.Blue,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable {
                                navigateTo(Routes.FreelancerSignUpScreen.route)
                            }
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }
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