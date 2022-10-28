package com.cesards.android.playground.facebook.yoga.adapter.ui

import android.content.Context
import androidx.core.view.setPadding
import com.cesards.android.playground.facebook.yoga.adapter.toPixels
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout
import com.cesards.android.playground.ui.widget.CarouselView

class AdaptToCarouselView {

    operator fun invoke(context: Context, data: Data?, layout: Layout): CarouselView {
        // "count": 4,
        // "backgroundColor": "#aaaaaa",
        return CarouselView(context).apply {
            if (layout.padding != null) {
                setPadding(layout.padding.toPixels(context).toInt())
            }
        }
    }
}