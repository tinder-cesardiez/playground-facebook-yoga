package com.cesards.android.playground.facebook.yoga.adapter.layout

import com.facebook.yoga.YogaPositionType

internal class AdaptToYogaPositionType {

    operator fun invoke(value: String): YogaPositionType {
        return when (value) {
            "static" -> YogaPositionType.STATIC
            "relative" -> YogaPositionType.RELATIVE
            "absolute" -> YogaPositionType.ABSOLUTE
            else -> error("Property not recognised")
        }
    }
}