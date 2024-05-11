package com.example.skillconnect.data

data class Freelancer(
    val id: String, // Unique identifier for the freelancer
    val name: String,
//    val profilePictureUrl: String?, // URL for the freelancer's profile picture (optional)
    val skills: List<String>, // List of skills the freelancer possesses
    val rating: Float, // Average rating from client reviews (optional)
    val hourlyRate: Double?, // Freelancer's hourly rate (optional)
    val bio: String?, // Short bio describing the freelancer's experience (optional)
)