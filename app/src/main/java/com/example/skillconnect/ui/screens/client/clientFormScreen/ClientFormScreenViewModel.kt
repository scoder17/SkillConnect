package com.example.skillconnect.ui.screens.client.clientFormScreen


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ClientFormScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ClientFormScreenUiState())
    val uiState: StateFlow<ClientFormScreenUiState> = _uiState.asStateFlow()
    fun updateName(updatedName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                name = updatedName
            )
        }
    }

    fun updateEmail(updatedEmail: String) {
        _uiState.update { currentState ->
            currentState.copy(
                email = updatedEmail
            )
        }
    }

    fun updatePassword(updatedPassword: String) {
        _uiState.update { currentState ->
            currentState.copy(
                password = updatedPassword
            )
        }
    }

    fun updateConfirmPassword(updatedConfirmPassword: String) {
        _uiState.update { currentState ->
            currentState.copy(
                confirmPassword = updatedConfirmPassword
            )
        }
    }

    fun updateLinkedIn(updatedLinkedIn: String) {
        _uiState.update { currentState ->
            currentState.copy(
                linkedIn = updatedLinkedIn
            )
        }
    }

    fun updateTwitter(updatedTwitter: String) {
        _uiState.update { currentState ->
            currentState.copy(
                twitter = updatedTwitter
            )
        }
    }

    fun updateAboutMe(updatedAboutMe: String) {
        _uiState.update { currentState ->
            currentState.copy(
                userAboutMe = updatedAboutMe
            )
        }
    }
}