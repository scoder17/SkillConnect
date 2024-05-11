package com.example.skillconnect.ui.screens.freelancer.projectDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillconnect.ui.theme.SkillConnectTheme

@Composable
fun ProjectDetailsScreen(
    modifier: Modifier = Modifier, projectTitle: String,
    projectDescription: String,
    projectPay: String,
    projectRequiredSkill: List<String>,
    projectApplicants: Int,
    applyButtonOnClick: () -> Unit,
    projectDuration: String = "none",
    projectRolesAndResponsibilities: List<String>,
    aboutClient:String,
    clientName:String
) {
    Scaffold(topBar = { ProjectDetailsScreenTopBar() }, modifier = modifier) {
        ProjectDetailsContent(
            modifier = Modifier
                .padding(it)
                .padding(16.dp),
            projectTitle,
            projectDescription,
            projectPay,
            projectRequiredSkill,
            projectApplicants,
            applyButtonOnClick,
            projectDuration,
            projectRolesAndResponsibilities,
            aboutClient,
            clientName
        )
    }
}


@Composable
fun ProjectDetailsContent(
    modifier: Modifier = Modifier,
    projectTitle: String,
    projectDescription: String,
    projectPay: String,
    projectRequiredSkill: List<String>,
    projectApplicants: Int,
    applyButtonOnClick: () -> Unit,
    projectDuration: String,
    projectRolesAndResponsibilities: List<String>,
    aboutClient: String,
    clientName: String
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Text(text = projectTitle, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.size(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.MonetizationOn,
                contentDescription = "Pay",
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = projectPay, style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.size(10.dp))
        if (projectDuration != "none") {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Duration",
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(text = projectDuration, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Pay",
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(text = "$projectApplicants APPLICANTS", style = MaterialTheme.typography.bodyLarge)
        }
        HorizontalDivider()
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Description", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = projectDescription, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = "Roles and Responsibilities", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        for (responsibility in projectRolesAndResponsibilities) {
            Row {
                Icon(
                    imageVector = Icons.Filled.Circle, contentDescription = "point",
                    Modifier
                        .size(20.dp)
                        .padding(end = 10.dp)
                )
                Text(text = responsibility, style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.size(10.dp))
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = "Required Skill", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        for (skill in projectRequiredSkill) {
            Row {
                Icon(
                    imageVector = Icons.Filled.Circle, contentDescription = "point",
                    Modifier
                        .size(20.dp)
                        .padding(end = 10.dp)
                )
                Text(text = skill, style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.size(10.dp))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "About $clientName", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = aboutClient, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = { applyButtonOnClick() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Apply Now")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailsScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Project Details") })
}

@Preview
@Composable
fun ProjectDetailsScreenPreview(modifier: Modifier = Modifier) {
    SkillConnectTheme {
        ProjectDetailsScreen(
            projectDescription = "This is a project description. It will contain all the details regarding the project.",
            projectApplicants = 3,
            projectDuration = "Monday, 23 July 2022 9AM-6PM",
            projectTitle = "Cashier",
            projectPay = "$100/hr",
            projectRequiredSkill = listOf(
                "perform basic math function to collect payments and make change",
                "operate registers,scanner,scales,etc."
            ),
            applyButtonOnClick = {},
            projectRolesAndResponsibilities = listOf(
                "Design Leadership: Lead UI/UX design projects across the entire product lifecycle. Set the vision for the user experience and create the space for others to collaborate.",
                "User-Centered Design: Conduct user research, create user personas, and design wireframes, storyboards, sitemaps, and screen flows."
            ),
            aboutClient = "Edstem Technologies is a dynamic and fast-growing software company, with service offerings in custom software development, mobile app development, managed services, offshore augmentation, and software consulting. We translate the ideas and requirements of our clients into smart solutions in cutting-edge technologies, by employing agile tools and practices while involving them in every step of development. Our delighted clientele spanning the globe in multiple domains is a testimony both to the quality of our deliverables and to the technical prowess of our highly skilled team. We have a talent pool that is well-equipped to work on the latest technology and highly demanding projects, positioning us also as a key player in supplying technology manpower for clients across the globe.",
            clientName = "Edstem Technologies"
        )
    }
}
