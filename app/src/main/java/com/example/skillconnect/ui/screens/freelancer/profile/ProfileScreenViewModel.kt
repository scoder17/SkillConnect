package com.example.skillconnect.ui.screens.freelancer.profile

import androidx.lifecycle.ViewModel
import com.example.skillconnect.R
import com.example.skillconnect.model.FreelancerIncomeDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileScreenViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(
        ProfileScreenUiState(
            profileImage = R.drawable.profile_image,
            profileBanner = R.drawable.banner,
            name = "Gautam",
            bio = "software developer at google",
            location = "San Francisco,CA",
            linkedIn = "Gautam_Shorewala",
            twitter = "Gautam_Shorewala",
            github = "Gautam_Shorewala",
            rating = 4.5,
            projectsDone = 120,
            aboutUser = "Hi my name is Gautam shorewala . I am a coding entuahuiast who likes coding and learning new things. I am a software engineer at google"
        )
    )
    val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()
    val freelancerWorkHistory: List<FreelancerIncomeDetails> = listOf(
        FreelancerIncomeDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        FreelancerIncomeDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        FreelancerIncomeDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        FreelancerIncomeDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        )
    )
}