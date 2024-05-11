package com.example.skillconnect.ui.screens.freelancer.formScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun BasicDetailsFormScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    emailId: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp),

        ) {
        Text(text = "Freelancer Info", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Let's Start by Knowing your basic details",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "Name",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        OutlinedTextField(
            value = name,
            onValueChange = { onNameChange(it) },
            placeholder = { Text(text = "Full Name", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            trailingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "name") }
        )

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Email Id",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        OutlinedTextField(
            value = emailId,
            onValueChange = { onEmailChange(it) },
            placeholder = { Text(text = "Example:- yourmail@gmail.com", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Password",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        OutlinedTextField(
            value = password,
            onValueChange = { onPasswordChange(it) },
            placeholder = { Text(text = "Example:- yourmail@gmail.com", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.RemoveRedEye,
                    contentDescription = "Email"
                )
            }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Confirm Password",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { onConfirmPasswordChange(it) },
            placeholder = { Text(text = "Example:- yourmail@gmail.com", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = "Email"
                )
            }
        )

        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {

            Button(
                onClick = onNextButtonClicked,
                modifier = Modifier,
                enabled = (password == confirmPassword) and password.isNotBlank()
            ) {
                Text(text = "Next")
            }
        }
    }
}