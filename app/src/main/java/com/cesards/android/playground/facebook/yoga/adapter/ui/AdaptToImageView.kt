package com.cesards.android.playground.facebook.yoga.adapter.ui

import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.cesards.android.playground.R
import com.cesards.android.playground.facebook.yoga.adapter.handlePadding
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToSpacing
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout

internal class AdaptToImageView(
    private val adaptToSpacing : AdaptToSpacing
) {

    operator fun invoke(context: Context, data: Data?, layout: Layout): AppCompatImageView {
        return AppCompatImageView(context).apply {

            if (layout.padding != null) {
                handlePadding(adaptToSpacing(layout.padding))
            }
            if (data?.media?.url != null) {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.tinder_gold_logo))
            }
            //background = ColorDrawable(Color.parseColor("#FACB34"))
            layoutParams = ViewGroup.LayoutParams(layout.width!!.toInt(), layout.height!!.toInt())
        }
    }
}