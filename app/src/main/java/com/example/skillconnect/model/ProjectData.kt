package com.example.skillconnect.model

import java.util.Date

data class ProjectData(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val deadline: String,
    val status: String,
    val applicants: List<String>?=null,
    val roles:String,
    val requiredSkills: List<String>,
    val budget: String,
    val aboutCompany: String,
    val clientId: String,
    val freelancerId: String?=null,
)
