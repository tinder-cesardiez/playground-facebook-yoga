package com.cesards.android.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val color: Color? = null,
    val text: Text? = null,
    val border: Border? = null,
    val media: Media? = null,
)