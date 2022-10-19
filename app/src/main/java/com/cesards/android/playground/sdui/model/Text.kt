package com.cesards.android.playground.sdui.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Text(
    @SerialName("body")
    val body: String? = null,
    @SerialName("font_size")
    val fontSize: Int? = null,
    @SerialName("color")
    val color : Color? = null,
    @SerialName("font_weight")
    val fontWeight: String? = null,
)