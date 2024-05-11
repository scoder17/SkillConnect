package com.example.skillconnect.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClientSearchViewModel: ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun clearSearchText() {
        _searchText.value = ""
    }
}