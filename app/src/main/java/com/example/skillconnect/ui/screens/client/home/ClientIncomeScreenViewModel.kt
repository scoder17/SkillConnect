package com.example.skillconnect.ui.screens.client.home

import androidx.lifecycle.ViewModel
import com.example.skillconnect.model.ClientIncomeDetails
import com.example.skillconnect.model.FreelancerIncomeDetails

class ClientIncomeScreenViewModel : ViewModel() {
    val clientIncomeHistory: List<ClientIncomeDetails> = listOf(
        ClientIncomeDetails(
            rating = 4.0,
            projectName = "Project 1",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        ClientIncomeDetails(
            rating = 4.0,
            projectName = "Project 2",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        ClientIncomeDetails(
            rating = 4.0,
            projectName = "Project 3",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        ),
        ClientIncomeDetails(
            rating = 4.0,
            projectName = "Project 4",
            projectDuration = "Dec 28,2023 - Feb 28,2024",
            projectPayment = "1000",
        )
    )
}