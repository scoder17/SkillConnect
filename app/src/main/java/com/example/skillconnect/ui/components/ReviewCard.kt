package com.example.connectly.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skillconnect.R

@Composable
fun ReviewCard(
    modifier: Modifier = Modifier,
    name: String,
    rating: Float,
    numReviews: Int
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
//                .fillMaxWidth(0.40f)
//                .height(130.dp)
                .width(140.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
                Icon(
                    imageVector = Icons.Rounded.MoreHoriz,
                    tint = Color.LightGray,
                    contentDescription = "More options"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Rounded.Star,
                    tint = Color.Yellow,
                    contentDescription = "Rating"
                )
                Text(
//                    text = rating.toString()+" /5",
//                    style = MaterialTheme.typography.bodySmall
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = Color.LightGray)
                        ) {
                            append(rating.toString())
                        }
                        withStyle(style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Gray)
                        ){
                            append(" /5.0")
                        }


                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                modifier = modifier
                    .clip(RoundedCornerShape(100))
                    .height(20.dp),
                painter = painterResource(id = R.drawable.profile_image),

                contentDescription = "Client reviews"
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$numReviews positive reviews",
                style = MaterialTheme.typography.labelSmall,
                color = Color.LightGray,
                fontWeight = FontWeight.SemiBold

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReviewCardPreview() {
    ReviewCard(
        name = "Impressions",
        rating = 4.5f,
        numReviews = 40
    )
}