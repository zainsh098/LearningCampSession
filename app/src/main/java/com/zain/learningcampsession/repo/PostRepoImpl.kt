package com.zain.learningcampsession.repo

import com.zain.learningcampsession.api.ApiService
import com.zain.learningcampsession.model.PostModelDTO
import com.zain.learningcampsession.model.toDomain
import javax.inject.Inject
import javax.inject.Singleton

// Created by Zain Shakoor
// on 6/13/2025


@Singleton
class PostRepoImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {
    override suspend fun getPosts(): List<PostModelDTO> {
        return apiService.getPosts().map {
            it.toDomain()
        }
    }
}