package com.zain.learningcampsession.data.repo

import com.zain.learningcampsession.data.model.PostModelDTO
import com.zain.learningcampsession.data.model.PostWrite

interface PostRepository {
    suspend fun getPosts(): List<PostModelDTO>
    suspend fun writePost(postWrite: PostWrite): PostWrite

}