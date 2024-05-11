package com.example.skillconnect.ui.screens.freelancer.formScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.skillconnect.ui.screens.freelancer.formScreen.FormScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.reflect.KProperty

@HiltViewModel
class FormScreenViewModel @Inject constructor() : ViewModel() {
    private var _skills = mutableStateListOf("")

    val skills: List<String>
        get() = _skills

    // Add a getValue() method for the mutableStateListOf() property delegate
    operator fun getValue(thisObj: Any?, property: KProperty<*>): List<String> {
        return _skills
    }

    private val _uiState = MutableStateFlow(FormScreenUiState())
    val uiState: StateFlow<FormScreenUiState> = _uiState.asStateFlow()
    fun addSkill() {
        _skills.add("")
    }
    fun removeSkill(index: Int) {
        _skills.removeAt(index)
    }

    fun updateSkill(index: Int, value: String) {
        _skills[index] = value
    }

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

    fun updateGithub(updatedGithub: String) {
        _uiState.update { currentState ->
            currentState.copy(
                github = updatedGithub
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

}