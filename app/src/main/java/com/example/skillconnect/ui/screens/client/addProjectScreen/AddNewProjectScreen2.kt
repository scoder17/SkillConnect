package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            onJobRequired = { addNewProjectScreenViewModel.jobRequired(it) },
            onUpdateSkills = { addNewProjectScreenViewModel.updateSkills(it) },
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
                        .clickable { onUpdateSkills(tempSkill);tempSkill = "" }
                )
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Skills")}
        )

        Spacer(modifier = Modifier.size(10.dp))

        FlowRow {
            skills.forEachIndexed { index, s ->
                Card(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                        .clip(RoundedCornerShape(100.dp))
//            .border(
//                BorderStroke(1.dp, Color(0xFF018786)), shape = RoundedCornerShape(100.dp)
//            )
//            .padding(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = s,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "OK",
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clickable { onRemoveSkills(index) }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        OutlinedTextField(
            value = jobRequirements,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { onJobRequired(it) },
            label = { Text(text = "job Requirements") },
            leadingIcon = { Icon(imageVector = Icons.Default.Work, contentDescription = "job Requirements")}
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onBackClick) {
                Text(text = "Back")
            }
            Button(onClick = onNextClick) {
                Text(text = "Next")
            }
        }
    }
}



