package com.example.skillconnect.ui.screens.client.applicantsScreen

import androidx.lifecycle.ViewModel
import com.example.skillconnect.R
import com.example.skillconnect.model.ApplicantsListItemData

class ApplicantsScreenViewModel : ViewModel() {
    val applicants: List<ApplicantsListItemData> = listOf(
        ApplicantsListItemData(
            profileImage = R.drawable.profile_image,
            name = "Gautam",
            location = "Bangalore,India",
            skills = "proficient in everything"
        ),
        ApplicantsListItemData(
            profileImage = R.drawable.profile_image,
            name = "Gautam",
            location = "Bangalore,India",
            skills = "proficient in everything"
        ),
        ApplicantsListItemData(
            profileImage = R.drawable.profile_image,
            name = "Gautam",
            location = "Bangalore,India",
            skills = "proficient in everything"
        ),
        ApplicantsListItemData(
            profileImage = R.drawable.profile_image,
            name = "Gautam",
            location = "Bangalore,India",
            skills = "proficient in everything"
        ),
        ApplicantsListItemData(
            profileImage = R.drawable.profile_image,
            name = "Gautam",
            location = "Bangalore,India",
            skills = "proficient in everything"
        )
    )
}