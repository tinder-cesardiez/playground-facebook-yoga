package com.cesards.android.playground.google.flexbox.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout
import com.cesards.android.playground.sdui.model.Node
import com.facebook.yoga.*
import com.facebook.yoga.android.YogaLayout
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.AlignSelf
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayout
import kotlin.random.Random

internal class AdaptToFlexboxNode {

    operator fun invoke(node: Node, context: Context, parent: View?): View? {
        val addedView = handleView(context, node, parent)

        return (addedView as? YogaLayout)?.apply {
            node.children?.forEach {
                invoke(it, context, addedView)
            }
        }
    }

    private fun handleView(context: Context, node: Node, parent: View?): View? {
        TODO()
    }
}