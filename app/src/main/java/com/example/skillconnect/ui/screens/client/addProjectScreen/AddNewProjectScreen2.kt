package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddNewProjectScreen2(
    modifier: Modifier = Modifier,
    addNewProjectScreenViewModel: AddNewProjectScreenViewModel,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val addNewProjectScreen2UIState by addNewProjectScreenViewModel.uiState.collectAsState()

    Scaffold(topBar = { AddNewProjectScreenTopBar() }) {
        Project2Screen(
            modifier = Modifier.padding(it),
            skills = addNewProjectScreen2UIState.skills,
            onRemoveSkills = { addNewProjectScreenViewModel.removeSkills(it) },
            onJobRequired = {addNewProjectScreenViewModel.jobRequired(it)},
            onUpdateSkills = {addNewProjectScreenViewModel.updateSkills(it)},
            jobRequirements = addNewProjectScreen2UIState.jobRequirements,
            onBackClick = onBackClick,
            onNextClick = onNextClick
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Project2Screen(
    modifier: Modifier = Modifier,
    jobRequirements: String,
    skills: List<String>,
    onUpdateSkills: (String) -> Unit,
    onRemoveSkills: (Int) -> Unit,
    onJobRequired: (String) -> Unit,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        var tempSkill by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = tempSkill,
            onValueChange = { tempSkill = it },
            label = { Text("Skill") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "OK",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { onUpdateSkills(tempSkill) }
                )
            }
        )
        FlowRow {

        }
        OutlinedTextField(
            value = jobRequirements,
            onValueChange = { onJobRequired(it) },
            label = { Text(text = "job Requirements") },
            )

        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onBackClick) {
                Text(text = "Back")
            }
            Button(onClick = onNextClick) {
                Text(text = "Next")
            }
        }
    }
}



