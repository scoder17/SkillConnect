package com.example.skillconnect.model

import java.util.Date

data class ProjectData(
    val id: String,
    val title: String,
    val description: String,
    val date: Date,
    val deadline: Date?=null,
    val status: String,
    val applicants: List<String>,
    val roles: List<String>,
    val requiredSkills: List<String>,
    val budget: Int,
    val aboutCompany: String,
    val clientId: String,
    val freelancerId: String?=null,
)
