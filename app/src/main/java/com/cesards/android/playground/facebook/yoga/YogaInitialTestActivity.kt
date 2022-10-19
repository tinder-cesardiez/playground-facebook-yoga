package com.cesards.android.playground.facebook.yoga

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cesards.android.playground.R
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaFlexDirection
import com.facebook.yoga.YogaNode
import com.facebook.yoga.android.YogaLayout


class YogaInitialTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // The following is optional, and it would allow us to use:
        // <YogaLayout
        // tags instead of
        // <com.facebook.yoga.android.YogaLayout
        // Which is actually counter productive since we want the IDE.
        // See: https://github.com/facebook/yoga/issues/503
        //layoutInflater.factory = YogaViewLayoutFactory.getInstance()
        //LayoutInflater.from(this).factory = YogaViewLayoutFactory.getInstance()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Two ways to make this work:
        // addViewFromLayout(findViewById(R.id.yoga_root))
        addViewProgrammatically(findViewById(R.id.yoga_root))
    }

    private fun addViewFromLayout(rootLayout: YogaLayout) {
        LayoutInflater.from(this).inflate(R.layout.yoga_main_row, rootLayout)
    }

    private fun addViewProgrammatically(rootLayout: YogaLayout) {
        val parent = YogaLayout(this).apply {
            background = ColorDrawable(ContextCompat.getColor(context!!, R.color.system_accent3_500))
            // YogaLayout.LayoutParams.MATCH_PARENT
            layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300)
            yogaNode.alignItems = YogaAlign.CENTER
            yogaNode.flexDirection = YogaFlexDirection.ROW
        }

        val size = resources.getDimensionPixelSize(R.dimen.image_size)
        //val imageLayoutParams = ViewGroup.LayoutParams(size, size)
        val image = ImageView(this).apply {
            //layoutParams = imageLayoutParams
            setImageResource(R.drawable.ic_launcher_background)
        }
        parent.addView(image)
        // Two ways to achieve the same thing.
        val imageNode = parent.getYogaNodeForView(image)
        imageNode.setWidth(size.toFloat())
        imageNode.setHeight(size.toFloat())
        // Use Yoga Nodes for flexbox-specific layout setup:
        // imageNode.setWidthPercent(100);
        // imageNode.setFlexDirection(YogaFlexDirection.ROW);

        rootLayout.addView(parent)
    }
}