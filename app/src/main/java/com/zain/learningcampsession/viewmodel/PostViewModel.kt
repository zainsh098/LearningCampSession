package com.zain.learningcampsession.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zain.learningcampsession.UiState
import com.zain.learningcampsession.repo.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Created by Zain Shakoor
// on 6/13/2025

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private val _uiEvents = MutableSharedFlow<UiEvents>()
    val uiEvents: SharedFlow<UiEvents> = _uiEvents


    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val post = repository.getPosts()
                _uiState.value = UiState.Success(post)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Failed: ${e.localizedMessage ?: "Unknown error"}")
                _uiEvents.emit(UiEvents.ShowToast("Something Went Wrong"))

            }
        }


    }

    sealed class UiEvents() {
        data class ShowToast(val mes: String) : UiEvents()
        data object NavigateToNextScreen : UiEvents()


    }


}