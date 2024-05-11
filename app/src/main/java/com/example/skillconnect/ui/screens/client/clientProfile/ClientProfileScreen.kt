package com.example.skillconnect.ui.screens.client.clientProfile


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skillconnect.ui.theme.SkillConnectTheme
import com.example.skillconnect.R
import com.example.skillconnect.model.ClientPastProjectDetails
import com.example.skillconnect.ui.screens.client.clientProfile.ClientProfileScreenUiState
import com.example.skillconnect.ui.screens.client.clientProfile.ClientProfileScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientProfileScreen(modifier: Modifier = Modifier) {
    val clientProfileScreenViewModel: ClientProfileScreenViewModel = viewModel()
    val clientProfileScreenUiState by clientProfileScreenViewModel.clientProfile.collectAsState()

    Scaffold(
        topBar = { ProfileScreenTopBar() }
    ) {
        ProfileContent(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 8.dp),
            clientProfileScreenUiState = clientProfileScreenUiState,
            clientRecentProjects = clientProfileScreenViewModel.clientRecentProjects
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(title = { Text(text = "Profile") })
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    clientProfileScreenUiState: ClientProfileScreenUiState,
    clientRecentProjects: List<ClientPastProjectDetails> = listOf()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = clientProfileScreenUiState.bannerImage),
                contentDescription = "banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.FillWidth
            )
            Box(Modifier.padding(top = 80.dp)) {
                Image(
                    painter = painterResource(id = clientProfileScreenUiState.profileImage),
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
            clientProfileScreenUiState = clientProfileScreenUiState
        )
        Spacer(modifier = Modifier.size(10.dp))
        Spacer(
            modifier = Modifier
                .height(14.dp)
                .fillMaxWidth()
                .background(color = Color.Gray)
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserAboutMe(
            modifier = Modifier.padding(8.dp),
            aboutUser = clientProfileScreenUiState.aboutMe
        )
        Spacer(modifier = Modifier.size(10.dp))
        UserPastProjects(modifier = Modifier.padding(8.dp),clientPastProjects = clientRecentProjects)
    }
}


@Composable
fun UserPastProjects(modifier: Modifier = Modifier,clientPastProjects: List<ClientPastProjectDetails> = listOf()) {
    Column(modifier = modifier) {
        Text(text = "Recent Projects", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.size(10.dp))
        clientPastProjects.forEach {
            UserPastProjectDetails(
                timeAgo = it.timeAgo,
                projectName = it.projectName,
                projectDescription = it.projectDescription,
                image = it.projectImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

    }
}

@Composable
fun UserPastProjectDetails(
    timeAgo: String,
    modifier: Modifier = Modifier,
    projectName: String,
    projectDescription: String,
    image: Int
) {
    Card(onClick = { /*TODO*/ }, modifier = modifier) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                    Text(text = projectName, style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = "Posted ${timeAgo} ago",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "null",
                    modifier = Modifier.clickable { /*to-do*/ }
                )

            }
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = projectDescription, style = MaterialTheme.typography.bodyMedium)
        }
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

@Composable
fun UserBasicInfo(modifier: Modifier = Modifier,clientProfileScreenUiState: ClientProfileScreenUiState) {
    Column(modifier = modifier) {
        Text(text = clientProfileScreenUiState.name, style = MaterialTheme.typography.titleLarge)
        Text(text = clientProfileScreenUiState.description)
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "user location"
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = clientProfileScreenUiState.location)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "Linkedin",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = clientProfileScreenUiState.linkedIn)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Linkedin",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = clientProfileScreenUiState.twitter)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    SkillConnectTheme { ClientProfileScreen() }
}
