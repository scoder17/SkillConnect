package com.example.skillconnect.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Review (
    val profilePicture: ImageVector, // Replace with your data type for profile picture
    val reviewerName: String,
    val rating: Float,
    val description: String
)