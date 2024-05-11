package com.example.skillconnect.ui.screens.freelancer.profile

data class ProfileScreenUiState(
    val profileImage:Int,
    val profileBanner:Int,
    val name:String,
    val bio:String,
    val location:String,
    val linkedIn:String,
    val twitter:String,
    val github:String,
    val rating:Double,
    val projectsDone:Int,
    val aboutUser:String,
)