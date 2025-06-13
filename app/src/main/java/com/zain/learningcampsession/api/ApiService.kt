package com.zain.learningcampsession.api

import com.zain.learningcampsession.model.PostModelDTO
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<PostModelDTO>
}