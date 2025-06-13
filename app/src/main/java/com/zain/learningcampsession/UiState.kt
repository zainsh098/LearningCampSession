package com.zain.learningcampsession

import com.zain.learningcampsession.model.PostModelDTO

// Created by Zain Shakoor
// on 6/13/2025

sealed class UiState {
    data object Loading : UiState()
    data class Success(val post: List<PostModelDTO>) : UiState()
    data class Error(val msg: String) : UiState()
}