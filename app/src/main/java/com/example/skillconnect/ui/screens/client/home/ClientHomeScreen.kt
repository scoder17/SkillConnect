package com.example.skillconnect.ui.screens.client.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.connectly.ui.components.ReviewCard
import com.example.connectly.ui.components.TitleValueCard
import com.example.connectly.ui.components.UserIncomeCard
import com.example.skillconnect.R
import com.example.skillconnect.data.Freelancer
import com.example.skillconnect.data.freelancers
import com.example.skillconnect.data.projects
import com.example.skillconnect.ui.components.FreelancerCard
import com.example.skillconnect.ui.components.NameAndSeeMoreLink
import com.example.skillconnect.ui.components.ProjectCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientHomeScreen(
//    modifier: Modifier = Modifier,
//    userAvatar: @Composable () -> Unit, // Can now be either Image or Icon
//    userName: String,
//    userPosition: String,
//    notificationSection: @Composable () -> Unit,
    navigateToNext: (String) -> Unit
) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
//                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UserIncomeCard(
                    user = "Aman",
                    incomeLastMonth = 5000.00,
                    display = "Expense",
                    dispMonth = false,
                    incomeIncrease = 1.06
                )
//            Spacer(modifier = Modifier.width(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    TitleValueCard(title = "Hiring level", value = "Top rated")
                    Spacer(modifier = Modifier.height(10.dp))
                    TitleValueCard(title = "Trust", value = "82%")
                }
            }

//

            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.height(10.dp))

//Ongoing Projects
            NameAndSeeMoreLink(
                name = "Ongoing Projects",
                seeMore = "",
                onClickSeeMore = {}
            )
//        Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                projects.forEach { project ->
                    ProjectCard(project = project)

                }

            }

            NameAndSeeMoreLink(
                name = "Trending Freelancers",
                seeMore = "See more",
                onClickSeeMore = {}
            )
            LazyRow(
                modifier = Modifier.padding(start = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(freelancers){item->
                    FreelancerCard(freelancer = item) {
                        
                    }
                    
                }
            }
        }
    }




@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserTopBarPreview() {
    ClientHomeScreen(
//        userAvatar = {
//            // Provide an image preview for the user avatar with a circular clip
//            Image(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(CircleShape), // Clip the image to circle
//                painter = painterResource(id = R.drawable.profile_image), // Placeholder for actual image
//                contentDescription = "User avatar"
//            )
//        },
//        userName = "John Doe",
//        userPosition = "Software Engineer",
        navigateToNext = {},
//        notificationSection = {
//            // Provide a preview for the notification section
//            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.Filled.Notifications,
//                    contentDescription = "Notifications"
//                )
//            }
//        }
    )
}