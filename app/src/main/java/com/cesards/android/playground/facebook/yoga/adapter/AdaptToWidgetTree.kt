package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.view.View
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToCarouselView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToContainerView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToImageView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToTextView
import com.cesards.android.playground.sdui.model.Node
import com.facebook.yoga.android.YogaLayout

internal class AdaptToWidgetTree(
    private val setToYogaNodeProperties: SetToYogaNodeProperties,
    private val adaptToTextView : AdaptToTextView,
    private val adaptToContainerView: AdaptToContainerView,
    private val adaptToCarouselView: AdaptToCarouselView,
    private val adaptToImageView : AdaptToImageView,
) {

    operator fun invoke(node: Node, context: Context, parent: View?): View? {
        val addedView = handleView(context, node, parent)

        return (addedView as? YogaLayout)?.apply {
            node.children?.forEach {
                invoke(it, context, addedView)
            }
        }
    }

    private fun handleView(context: Context, node: Node, parent: View?): View? {
        return when (node.type.component()) {
            Component.CAROUSEL -> {
                (parent as? YogaLayout)?.run {
                    val view = adaptToCarouselView(context, node.data!!, node.layout)
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout)
                    view
                }
            }
            Component.TEXT -> {
                (parent as? YogaLayout)?.run {
                    val view = adaptToTextView(context, node.data!!, node.layout)
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout)
                    view
                }
            }
            Component.IMAGE -> {
                (parent as? YogaLayout)?.run {
                    val view = adaptToImageView(context, node.data!!, node.layout)
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout, true)
                    view
                }
            }
            Component.BOX -> {
                val view = adaptToContainerView(context, node.data).apply {
                    setToYogaNodeProperties(context, yogaNode, node.layout)
                }
                (parent as? YogaLayout)?.run {
                    addView(view)
                }
                view
            }
            null -> null
        }
    }

    private fun String.component(): Component? {
        return when {
            equals("Box", ignoreCase = true) -> Component.BOX
            equals("Image", ignoreCase = true) -> Component.IMAGE
            equals("Text", ignoreCase = true) -> Component.TEXT
            equals("CarouselBars", ignoreCase = true) -> Component.CAROUSEL
            else -> null
        }
    }

    private enum class Component {
        BOX,
        TEXT,
        IMAGE,
        CAROUSEL,
    }
}
