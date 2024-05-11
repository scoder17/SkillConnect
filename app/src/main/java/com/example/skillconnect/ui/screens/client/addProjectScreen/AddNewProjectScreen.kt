package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddNewProjectScreen(modifier: Modifier = Modifier) {
    val addNewProjectScreenViewModel: AddNewProjectScreenViewModel = viewModel()
    val addNewProjectScreenUIState by addNewProjectScreenViewModel.uiState.collectAsState()
    Scaffold(topBar = { AddNewProjectScreenTopBar() }) {
        AddNewProject(
            modifier = Modifier.padding(it),
            title = addNewProjectScreenUIState.title,
            description = addNewProjectScreenUIState.description,
            budget = addNewProjectScreenUIState.budget,
            deadLine = addNewProjectScreenUIState.deadline,
            onBudgetChange = { addNewProjectScreenViewModel.updateBudget(it) },
            onDescriptionChange = { addNewProjectScreenViewModel.updateDescription(it) },
            onDeadLineChange = { addNewProjectScreenViewModel.updateDeadline(it) },
            onTitleChange = { addNewProjectScreenViewModel.updateTitle(it) }
        )
    }
}

@Composable
fun AddNewProject(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    budget: String,
    deadLine: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onBudgetChange: (String) -> Unit,
    onDeadLineChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(16.dp),

        ) {

        Spacer(modifier = Modifier.size(30.dp))
//

        OutlinedTextField(
            label = { Text(text = "Title", color = Color.Gray) },
            value = title,
            onValueChange = { onTitleChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "name") }
        )
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            label = { Text(text = "Description", color = Color.Gray) },
            value = description,
            onValueChange = { onDescriptionChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") }
        )
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            label = { Text(text = "Budget", color = Color.Gray) },
            value = budget,
            onValueChange = { onBudgetChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
            leadingIcon = { Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = "budget") }
        )
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            label = { Text(text = "Deadline", color = Color.Gray) },
            value = deadLine,
            onValueChange = { onDeadLineChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            leadingIcon = { Icon(imageVector = Icons.Default.AccessTime, contentDescription = "deadLine") }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Next")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewProjectScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Add New Project") })
}
@Preview
@Composable
fun AddNewProjectScreenPreview() {
    val addNewProjectScreenViewModel: AddNewProjectScreenViewModel = viewModel()
    val addNewProjectScreenUIState by addNewProjectScreenViewModel.uiState.collectAsState()
    Scaffold(topBar = { AddNewProjectScreenTopBar() }) {
        AddNewProject(
            modifier = Modifier.padding(it),
            title = addNewProjectScreenUIState.title,
            description = addNewProjectScreenUIState.description,
            budget = addNewProjectScreenUIState.budget,
            deadLine = addNewProjectScreenUIState.deadline,
            onBudgetChange = { addNewProjectScreenViewModel.updateBudget(it) },
            onDescriptionChange = { addNewProjectScreenViewModel.updateDescription(it) },
            onDeadLineChange = { addNewProjectScreenViewModel.updateDeadline(it) },
            onTitleChange = { addNewProjectScreenViewModel.updateTitle(it) }
        )
    }
}