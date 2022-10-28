package com.cesards.android.playground.facebook.yoga.adapter

import com.facebook.yoga.YogaAlign

class AdaptToYogaAlign {

    operator fun invoke(value: String): YogaAlign {
        return when (value) {
            "auto" -> YogaAlign.AUTO
            "flex-start" -> YogaAlign.FLEX_START
            "flex-end" -> YogaAlign.FLEX_END
            "center" -> YogaAlign.CENTER
            "stretch" -> YogaAlign.STRETCH
            "baseline" -> YogaAlign.BASELINE
            "space-between" -> YogaAlign.SPACE_BETWEEN
            "space-around" -> YogaAlign.SPACE_AROUND
            else -> error("Property not recognised")
        }
    }
}