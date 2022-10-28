package com.cesards.android.playground.facebook.yoga.adapter.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.setPadding
import com.cesards.android.playground.facebook.yoga.adapter.toPixels
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout

class AdaptToTextView {

    private var myId = 10000

    operator fun invoke(context: Context, data: Data?, layout: Layout): AppCompatTextView {
        return AppCompatTextView(context).apply {
            id = myId
            myId++
            background = background(context, data)
            text = data!!.text!!.body
            if (layout.padding != null) {
                setPadding(layout.padding.toPixels(context).toInt())
            }
            if (data.text?.color != null) {
                setTextColor(Color.parseColor(data.text.color.solid))
            }
            if (data.text?.fontSize != null) {
                textSize = data.text.fontSize.toFloat()
            }
            // Temporal Hack: This should come specified from the Payload.
            gravity = Gravity.CENTER_VERTICAL

            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }


    private fun background(context: Context, data: Data?): Drawable? {
        return data?.border?.let {
            GradientDrawable().apply {
                cornerRadius = it.radius?.toPixels(context) ?: 0f
            }
        } ?: data?.color?.solid?.let {
            ColorDrawable(Color.parseColor(it))
        }
    }
}