package com.example.skillconnect.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameAndSeeMoreLink(
    name: String,
    seeMore: String,
    onClickSeeMore: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        TextButton(onClick = onClickSeeMore) {
            Text(
                text = seeMore
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameAndSeeMoreLinkPreview() {
    NameAndSeeMoreLink(
        name = "John Doe",
        seeMore = "See More",
        onClickSeeMore = {} // Empty lambda function for preview
    )
}