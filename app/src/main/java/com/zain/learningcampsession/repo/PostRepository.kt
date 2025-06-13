package com.zain.learningcampsession.repo

import com.zain.learningcampsession.model.PostModelDTO

interface PostRepository {
    suspend fun getPosts(): List<PostModelDTO>
}