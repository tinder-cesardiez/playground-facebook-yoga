package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.view.View
import com.cesards.android.playground.sdui.model.Template

internal class AdaptToYogaLayout(
    private val adaptToNode: AdaptToNode,
) {

    operator fun invoke(context: Context, template: Template): View {
        return requireNotNull(adaptToNode(template.value, context, null))
    }
}