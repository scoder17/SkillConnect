package com.example.skillconnect.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.R
import com.example.skillconnect.data.Project

@Composable
fun ProjectCard(
    project: Project
) {
    Card(
        modifier = Modifier
            .padding(16.dp),

        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).width(150.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Profile picture of client (placeholder)
                Image(
//                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clip(RoundedCornerShape(100))
                )

                // Client name
                Text(
                    text = project.clientName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Project name
            Text(

                text = project.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Project description
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Deadline
            Text(
                text = "Deadline: ${project.deadline}",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProjectCardPreview() {
    ProjectCard(
        project = Project(
            clientName = "John Doe",
            name = "My Project",
            description = "This is my project description.",
            deadline = "2023-06-30"
        )
    )
}