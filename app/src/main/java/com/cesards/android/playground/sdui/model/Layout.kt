package com.cesards.android.playground.sdui.model

import com.facebook.yoga.YogaNode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Layout(
    @SerialName("flex_direction")
    val flexDirection: String? = null,
    @SerialName("justify_content")
    val justifyContent: String? = null,
    val position: String? = null,
    val top: Float? = null,
    val right: Float? = null,
    val bottom: Float? = null,
    val left: Float? = null,
    val padding: Float? = null,
    @SerialName("flex_grow")
    val flexGrow: Float? = null,
    val count: Int? = null, // What's this???
    val width: Float? = null,
    val height: Float? = null,
    val margin: Float? = null,
    @SerialName("margin_horizontal")
    val marginHorizontal : Float? = null,
    @SerialName("align_items")
    val alignItems: String? = null,
    @SerialName("align_self")
    val alignSelf: String? = null,
)



