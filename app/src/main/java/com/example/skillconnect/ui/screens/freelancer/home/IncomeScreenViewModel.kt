package com.example.skillconnect.ui.screens.freelancer.home

import androidx.lifecycle.ViewModel
import com.example.skillconnect.model.FreelancerIncomeDetails

class IncomeScreenViewModel : ViewModel() {
    val freelancerIncomeHistory: List<FreelancerIncomeDetails> = listOf(
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