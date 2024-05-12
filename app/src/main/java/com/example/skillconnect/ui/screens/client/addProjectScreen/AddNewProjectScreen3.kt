package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddNewProjectScreen3(
    modifier: Modifier = Modifier,
    addNewProjectScreenViewModel: AddNewProjectScreenViewModel,
    onNavigateBack: () -> Unit,
    onSubmitButtonClicked: () -> Unit
) {
    val addNewProjectScreen3UIState by addNewProjectScreenViewModel.uiState.collectAsState()

    Scaffold(topBar = { AddNewProjectScreenTopBar() }) {
        DetailsOfCompany(
            aboutClient = addNewProjectScreen3UIState.aboutClient,
            rolesResponsibilities = addNewProjectScreen3UIState.rolesAndResponsibilities,
            modifier = Modifier.padding(it),
            updateAboutClient = { addNewProjectScreenViewModel.updateAboutClient(it) },
            updateRolesResponsibilities = { addNewProjectScreenViewModel.updateRolesAndResponsibilities(it) },
            onNavigateBack = onNavigateBack,
            onSubmitButtonClicked = onSubmitButtonClicked
        )
    }
}
@Composable
fun DetailsOfCompany(
    aboutClient:String,
    rolesResponsibilities:String,
    modifier: Modifier = Modifier,
    updateAboutClient: (String) -> Unit = {},
    updateRolesResponsibilities: (String) -> Unit = {},
    onNavigateBack: () -> Unit,
    onSubmitButtonClicked: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            OutlinedTextField(
                value = aboutClient,
                onValueChange = { updateAboutClient(it) },
                label = { Text(text = "About Company") },
                maxLines = 70
            )
            OutlinedTextField(
                value = rolesResponsibilities,
                onValueChange = { updateRolesResponsibilities(it) },
                label = { Text(text = "About Company") },
                maxLines = 100
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick =onNavigateBack) {
                Text(text = "Back")
            }
            Button(onClick = onSubmitButtonClicked) {
                Text(text = "Submit")
            }
        }
    }
}