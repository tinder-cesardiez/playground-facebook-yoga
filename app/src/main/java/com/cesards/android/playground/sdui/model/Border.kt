package com.cesards.android.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
data class Border(
    val radius: Int? = null,
    val width: Float? = null,
    val color: Color? = null,
)