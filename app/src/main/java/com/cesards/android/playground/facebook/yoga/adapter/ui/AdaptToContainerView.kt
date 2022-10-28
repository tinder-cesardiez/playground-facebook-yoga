package com.cesards.android.playground.facebook.yoga.adapter.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import com.cesards.android.playground.facebook.yoga.adapter.toPixels
import com.cesards.android.playground.sdui.model.Data
import com.facebook.yoga.android.YogaLayout

class AdaptToContainerView {

    operator fun invoke(context: Context, data: Data?) : YogaLayout {
        return YogaLayout(context).apply {
            background = background(context, data)
            //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    private fun background(context: Context, data: Data?): Drawable? {
        return data?.border?.let {
            GradientDrawable().apply {
                cornerRadius = it.radius?.toPixels(context) ?: 0f
                color = ColorStateList.valueOf(Color.parseColor(data.color!!.solid))
            }
        } ?: data?.color?.solid?.let {
            ColorDrawable(Color.parseColor(it))
        }
    }
}