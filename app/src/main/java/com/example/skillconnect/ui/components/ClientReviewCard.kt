package com.example.skillconnect.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.data.Review
import com.example.skillconnect.data.reviews

@Composable
fun ClientReviewCard(review: Review) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Profile picture
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        imageVector = review.profilePicture, // Replace with your profile picture logic
                        contentDescription = "Reviewer profile picture",

                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = review.reviewerName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = review.rating.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold ,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating",
                        tint = Color(0xFFFFA500)
                    )
                }
//
            }

            // Review description
            Text(
                text = review.description,
//                maxLines = 2, // Show maximum 3 lines
//                overflow = TextOverflow.Ellipsis, // Truncate if exceeds
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            // Read more button (optional)
            if (review.description.lines().count() > 3) {
                Button(
                    onClick = { /* Expand review description */ },
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text("Read More")
                }
            }
        }
    }
}

@Composable
@Preview
fun ClientReviewCardPreview() {
    ClientReviewCard(review = reviews[0])
}

