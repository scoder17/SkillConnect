package com.example.skillconnect.ui.screens.client.clientProfile

import com.example.skillconnect.R

data class ClientProfileScreenUiState(
    val name:String = "Gautam",
    val location:String = "Bangalore, Kolkata",
    val description:String="HR at Google",
    val linkedIn:String="Gautam_Shorewala",
    val twitter:String="Gautam_Shorewala",
    val aboutMe:String="Hi my name is Gautam Shorewala . I am a HR at google and am always on the lookout of talented people to hire.",
    val profileImage:Int= R.drawable.profile_image,
    val bannerImage:Int=R.drawable.banner
)
