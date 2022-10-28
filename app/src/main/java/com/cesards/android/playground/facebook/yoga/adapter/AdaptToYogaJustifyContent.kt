package com.cesards.android.playground.facebook.yoga.adapter

import com.facebook.yoga.YogaJustify

class AdaptToYogaJustifyContent {

    operator fun invoke(value: String) : YogaJustify {
        return when (value) {
            "start" -> YogaJustify.FLEX_START
            "end" -> YogaJustify.FLEX_END
            "center" -> YogaJustify.CENTER
            "space-between" -> YogaJustify.SPACE_BETWEEN
            "space-around" -> YogaJustify.SPACE_AROUND
            "space-evenly" -> YogaJustify.SPACE_EVENLY
            else -> error("Property not recognised")
        }
    }
}