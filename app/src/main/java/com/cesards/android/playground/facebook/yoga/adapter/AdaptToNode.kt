package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Layout
import com.cesards.android.playground.sdui.model.Node
import com.facebook.yoga.*
import com.facebook.yoga.android.YogaLayout
import kotlin.random.Random

internal class AdaptToNode {

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
            Component.CAROUSEL,
            Component.TEXT,
            Component.IMAGE -> {
                (parent as? YogaLayout)?.run {
                    id = Random.nextInt()
                    val view = View(context).apply {
                        background = background(node.data)
                        //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
                    addView(view)
                    getYogaNodeForView(view).setLayoutParameters(node.layout)
                    view
                }
            }
            Component.BOX -> {
                val view = YogaLayout(context).apply {
                    id = Random.nextInt()
                    background = background(node.data)
                    //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    yogaNode.setLayoutParameters(node.layout)
                }

                (parent as? YogaLayout)?.run {
                    addView(view)
                }

                view
            }
            null -> null
        }
    }

    private fun background(data: Data?): Drawable? {
        return data?.color?.solid?.let {
            ColorDrawable(Color.parseColor(it))
        }
    }

    private fun YogaNode.setLayoutParameters(layout: Layout) {
        layout.width?.run {
            setWidth(this)
        }
        layout.height?.run {
            setHeight(this)
        }
        layout.flexGrow?.run {
            flexGrow = this
        }
        layout.justifyContent?.run {
            justifyContent = justifyContent()
        }
        layout.position?.run {
            positionType = positionType()
        }
        layout.flexDirection?.run {
            flexDirection = flexDirection()
        }
        layout.top?.run {
            setPosition(YogaEdge.TOP, this)
        }
        layout.left?.run {
            setPosition(YogaEdge.LEFT, this)
        }
        layout.right?.run {
            setPosition(YogaEdge.RIGHT, this)
        }
        layout.bottom?.run {
            setPosition(YogaEdge.BOTTOM, this)
        }
        layout.margin?.run {
            setMargin(YogaEdge.ALL, this)
        }
        layout.padding?.run {
            setPadding(YogaEdge.ALL, this)
        }
        layout.alignItems?.run {
            alignItems = align()
        }
        layout.alignSelf?.run {
            alignSelf = align()
        }
    }

    private fun String.align(): YogaAlign {
        return when (this) {
            "auto" -> YogaAlign.AUTO
            "flex-start" -> YogaAlign.FLEX_START
            "flex-end" -> YogaAlign.FLEX_END
            "center" -> YogaAlign.CENTER
            "stretch" -> YogaAlign.STRETCH
            "baseline" -> YogaAlign.BASELINE
            "space-between" -> YogaAlign.SPACE_BETWEEN
            "space-around" -> YogaAlign.SPACE_AROUND
            else -> error("Property not recognised")
        }
    }

    private fun String.justifyContent(): YogaJustify {
        return when (this) {
            "start" -> YogaJustify.FLEX_START
            "end" -> YogaJustify.FLEX_END
            "center" -> YogaJustify.CENTER
            "space-between" -> YogaJustify.SPACE_BETWEEN
            "space-around" -> YogaJustify.SPACE_AROUND
            "space-evenly" -> YogaJustify.SPACE_EVENLY
            else -> error("Property not recognised")
        }
    }

    private fun String.positionType(): YogaPositionType {
        return when (this) {
            "static" -> YogaPositionType.STATIC
            "relative" -> YogaPositionType.RELATIVE
            "absolute" -> YogaPositionType.ABSOLUTE
            else -> error("Property not recognised")
        }
    }

    private fun String.flexDirection(): YogaFlexDirection {
        return when (this) {
            "row" -> YogaFlexDirection.ROW
            "row-reverse" -> YogaFlexDirection.ROW_REVERSE
            "column" -> YogaFlexDirection.COLUMN
            "column-reverse" -> YogaFlexDirection.COLUMN_REVERSE
            else -> error("Property not recognised")
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
