package com.cesards.android.playground.facebook.yoga.adapter.ui

import android.content.Context
import com.cesards.android.playground.facebook.yoga.adapter.handlePadding
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToSpacing
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout
import com.cesards.android.playground.ui.widget.CarouselView

internal class AdaptToCarouselView(
    private val adaptToSpacing : AdaptToSpacing
) {

    operator fun invoke(context: Context, data: Data?, layout: Layout): CarouselView {
        // "count": 4,
        // "backgroundColor": "#aaaaaa",
        return CarouselView(context).apply {
            if (layout.padding != null) {
                handlePadding(adaptToSpacing(layout.padding))
            }
        }
    }
}