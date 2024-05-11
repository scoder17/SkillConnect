package com.example.skillconnect.ui.screens.freelancer.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skillconnect.model.FreelancerIncomeDetails
import com.example.skillconnect.ui.theme.SkillConnectTheme

@Composable
fun IncomeScreen(modifier: Modifier = Modifier) {
    val incomeScreenViewModel:IncomeScreenViewModel = viewModel()
    Scaffold (topBar = { IncomeScreenTopBar()}, modifier = modifier) {
        IncomeScreenContent(modifier = Modifier
            .padding(it)
            .padding(10.dp),freelancerIncomeHistory = incomeScreenViewModel.freelancerIncomeHistory)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Transaction History") }, modifier = modifier)
}

@Composable
fun IncomeScreenContent(modifier: Modifier = Modifier,freelancerIncomeHistory:List<FreelancerIncomeDetails>) {
    Column(modifier = modifier) {
        Text(text = "Work History", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        LazyColumn() {
            items(freelancerIncomeHistory) {
                ProjectIncomeDetails(
                    rating = it.rating,
                    projectName = it.projectName,
                    projectDuration = it.projectDuration,
                    projectPayment = it.projectPayment,
                    modifier = Modifier.fillMaxWidth().padding(10.dp)
                )
            }
        }

    }
}
@Composable
fun ProjectIncomeDetails(
    modifier: Modifier = Modifier,
    rating: Double,
    projectName: String,
    projectDuration: String,
    projectPayment: String
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = projectName, style = MaterialTheme.typography.titleLarge)
                Text(text = projectDuration, style = MaterialTheme.typography.bodyMedium)
            }
            Column {
                Text(text = "$${projectPayment}", style = MaterialTheme.typography.titleLarge)
            }

        }
    }
    Spacer(modifier = Modifier.size(10.dp))
    HorizontalDivider()
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IncomeScreenPreview(modifier: Modifier = Modifier) {
    SkillConnectTheme {
        IncomeScreen()
    }
}
