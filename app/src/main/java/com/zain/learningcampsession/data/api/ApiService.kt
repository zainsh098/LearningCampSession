package com.zain.learningcampsession.data.api

import com.zain.learningcampsession.data.model.PostModelDTO
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<PostModelDTO>
}