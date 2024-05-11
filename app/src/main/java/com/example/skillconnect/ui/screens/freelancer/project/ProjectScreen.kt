package com.example.skillconnect.ui.screens.freelancer.project

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skillconnect.ui.theme.SkillConnectTheme
import com.example.skillconnect.model.ProjectDetails

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProjectScreen(modifier: Modifier = Modifier) {
    val projectScreenViewModel: ProjectScreenViewModel = viewModel()
    Scaffold(
        topBar = { ProjectScreenTopBar() }
    ) {
        ProjectList(modifier = Modifier.padding(it),projectScreenViewModel.projectList)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Projects") })
}

@Composable
fun ProjectList(modifier: Modifier = Modifier,projectList: List<ProjectDetails> = listOf()) {

    var filterCriteria by remember {
        mutableStateOf("Active")
    }
    var activeSelected by remember {mutableStateOf(true)}
    var completedSelected by remember {mutableStateOf(false)}
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = {
                    completedSelected = false; activeSelected = true; filterCriteria = "Active"
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = if (activeSelected) Color.Blue else Color.Transparent)
            ) {
                Text(text = "Active")
            }
            OutlinedButton(
                onClick = {
                    completedSelected = true; activeSelected = false; filterCriteria = "Completed" ;  Log.d("filterCriteria", filterCriteria)
                },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = if (completedSelected) Color.Blue else Color.Transparent)
            ) {
                Text(text = "Completed")
            }
        }

        LazyColumn() {
            items(projectList.filter { it.projectStatus == filterCriteria }) {
                ProjectListItem(
                    image = it.image,
                    title = it.title,
                    description = it.description,
                    deadlineDate = it.deadlineDate,
                    payment = it.payment,
                    paymentStatus = it.paymentStatus,
                    projectStatus = it.projectStatus,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ProjectListItem(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    description: String,
    deadlineDate: String,
    payment: String,
    paymentStatus: String,
    projectStatus: String
) {
    Card(onClick = { /*TODO*/ }, modifier = modifier) {
        ProjectListItemTop(
            title = title,
            description = description,
            image = image,
            modifier = Modifier.padding(10.dp)
        )
        HorizontalDivider()
        ProjectListItemBottom(
            title = if(projectStatus!="Completed") deadlineDate else "Completed",
            description = if(projectStatus=="Completed") deadlineDate else "deadline",
            payment = payment,
            paymentStatus = paymentStatus,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 15.dp)
        )
    }

}

@Composable
fun ProjectListItemTop(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    image: Int,

) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Company logo",
            modifier = Modifier
                .padding(16.dp)
                .size(70.dp)
                .clip(
                    RoundedCornerShape(100.dp)
                )
        )
        Column {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "null",
            modifier = Modifier.clickable { /*to-do*/ }
        )

    }
}

@Composable
fun ProjectListItemBottom(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    payment: String,
    paymentStatus: String,

) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
        Column {
            Text(text = payment, style = MaterialTheme.typography.bodyLarge)
            Text(text = paymentStatus, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProjectScreenPreview(modifier: Modifier = Modifier) {
    SkillConnectTheme { ProjectScreen() }
}