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
                    val lp = view.layoutParams as FlexboxLayout.LayoutParams
                    lp.order = -1;
                    //lp.setFlexGrow(2)
                    view.layoutParams = lp;
                    //getYogaNodeForView(view).setLayoutParameters(node.layout)
                    view
                }
            }
            Component.BOX -> {
                val view = FlexboxLayout(context).apply {
                    id = Random.nextInt()
                    background = background(node.data)
                    setLayoutParameters(node.layout)
                    //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                }

                (parent as? FlexboxLayout)?.run {
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

    private fun FlexboxLayout.setLayoutParameters(layout: Layout) {
//        layout.width?.run {
//            setWidth(this)
//        }
//        layout.height?.run {
//            setHeight(this)
//        }
//        layout.flexGrow?.run {
//            flexDirection
//            flexGrow = this
//        }
//        layout.justifyContent?.run {
//            justifyContent = justifyContent()
//        }
//        layout.position?.run {
//            positionType = positionType()
//        }
//        layout.flexDirection?.run {
//            flexDirection = flexDirection()
//        }
//        layout.top?.run {
//            setPosition(YogaEdge.TOP, this)
//        }
//        layout.left?.run {
//            setPosition(YogaEdge.LEFT, this)
//        }
//        layout.right?.run {
//            setPosition(YogaEdge.RIGHT, this)
//        }
//        layout.bottom?.run {
//            setPosition(YogaEdge.BOTTOM, this)
//        }
//        layout.margin?.run {
//            setMargin(YogaEdge.ALL, this)
//        }
        layout.padding?.run {
            //setPadding(YogaEdge.ALL, this)
        }
        layout.alignItems?.run {
            alignItems = alignSelf()
        }
        layout.alignSelf?.run {
            alignContent
        }
    }

//    private fun String.align(): YogaAlign {
//        return when (this) {
//            "auto" -> YogaAlign.AUTO
//            "flex-start" -> YogaAlign.FLEX_START
//            "flex-end" -> YogaAlign.FLEX_END
//            "center" -> YogaAlign.CENTER
//            "stretch" -> YogaAlign.STRETCH
//            "baseline" -> YogaAlign.BASELINE
//            "space-between" -> YogaAlign.SPACE_BETWEEN
//            "space-around" -> YogaAlign.SPACE_AROUND
//            else -> error("Property not recognised")
//        }
//    }
    private fun String.alignSelf(): Int {
        return when (this) {
            "auto" -> AlignSelf.AUTO
            "flex-start" -> AlignItems.FLEX_START
            "flex-end" -> AlignItems.FLEX_END
            "center" -> AlignItems.CENTER
            "stretch" -> AlignItems.STRETCH
            "baseline" -> AlignItems.BASELINE
//            "space-between" -> AlignSelf.SPACE_BETWEEN
//            "space-around" -> AlignSelf.SPACE_AROUND
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

    private fun String.flexDirection(): Int {
        return when (this) {
            "row" -> FlexDirection.ROW
            "row-reverse" -> FlexDirection.ROW_REVERSE
            "column" -> FlexDirection.COLUMN
            "column-reverse" -> FlexDirection.COLUMN_REVERSE
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