package com.example.skillconnect.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.R
import com.example.skillconnect.data.Freelancer

@Composable
fun FreelancerCard(
    freelancer: Freelancer,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(100)),
                    imageVector = Icons.Default.Person,
                    contentDescription = "profile_pic"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = freelancer.name,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold

                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = freelancer.skills.joinToString(", "),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                style = MaterialTheme.typography.bodyMedium
            )
            // Add rating component here (optional)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FreelancerCardPreview() {
    FreelancerCard(
        freelancer = Freelancer(
            id = "1",
            name = "John Doe",
            skills = listOf("Android Development", "Kotlin", "Firebase"),
            rating = 4.5f,
            bio = "Android developer with 5 years of experience in the field.",
            hourlyRate = 30.0,


            ),
        onClick = {} // Empty lambda for preview
    )
}