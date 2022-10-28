package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaAlign
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaFlexDirection
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaJustifyContent
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaPositionType
import com.cesards.android.playground.sdui.model.Layout
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaNode


internal class SetToYogaNodeProperties(
    private val adaptToYogaFlexDirection: AdaptToYogaFlexDirection,
    private val adaptToYogaPositionType: AdaptToYogaPositionType,
    private val adaptToYogaJustifyContent: AdaptToYogaJustifyContent,
    private val adaptToYogaAlign: AdaptToYogaAlign,
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
        // Padding applied to a node on a view like TextView won't work, so we need to specify the padding directly to the View.
        layout.padding?.run {
            yogaNode.setPadding(YogaEdge.ALL, toPixels(context))
        }
        layout.alignItems?.run {
            yogaNode.alignItems = adaptToYogaAlign(this)
        }
        layout.alignSelf?.run {
            yogaNode.alignSelf = adaptToYogaAlign(this)
        }
    }
}