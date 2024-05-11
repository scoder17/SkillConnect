package com.example.skillconnect.model

data class ClientData(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val profileImage: String? = "",
    val linkedIn: String = "",
    val twitter: String = "",
) {
    fun toMap() =
        mapOf(
            "id" to id,
            "name" to name,
            "email" to email,
            "password" to password,
            "profileImage" to profileImage,
            "linkedIn" to linkedIn,
            "twitter" to twitter,
        )

}
