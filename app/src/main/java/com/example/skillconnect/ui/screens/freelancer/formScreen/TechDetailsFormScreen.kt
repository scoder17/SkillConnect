package com.example.skillconnect.ui.screens.freelancer.formScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
fun TechDetailsFormScreen(
    modifier: Modifier = Modifier,
    onSubmitButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
    skillList: List<String>,
    onSkillAdded: () -> Unit,
    onSkillChange: (Int, String) -> Unit,
    onSkillRemoved: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .padding(16.dp)


    ) {
        Text(text = "Freelancer Info", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Time to know about skills so that we can recommend you the best projects",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.size(30.dp))
        LazyColumn {
            itemsIndexed(skillList) { index, item ->

                TechSkill(
                    skillCount = index,
                    skill = item,
                    onSkillChange = onSkillChange,
                    isLast = index == skillList.size - 1,
                    onSkillAdded = onSkillAdded,
                    onBackButtonClicked = onBackButtonClicked,
                    onSubmitButtonClicked = onSubmitButtonClicked,
                    onSkillRemoved = onSkillRemoved
                )
            }

        }

    }
}

@Composable
fun TechSkill(
    modifier: Modifier = Modifier,
    skillCount: Int,
    skill: String,
    onSkillRemoved: (Int) -> Unit,
    onSkillChange: (Int, String) -> Unit,
    isLast: Boolean,
    onSkillAdded: () -> Unit,
    onBackButtonClicked: () -> Unit,
    onSubmitButtonClicked: () -> Unit
) {

    var imeAction = ImeAction.Next
    if (isLast)
        imeAction = ImeAction.Done
    Text(
        text = "Name",
        modifier = Modifier.padding(bottom = 10.dp),
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray
    )

    OutlinedTextField(
        value = skill,
        onValueChange = { onSkillChange(skillCount, it) },
        placeholder = { Text(text = "Skill ${skillCount + 1}", color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        singleLine = true,
        trailingIcon = { Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", modifier = Modifier.clickable { onSkillRemoved(skillCount)})}
        )

    Spacer(modifier = Modifier.size(20.dp))
    if (isLast) {
        Button(onClick = onSkillAdded, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Skill")
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onBackButtonClicked, modifier = Modifier) {
                Text(text = "Back")
            }
            Button(onClick = onSubmitButtonClicked, modifier = Modifier) {
                Text(text = "Submit")
            }
        }
    }

}