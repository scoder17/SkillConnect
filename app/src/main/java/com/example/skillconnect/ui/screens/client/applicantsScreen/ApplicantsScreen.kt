package com.example.skillconnect.ui.screens.client.applicantsScreen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skillconnect.model.ApplicantsListItemData
import com.example.skillconnect.ui.theme.SkillConnectTheme

@Composable
fun ApplicantsScreen(modifier: Modifier = Modifier) {
    val applicantsScreenViewModel: ApplicantsScreenViewModel = viewModel()
    Scaffold(topBar = { ApplicantsScreenTopBar() }) {
        ApplicantsList(
            modifier = Modifier.padding(it),
            applicants = applicantsScreenViewModel.applicants
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicantsScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text("Applicants") })
}

@Composable
fun ApplicantsList(
    modifier: Modifier = Modifier,
    applicants: List<ApplicantsListItemData> = emptyList(),
    onHireClick: () -> Unit = {},
    onSeeMoreClick: () -> Unit = {}
) {
    LazyColumn(modifier = modifier) {
        items(applicants) {
            ApplicationListItem(
                freelancerProfileImage = it.profileImage,
                freelancerName = it.name,
                freelancerLocation = it.location,
                skills = it.skills,
                onSeeMoreClick = { /*TODO*/ },
                onHireClick = { /*TODO*/ },
                modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun ApplicationListItem(
    modifier: Modifier = Modifier,
    freelancerProfileImage: Int,
    freelancerName: String,
    freelancerLocation: String,
    skills: String,
    onSeeMoreClick: () -> Unit,
    onHireClick: () -> Unit
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = freelancerProfileImage),
                    contentDescription = "freelancer profile Image",
                    modifier = Modifier.clip(
                        RoundedCornerShape(100.dp)
                    ).size(70.dp)
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = freelancerName, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp))
                    Row {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "freelancerLocation"
                        )
                        Text(text = freelancerLocation)
                    }
                }
            }
            Text(text = "Skills", fontWeight = FontWeight.Bold)
            Text(text = skills)
            Spacer(modifier = Modifier.size(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = onSeeMoreClick,modifier = Modifier.weight(1f).padding(end = 10.dp)) {
                    Text(text = "See More")
                }
                Button(onClick = onHireClick,modifier = Modifier.weight(1f)) {
                    Text(text = "Hire")
                }
            }
        }
    }
}

@Preview
@Composable
fun ApplicationListItemPreview() {
    SkillConnectTheme {
        ApplicantsScreen()
    }

}