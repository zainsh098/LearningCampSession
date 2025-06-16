package com.zain.learningcampsession.data.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable


@Serializable
@JsonClass(generateAdapter = true)
data class PostModelDTO(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String?,
    val body: String?
)


fun PostModelDTO.toDomain(): PostModelDTO {
    return PostModelDTO(
        userId = userId,
        id = this.id,
        title = this.title.orEmpty(),
        body = this.body.orEmpty()

    )
}

@Serializable
@JsonClass(generateAdapter = true)
data class PostWrite(
    val userId: Int,
    val title: String,
    val body: String
)

