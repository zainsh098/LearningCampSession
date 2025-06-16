package com.zain.learningcampsession.data.repo

import com.zain.learningcampsession.data.api.ApiService
import com.zain.learningcampsession.data.model.PostModelDTO
import com.zain.learningcampsession.data.model.PostWrite
import com.zain.learningcampsession.data.model.toDomain
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

    override suspend fun writePost(post: PostWrite): PostWrite {
        return apiService.writePost(post.userId, post.title, post.body)
    }


}