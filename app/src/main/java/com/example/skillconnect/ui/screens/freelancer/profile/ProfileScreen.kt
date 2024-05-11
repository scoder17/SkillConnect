package com.example.skillconnect.ui.screens.freelancer.profile

import android.annotation.SuppressLint
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillconnect.ui.theme.SkillConnectTheme
import com.example.skillconnect.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, onLogOut: () -> Unit = {}) {
    Scaffold(
        topBar = { ProfileScreenTopBar(onLogOut = onLogOut) }
    ) {
        ProfileContent(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 8.dp)
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
fun ProfileContent(modifier: Modifier = Modifier) {
    val bannerImage = painterResource(id = R.drawable.banner)
    val profileImage = painterResource(id = R.drawable.profile_image)
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = bannerImage,
                contentDescription = "banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.FillWidth
            )
            Box(Modifier.padding(top = 80.dp)) {
                Image(
                    painter = profileImage,
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
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(10.dp))
        Spacer(
            modifier = Modifier
                .height(14.dp)
                .fillMaxWidth()
                .background(color = Color.Gray)
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserRatingAndProjectsDone(modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.size(10.dp))
        UserAboutMe(
            modifier = Modifier.padding(8.dp),
            aboutUser = "Hi my name is Gautam shorewala . I am a coding entuahuiast who likes coding and learning new things. I am a software engineer at google"
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserTechStack(modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.size(10.dp))
        UserWorkHistory(modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun UserWorkHistory(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Work History", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        UserWorkProjectDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
            modifier = Modifier.fillMaxWidth()
        )
        UserWorkProjectDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
            modifier = Modifier.fillMaxWidth()
        )
        UserWorkProjectDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
            modifier = Modifier.fillMaxWidth()
        )
        UserWorkProjectDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
            modifier = Modifier.fillMaxWidth()
        )

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
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = projectName, style = MaterialTheme.typography.titleLarge)
            Text(text = projectDuration, style = MaterialTheme.typography.bodyMedium)
        }
        Column {
            Text(text = "$${projectPayment}", style = MaterialTheme.typography.titleLarge)
            Row {
                for (int in 1..rating.toInt())
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "Star",
                        modifier = Modifier.size(25.dp),
                    )
                for (int in (rating + 1).toInt()..5)
                    Icon(
                        imageVector = Icons.Outlined.StarBorder,
                        contentDescription = "Star",
                        modifier = Modifier.size(25.dp),
                    )
                Text(text = rating.toString())
            }

        }

    }
    Spacer(modifier = Modifier.size(10.dp))
    HorizontalDivider()
}

@Composable
fun UserRatingAndProjectsDone(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        IconWithText(heading = "4.5", description = "Rating", icon = Icons.Default.Star)
        Spacer(modifier = Modifier.size(10.dp))
        VerticalDivider(Modifier.height(60.dp))
        IconWithText(heading = "120", description = "Projects Done", icon = Icons.Outlined.FileOpen)
    }
}

@Composable
fun UserAboutMe(modifier: Modifier = Modifier, aboutUser: String) {
    Column(modifier = modifier) {
        Text(text = "About Me", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = aboutUser)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserTechStack(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Tech Stack", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        FlowRow(
            modifier = Modifier,
        ) {
            TechSkill(color = Color.Blue, skill = "Kotlin")
            TechSkill(color = Color.Red, skill = "Java")
            TechSkill(color = Color.Green, skill = "Python")
            TechSkill(color = Color.Yellow, skill = "C++")
            TechSkill(color = Color.Magenta, skill = "C")
            TechSkill(color = Color.Cyan, skill = "JavaScript")
            TechSkill(color = Color.Gray, skill = "Swift")
            TechSkill(color = Color.LightGray, skill = "Go")
            TechSkill(color = Color.DarkGray, skill = "Rust")
            TechSkill(color = Color.Red, skill = "Ruby")
            TechSkill(color = Color.White, skill = "PHP")
            TechSkill(color = Color.Red, skill = "R")
            TechSkill(color = Color.Blue, skill = "HTML")
            TechSkill(color = Color.Green, skill = "CSS")
            TechSkill(color = Color.Yellow, skill = "SQL")
        }
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
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = "Star",
            modifier = Modifier.size(25.dp),

            )
        Spacer(modifier = Modifier.size(10.dp))
        Column {
            Text(text = heading, style = MaterialTheme.typography.titleLarge)
            Text(text = description)
        }
    }
}

@Composable
fun UserBasicInfo(modifier: Modifier = Modifier) {
    val userName = "Gautam"
    val userLocation = "San Francisco, CA"
    val userDescription = "Software Engineer at Google"
    val userLinkedinId = "Gautam_Shorewala"
    val userTwitterId = "Gautam_Shorewala"
    Column(modifier = modifier) {
        Text(text = userName, style = MaterialTheme.typography.titleLarge)
        Text(text = userDescription)
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "user location"
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = userLocation)
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
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    SkillConnectTheme { ProfileScreen() }
}