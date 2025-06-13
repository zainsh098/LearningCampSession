package com.zain.learningcampsession.data.repo

import com.zain.learningcampsession.data.model.PostModelDTO

interface PostRepository {
    suspend fun getPosts(): List<PostModelDTO>
}