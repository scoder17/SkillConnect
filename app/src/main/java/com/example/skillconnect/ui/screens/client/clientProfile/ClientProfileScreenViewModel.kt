package com.example.skillconnect.ui.screens.client.clientProfile

import androidx.lifecycle.ViewModel
import com.example.skillconnect.R
import com.example.skillconnect.model.ClientPastProjectDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClientProfileScreenViewModel() : ViewModel() {
    private val _clientProfile = MutableStateFlow(ClientProfileScreenUiState())
    val clientProfile: StateFlow<ClientProfileScreenUiState> = _clientProfile.asStateFlow()
    val clientRecentProjects: List<ClientPastProjectDetails> = listOf(
        ClientPastProjectDetails(
            projectImage = R.drawable.profile_image,
            projectDescription = "This project comprises of creating a full stack app for the company with best coding practices.",
            projectName = "Title",
            timeAgo = "5hr"
        ), ClientPastProjectDetails(
            projectImage = R.drawable.profile_image,
            projectDescription = "This project comprises of creating a full stack app for the company with best coding practices.",
            projectName = "Title",
            timeAgo = "5hr"
        ), ClientPastProjectDetails(
            projectImage = R.drawable.profile_image,
            projectDescription = "This project comprises of creating a full stack app for the company with best coding practices.",
            projectName = "Title",
            timeAgo = "5hr"
        ), ClientPastProjectDetails(
            projectImage = R.drawable.profile_image,
            projectDescription = "This project comprises of creating a full stack app for the company with best coding practices.",
            projectName = "Title",
            timeAgo = "5hr"
        )
    )
//        fun details(
//        name: String,
//        location: String,
//        description: String,
//        image: Int,
//        linkedIn: String,
//        twitter: String,
//        aboutMe: String
//    ) {
//        _clientProfile.update { currentState ->
//            currentState.copy(
//                name = name,
//                location = location,
//                description = description,
//                profileImage = image,
//                linkedIn = linkedIn,
//                twitter = twitter,
//                aboutMe = aboutMe,
//
//                )
//        }
//    }
}