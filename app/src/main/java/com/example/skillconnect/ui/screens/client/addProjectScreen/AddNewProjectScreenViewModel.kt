package com.example.skillconnect.ui.screens.client.addProjectScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddNewProjectScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddNewProjectScreenUIState())
    val uiState: StateFlow<AddNewProjectScreenUIState> = _uiState.asStateFlow()
    fun updateTitle(name: String) {
        _uiState.update { currentState -> currentState.copy(title = name) }
    }

    fun updateDescription(description: String) {
        _uiState.update { currentState -> currentState.copy(description = description) }
    }

    fun updateBudget(budget: String) {
        _uiState.update { currentState -> currentState.copy(budget = budget) }
    }
    fun updateDeadline(deadline: String) {
        _uiState.update { currentState -> currentState.copy(deadline = deadline) }
    }
}
