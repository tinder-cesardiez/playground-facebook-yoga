package com.cesards.android.playground.facebook.yoga.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.cesards.android.playground.sdui.model.Data
import com.cesards.android.playground.sdui.model.Node
import com.facebook.yoga.android.YogaLayout
import kotlin.random.Random

internal class AdaptToWidgetTree(
    private val setToYogaNodeProperties: SetToYogaNodeProperties
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
                    id = Random.nextInt()
                    val view = AppCompatTextView(context).apply {
                        background = background(node.data)
                        text = "Carousel Long for sure YEAH DARN"
                        //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout)
                    view
                }
            }
            Component.TEXT -> {
                (parent as? YogaLayout)?.run {
                    id = Random.nextInt()
                    val view = AppCompatTextView(context).apply {
                        background = background(node.data)
                        text = if (node.data?.text?.body == "Compare all Plans") {
                            "This is a very long text that we need to fill now its even bigger"
                        } else {
                            "Booo ads asdasd asd"
                        }
                        ellipsize = TextUtils.TruncateAt.END

                        //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout)
                    view
                }
            }
            Component.IMAGE -> {
                (parent as? YogaLayout)?.run {
                    id = Random.nextInt()
                    val view = View(context).apply {
                        background = background(node.data)
                        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    }
                    addView(view)
                    setToYogaNodeProperties(context, getYogaNodeForView(view), node.layout)
                    view
                }
            }
            Component.BOX -> {
                val view = YogaLayout(context).apply {
                    id = Random.nextInt()
                    background = background(node.data)
                    //layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
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

    private fun background(data: Data?): Drawable? {
        return data?.color?.solid?.let {
            ColorDrawable(Color.parseColor(it))
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
