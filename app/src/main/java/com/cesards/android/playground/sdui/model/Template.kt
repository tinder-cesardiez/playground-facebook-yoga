package com.cesards.android.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
class Template(
    val id: String,
    val value: Node,
)