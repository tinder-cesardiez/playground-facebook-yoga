package com.cesards.android.playground.facebook.yoga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.cesards.android.playground.CONTROLLA_SAMPLE_STRUCT
import com.cesards.android.playground.R
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToViewTree
import com.cesards.android.playground.facebook.yoga.adapter.SetToYogaNodeProperties
import com.cesards.android.playground.facebook.yoga.adapter.layout.*
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToCarouselView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToContainerView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToImageView
import com.cesards.android.playground.facebook.yoga.adapter.ui.AdaptToTextView
import com.cesards.android.playground.sdui.model.Template
import com.facebook.yoga.YogaConfigFactory
import com.facebook.yoga.android.YogaViewLayoutFactory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class YogaActivity : AppCompatActivity() {

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

        val adaptToSpacing = AdaptToSpacing()
        val adaptToViewTree = AdaptToViewTree(
            SetToYogaNodeProperties(
                AdaptToYogaFlexDirection(),
                AdaptToYogaPositionType(),
                AdaptToYogaJustifyContent(),
                AdaptToYogaAlign(),
                AdaptToSpacing()
            ),
            AdaptToTextView(adaptToSpacing),
            AdaptToContainerView(),
            AdaptToCarouselView(adaptToSpacing),
            AdaptToImageView(adaptToSpacing),
        )

        val response = Json {
            ignoreUnknownKeys = true
        }.decodeFromString<Template>(CONTROLLA_SAMPLE_STRUCT)


        val render = requireNotNull(adaptToViewTree(response.value, this, null))

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
