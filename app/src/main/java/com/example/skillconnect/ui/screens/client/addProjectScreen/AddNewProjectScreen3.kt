package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
fun DetailsOfCompany() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            var tempAbout by remember {
                mutableStateOf("")
            }
            var tempRolesResponsibilities by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = tempAbout,
                onValueChange = { tempAbout = it },
                label = { Text(text = "About Company") },
                maxLines = 70
            )
            OutlinedTextField(
                value = tempRolesResponsibilities,
                onValueChange = { tempRolesResponsibilities = it },
                label = { Text(text = "About Company") },
                maxLines = 100
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ })
        {
            Text(text = "Next")
        }
    }
}