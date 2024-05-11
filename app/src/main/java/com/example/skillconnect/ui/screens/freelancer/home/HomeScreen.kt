package com.example.skillconnect.ui.screens.freelancer.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.skillconnect.ui.components.NameAndSeeMoreLink
import com.example.skillconnect.ui.components.ProjectCard
import com.example.skillconnect.data.projects


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userAvatar: @Composable () -> Unit, // Can now be either Image or Icon
    userName: String,
    userPosition: String,
    notificationSection: @Composable () -> Unit,
    navigateToNext:(String)->Unit
) {

//    TopAppBar(
//        modifier = modifier,
//        title = {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Surface(
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clip(CircleShape), // Make the avatar area circular
//                    shape = MaterialTheme.shapes.small, // Optional: Set a shape for Surface
//                ) {
//                    userAvatar()
//                }
//                Spacer(modifier = Modifier.width(8.dp)) // Add some spacing between avatar and text
//                Column {
//                    Text(text = userName)
//                    Text(text = userPosition, style = MaterialTheme.typography.bodySmall)
//                }
//            }
//        },
//        navigationIcon = {
//            // You can add a navigation icon here if needed
//        },
//        actions = {
//            notificationSection()
//        }
//    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

                UserIncomeCard(
                    modifier = Modifier.clickable{navigateToNext("incomeScreen")},
                    user = "Aman",
                    incomeLastMonth = 5000.00,
                    display = "Earnings",
                    dispMonth = true,
                    incomeIncrease = 1.06,
                    onClick = {navigateToNext("incomeScreen")}
                )


//            Spacer(modifier = Modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                    TitleValueCard(title = "Freelancer level", value = "Top rated")

//                Spacer(modifier = Modifier.weight(1f))

                    TitleValueCard(title = "Online Delivery", value = "82%")

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        NameAndSeeMoreLink(
            name = "Reviews",
            seeMore = "See More",
            onClickSeeMore = {})

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            ReviewCard(
                name = "Aman",
                rating = 4.9f,
                numReviews = 40
            )
            Spacer(modifier = Modifier.weight(1f))
            ReviewCard(
                name = "Aman",
                rating = 4.9f,
                numReviews = 40
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(10.dp))


        NameAndSeeMoreLink(
            name = "Projects",
            seeMore = "See More",
            onClickSeeMore = {navigateToNext("projectScreen")}
        )
//        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            projects.forEach{project ->
                ProjectCard(project = project)

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun UserTopBarPreview() {
    HomeScreen(
        userAvatar = {
            // Provide an image preview for the user avatar with a circular clip
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape), // Clip the image to circle
                painter = painterResource(id = R.drawable.profile_image), // Placeholder for actual image
                contentDescription = "User avatar"
            )
        },
        userName = "John Doe",
        userPosition = "Software Engineer",
        navigateToNext =  {},
        notificationSection = {
            // Provide a preview for the notification section
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications"
                )
            }
        }
    )
}

