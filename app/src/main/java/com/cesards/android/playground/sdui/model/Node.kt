package com.cesards.android.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
data class Node(
    val type: String,
    val layout: Layout,
    val children: List<Node>? = null,
    val data : Data? = null,
)