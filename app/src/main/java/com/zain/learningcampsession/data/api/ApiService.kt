package com.zain.learningcampsession.data.api

import com.zain.learningcampsession.data.model.PostModelDTO
import com.zain.learningcampsession.data.model.PostWrite
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<PostModelDTO>




    @POST("/posts")
    suspend fun  writePost(
        @Field("userId") id: Int,
        @Field("title") title: String,
        @Field("body") body: String, ): PostWrite


}

