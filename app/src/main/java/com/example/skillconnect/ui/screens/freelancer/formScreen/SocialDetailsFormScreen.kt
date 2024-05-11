package com.example.skillconnect.ui.screens.freelancer.formScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.skillconnect.R
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialLinksFormScreen(
    modifier:Modifier = Modifier,
    onNextButtonClicked :()->Unit,
    onBackButtonClicked :()->Unit,
    linkedIn:String,
    github:String,
    twitter:String,
    onLinkedInChange:(String)->Unit,
    onGithubChange:(String)->Unit,
    onTwitterChange:(String)->Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp),

        ) {
        Text(text = "Freelancer Info", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Time for some of your socials",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "linkedin",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        OutlinedTextField(
            value = linkedIn,
            onValueChange = { onLinkedInChange(it) },
            placeholder = { Text(text = "linkedIn profile link", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            maxLines = 1,
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.linkedin), contentDescription = "linkedIn",modifier = Modifier.size(30.dp) )}
            )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "github",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        OutlinedTextField(
            value = github,
            onValueChange = { onGithubChange(it) },
            placeholder = { Text(text = "github profile link", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.linkedin), contentDescription = "github",modifier = Modifier.size(30.dp))}
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "twitter",
            modifier = Modifier.padding(bottom = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        OutlinedTextField(
            value = twitter,
            onValueChange = { onTwitterChange(it) },
            placeholder = { Text(text = "twitter profile link", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine = true,
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.twitter), contentDescription = "twitter",modifier = Modifier.size(30.dp))}
        )

        Spacer(modifier = Modifier.size(20.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){

            Button(onClick =  onBackButtonClicked,modifier = Modifier) {
                Text(text = "Back")
            }
            Button(onClick =  onNextButtonClicked,modifier = Modifier) {
                Text(text = "Next")
            }
        }
    }
}