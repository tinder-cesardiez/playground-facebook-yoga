package com.cesards.android.playground.facebook.yoga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.cesards.android.playground.CONTROLLA_SAMPLE_STRUCT
import com.cesards.android.playground.R
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToWidgetTree
import com.cesards.android.playground.facebook.yoga.adapter.SetToYogaNodeProperties
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaAlign
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaFlexDirection
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaJustifyContent
import com.cesards.android.playground.facebook.yoga.adapter.layout.AdaptToYogaPositionType
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToCarouselView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToContainerView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToImageView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToTextView
import com.cesards.android.playground.sdui.model.Template
import com.facebook.yoga.YogaConfigFactory
import com.facebook.yoga.android.YogaViewLayoutFactory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class YogaDynamicPayloadActivity : AppCompatActivity() {

    init {
        YogaConfigFactory.create().apply {
            setUseWebDefaults(true)
            setPrintTreeFlag(true)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflater.from(this).factory = YogaViewLayoutFactory.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_dynamic_payload)

        val adaptToWidgetTree = AdaptToWidgetTree(
            SetToYogaNodeProperties(
                AdaptToYogaFlexDirection(),
                AdaptToYogaPositionType(),
                AdaptToYogaJustifyContent(),
                AdaptToYogaAlign()
            ),
            AdaptToTextView(),
            AdaptToContainerView(),
            AdaptToCarouselView(),
            AdaptToImageView(),
        )

        val response = Json {
            ignoreUnknownKeys = true
        }.decodeFromString<Template>(CONTROLLA_SAMPLE_STRUCT)


        val render = requireNotNull(adaptToWidgetTree(response.value, this, null))

        findViewById<ViewGroup>(R.id.root).addView(render)
//        setContentView(
//            render,
//            YogaLayout.LayoutParams(
//                ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT, // 1000,
//                    ViewGroup.LayoutParams.MATCH_PARENT // 1000,
//                )
//            )
//        )
        // Problems:
        // - Parent layout parameters conflict with given "width" and "height". See how SAMPLE_FLEX is rendered full screen instead of using 900 and 600

    }
}
