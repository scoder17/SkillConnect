package com.example.skillconnect.model

data class FreeLancerData(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val profileImage: String? = "",
    val linkedIn: String = "",
    val github: String = "",
    val twitter: String = "",
    val skills: List<String> = emptyList(),
) {
    fun toMap() =
        mapOf(
            "id" to id,
            "name" to name,
            "email" to email,
            "password" to password,
            "profileImage" to profileImage,
            "linkedIn" to linkedIn,
            "github" to github,
            "twitter" to twitter,
            "skills" to skills,
        )

}
