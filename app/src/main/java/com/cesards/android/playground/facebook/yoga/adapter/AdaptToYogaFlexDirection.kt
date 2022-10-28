package com.cesards.android.playground.facebook.yoga.adapter

import com.facebook.yoga.YogaFlexDirection

class AdaptToYogaFlexDirection {

    operator fun invoke(value: String): YogaFlexDirection {
        return when (value) {
            "row" -> YogaFlexDirection.ROW
            "row-reverse" -> YogaFlexDirection.ROW_REVERSE
            "column" -> YogaFlexDirection.COLUMN
            "column-reverse" -> YogaFlexDirection.COLUMN_REVERSE
            else -> error("Property not recognised")
        }
    }
}