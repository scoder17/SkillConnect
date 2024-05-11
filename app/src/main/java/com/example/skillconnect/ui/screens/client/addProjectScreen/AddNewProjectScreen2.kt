package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun AddnewProjectScreen2(
    modifier: Modifier=Modifier
){

}

@Composable
fun Project2Screen(
    modifier: Modifier = Modifier,
    skill: String,
    jobRequirements:String,
    skills:List<String>,
    onUpdateSkills: (String) -> Unit,
    onRemoveSkills: (Int) -> Unit,
    onJobRequired: (String) -> Unit
){
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
            trailingIcon = { Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "OK",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { onUpdateSkills(tempSkill) }
            )}
        )
        
        OutlinedTextField(
            value = jobRequirements,
            onValueChange = {onJobRequired(it)},
            label = { Text(text = "job Requirements")},

        )
        
        Button(onClick = { /*TODO*/ }) {
            
        }
    }
}



