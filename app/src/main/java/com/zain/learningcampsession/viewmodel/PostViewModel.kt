package com.zain.learningcampsession.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zain.learningcampsession.data.model.PostWrite
import com.zain.learningcampsession.data.repo.PostRepository
import com.zain.learningcampsession.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Created by Zain Shakoor
// on 6/13/2025

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

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

    fun writePost(postWrite: PostWrite) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val writePostResult = repository.writePost(postWrite)
                _uiState.value = UiState.SuccessPost(writePostResult)
                _uiEvents.emit(UiEvents.ShowSuccessMessage("Your Post iS Posted "))
            } catch (e: Exception) {
                _uiEvents.emit(UiEvents.ShowSuccessMessage("Your Request is not Successfull"))

            }
        }


    }


    sealed class UiEvents{
        data class ShowToast(val mes: String) : UiEvents()
        data object NavigateToNextScreen : UiEvents()
        data class ShowSuccessMessage(val successMesg: String) : UiEvents()


    }


}