package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.util.DisplayMetrics

fun Float.toPixels(context: Context): Float {
    return this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun Int.toPixels(context: Context): Float {
    return this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}