package com.example.skillconnect.ui.screens.freelancer.profile

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FileOpen
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skillconnect.ui.theme.SkillConnectTheme
import com.example.skillconnect.R
import com.example.skillconnect.data.Freelancer
import com.example.skillconnect.model.FreeLancerData
import com.example.skillconnect.model.FreelancerIncomeDetails
import com.example.skillconnect.ui.components.ChipsComponent
import com.example.skillconnect.ui.viewModel.AuthViewModel
import kotlin.math.min

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onLogOut: () -> Unit = {},
    currentFreelancer: FreeLancerData = FreeLancerData()
) {
    Log.d("TAG", "ProfileScreen: $currentFreelancer")
    val profileScreenViewModel: ProfileScreenViewModel = viewModel()
    val profileScreenUiState by profileScreenViewModel.uiState.collectAsState()
    Scaffold(
        topBar = { ProfileScreenTopBar(onLogOut = onLogOut) }
    ) {
        ProfileContent(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 8.dp),
            profileScreenUiState = profileScreenUiState,
            userWorkHistory = profileScreenViewModel.freelancerWorkHistory,
            currentFreelancer = currentFreelancer
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenTopBar(modifier: Modifier = Modifier, onLogOut: () -> Unit = {}) {
    TopAppBar(title = {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
            Text(text = "Profile")
            Button(onClick = onLogOut) {
                Text(text = "Log Out")
            }
        }
    })
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    profileScreenUiState: ProfileScreenUiState,
    currentFreelancer: FreeLancerData,
    userWorkHistory: List<FreelancerIncomeDetails> = listOf()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.FillWidth
            )
            Box(Modifier.padding(top = 85.dp, start = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Profile_image",
                    modifier = Modifier
                        .size(100.dp)
                        .padding()

                        .clip(
                            RoundedCornerShape(1000.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = Color.White

                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        UserBasicInfo(
            modifier = Modifier
                .padding(start = 15.dp)
                .fillMaxWidth(),
            userName = currentFreelancer.name,
            userLocation = profileScreenUiState.location,
            userDescription = profileScreenUiState.bio,
            userLinkedinId = currentFreelancer.linkedIn,
            userTwitterId = currentFreelancer.twitter,
            userGithubId = currentFreelancer.github
        )
        Spacer(modifier = Modifier.size(10.dp))
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .clip(RoundedCornerShape(100))
                .fillMaxWidth()
                .background(color = Color.Gray)
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserRatingAndProjectsDone(
            modifier = Modifier.padding(8.dp),
            userProjectsDone = profileScreenUiState.projectsDone,
            userRating = profileScreenUiState.rating
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserAboutMe(
            modifier = Modifier.padding(8.dp),
            aboutUser = profileScreenUiState.aboutUser
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserTechStack(modifier = Modifier.padding(8.dp), currentFreelancer = currentFreelancer)
        Spacer(modifier = Modifier.size(10.dp))
        UserWorkHistory(modifier = Modifier.padding(8.dp), userWorkHistory = userWorkHistory)
    }
}


@Composable
fun UserWorkHistory(
    modifier: Modifier = Modifier,
    userWorkHistory: List<FreelancerIncomeDetails> = listOf()
) {
    Column(modifier = modifier) {
        Text(
            text = "Work History",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        Column {
            for (int in 0 until min(userWorkHistory.size, 4)) {
                UserWorkProjectDetails(
                    rating = userWorkHistory[int].rating,
                    projectName = userWorkHistory[int].projectName,
                    projectDuration = userWorkHistory[int].projectDuration,
                    projectPayment = userWorkHistory[int].projectPayment
                )

            }
        }

    }
}

@Composable
fun UserWorkProjectDetails(
    modifier: Modifier = Modifier,
    rating: Double,
    projectName: String,
    projectDuration: String,
    projectPayment: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = projectName,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = projectDuration, style = MaterialTheme.typography.bodyMedium)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(text = "$${projectPayment}", style = MaterialTheme.typography.titleLarge)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End

                ) {
                for (int in 1..rating.toInt())
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "Star",
                        modifier = Modifier.size(18.dp),
                    )
                for (int in (rating + 1).toInt()..5)
                    Icon(
                        imageVector = Icons.Outlined.StarBorder,
                        contentDescription = "Star",
                        modifier = Modifier.size(18.dp),
                    )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = rating.toString())
            }

        }

    }
    Spacer(modifier = Modifier.size(10.dp))
    HorizontalDivider()
}

@Composable
fun UserRatingAndProjectsDone(
    modifier: Modifier = Modifier,
    userRating: Double,
    userProjectsDone: Int
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        IconWithText(
            heading = userRating.toString(),
            description = "Rating",
            icon = Icons.Default.Star
        )
        VerticalDivider(Modifier.height(60.dp))
        IconWithText(
            heading = userProjectsDone.toString(),
            description = "Projects Done",
            icon = Icons.Outlined.FileOpen
        )
    }
}

@Composable
fun UserAboutMe(modifier: Modifier = Modifier, aboutUser: String) {
    Column(modifier = modifier) {
        Text(
            text = "About Me",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = aboutUser)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserTechStack(modifier: Modifier = Modifier, currentFreelancer: FreeLancerData) {
    Column(modifier = modifier) {
        Text(
            text = "Tech Stack",
            style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        ChipsComponent(skills = currentFreelancer.skills)
    }
}

@Composable
fun TechSkill(modifier: Modifier = Modifier, color: Color, skill: String) {
    Row(
        modifier = modifier
            .padding(10.dp)
            .border(1.dp, color = color)
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = skill, color = color)
    }
}

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    heading: String,
    description: String,
    icon: ImageVector
) {
//    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
//        Icon(
//            imageVector = icon,
//            contentDescription = "Star",
//            modifier = Modifier.size(25.dp),
//
//            )
//        Text(text = heading, style = MaterialTheme.typography.titleLarge)
////        Spacer(modifier = Modifier.size(10.dp))
//        Column {
//            Text(text = description)
//        }
//    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = description,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = modifier.height(10.dp))
        Row(

        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Star",
                modifier = Modifier.size(25.dp),
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = heading, style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun UserBasicInfo(
    modifier: Modifier = Modifier,
    userName: String,
    userLocation: String,
    userDescription: String,
    userLinkedinId: String,
    userTwitterId: String,
    userGithubId: String
) {
    Column(
        horizontalAlignment = Alignment.Start, modifier = modifier
    ) {
        Text(
            text = userName,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        Text(
            text = userDescription,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "user location"
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = userLocation,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "Linkedin",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = userLinkedinId)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Linkedin",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = userTwitterId)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "gitHub",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = userGithubId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SkillConnectTheme { ProfileScreen() }
}