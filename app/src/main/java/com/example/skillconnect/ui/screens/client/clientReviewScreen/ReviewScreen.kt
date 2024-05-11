package com.example.skillconnect.ui.screens.client.clientReviewScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skillconnect.data.reviews
import com.example.skillconnect.ui.components.ClientReviewCard

@Composable
fun ReviewScreen() {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(reviews) { item ->
            ClientReviewCard(review = item)
        }
    }
}

@Composable
@Preview

fun ReviewScreenPreview() {
    ReviewScreen()
}