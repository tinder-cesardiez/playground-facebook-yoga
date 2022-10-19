package com.cesards.android.playground.sdui.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Media(
    val url: String,
    @SerialName("mime_type")
    val mimeType: String,
)