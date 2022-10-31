package com.cesards.android.playground.sdui.model

import kotlinx.serialization.Serializable

@Serializable
data class DataSpacing(
    val all: Int? = null,
    val horizontal: Int? = null,
    val vertical: Int? = null,
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null,
)

sealed class Spacing {
    abstract val value: Int

    data class All(override val value: Int) : Spacing()

    data class Horizontal(override val value: Int) : Spacing()

    data class Vertical(override val value: Int) : Spacing()

    data class Start(override val value: Int) : Spacing()

    data class Top(override val value: Int) : Spacing()

    data class End(override val value: Int) : Spacing()

    data class Bottom(override val value: Int) : Spacing()
}