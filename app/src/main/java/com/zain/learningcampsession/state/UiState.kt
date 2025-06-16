package com.zain.learningcampsession.state

import com.zain.learningcampsession.data.model.PostModelDTO
import com.zain.learningcampsession.data.model.PostWrite

// Created by Zain Shakoor
// on 6/13/2025

sealed class UiState {
    data object Loading : UiState()
    data class Success(val post: List<PostModelDTO>) : UiState()
    data class SuccessPost(val post: PostWrite) : UiState()
    data class Error(val msg: String) : UiState()

}