package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.view.View
import com.cesards.android.playground.facebook.yoga.adapter.layout.*
import com.cesards.android.playground.sdui.model.Layout
import com.cesards.android.playground.sdui.model.Spacing
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaNode


internal class SetToYogaNodeProperties(
    private val adaptToYogaFlexDirection: AdaptToYogaFlexDirection,
    private val adaptToYogaPositionType: AdaptToYogaPositionType,
    private val adaptToYogaJustifyContent: AdaptToYogaJustifyContent,
    private val adaptToYogaAlign: AdaptToYogaAlign,
    private val adaptToSpacing: AdaptToSpacing,
) {

    operator fun invoke(context: Context, yogaNode: YogaNode, layout: Layout, hack: Boolean = false) {
        layout.width?.run {
            yogaNode.setWidth(toPixels(context))
        }
        layout.height?.run {
            yogaNode.setHeight(toPixels(context))
        }
        layout.flexGrow?.run {
            yogaNode.flexGrow = this
        }
        layout.justifyContent?.run {
            yogaNode.justifyContent = adaptToYogaJustifyContent(this)
        }
        layout.position?.run {
            yogaNode.positionType = adaptToYogaPositionType(this)
        }
        layout.flexDirection?.run {
            yogaNode.flexDirection = adaptToYogaFlexDirection(this)
        }
        layout.top?.run {
            yogaNode.setPosition(YogaEdge.TOP, toPixels(context))
        }
        layout.left?.run {
            yogaNode.setPosition(YogaEdge.LEFT, toPixels(context))
        }
        layout.right?.run {
            yogaNode.setPosition(YogaEdge.RIGHT, toPixels(context))
        }
        layout.bottom?.run {
            yogaNode.setPosition(YogaEdge.BOTTOM, toPixels(context))
        }
        layout.margin?.run {
            yogaNode.setMargin(YogaEdge.ALL, toPixels(context))
        }
        // Padding applied to a node on a View doesn't work, so we need to specify the padding directly to the View.
        layout.padding?.run {
            adaptToSpacing(this).forEach {
                when (it) {
                    is Spacing.All -> yogaNode.setPadding(YogaEdge.ALL, it.value.toPixels(context))
                    is Spacing.Bottom -> yogaNode.setPadding(YogaEdge.BOTTOM, it.value.toPixels(context))
                    is Spacing.End -> yogaNode.setPadding(YogaEdge.END, it.value.toPixels(context))
                    is Spacing.Horizontal -> yogaNode.setPadding(YogaEdge.HORIZONTAL, it.value.toPixels(context))
                    is Spacing.Start -> yogaNode.setPadding(YogaEdge.START, it.value.toPixels(context))
                    is Spacing.Top -> yogaNode.setPadding(YogaEdge.TOP, it.value.toPixels(context))
                    is Spacing.Vertical -> yogaNode.setPadding(YogaEdge.VERTICAL, it.value.toPixels(context))
                }
            }
        }
        layout.alignItems?.run {
            yogaNode.alignItems = adaptToYogaAlign(this)
        }
        layout.alignSelf?.run {
            yogaNode.alignSelf = adaptToYogaAlign(this)
        }
    }
}

fun View.handlePadding(spacings: List<Spacing>) {
    spacings.forEach {
        val pixels = it.value.toPixels(context).toInt()
        var start = 0
        var top = 0
        var end = 0
        var bottom = 0
        when (it) {
            is Spacing.All -> {
                start += pixels
                top += pixels
                end += pixels
                bottom += pixels
            }
            is Spacing.Bottom -> bottom += pixels
            is Spacing.End -> end += pixels
            is Spacing.Horizontal -> {
                start += pixels
                end += pixels
            }
            is Spacing.Start -> start += pixels
            is Spacing.Top -> top += pixels
            is Spacing.Vertical -> {
                top += pixels
                bottom += pixels
            }
        }

        setPadding(start, top, end, bottom)
    }
}