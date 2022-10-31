package com.cesards.android.playground.facebook.yoga.adapter.layout

import com.cesards.android.playground.sdui.model.DataSpacing
import com.cesards.android.playground.sdui.model.Spacing

internal class AdaptToSpacing {

    operator fun invoke(dataSpacing: DataSpacing): List<Spacing> {
        return mutableListOf<Spacing>().apply {
            dataSpacing.all?.run {
                add(Spacing.All(this))
            }
            dataSpacing.start?.run {
                add(Spacing.Start(this))
            }
            dataSpacing.top?.run {
                add(Spacing.Top(this))
            }
            dataSpacing.end?.run {
                add(Spacing.End(this))
            }
            dataSpacing.bottom?.run {
                add(Spacing.Bottom(this))
            }
            dataSpacing.vertical?.run {
                add(Spacing.Vertical(this))
            }
            dataSpacing.horizontal?.run {
                add(Spacing.Horizontal(this))
            }
        }
    }
}