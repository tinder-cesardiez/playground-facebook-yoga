package com.cesards.android.playground.facebook.yoga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.cesards.android.playground.*
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToNode
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToYogaLayout
import com.cesards.android.playground.sdui.model.Template
import com.facebook.yoga.YogaConfigFactory
import com.facebook.yoga.YogaStyleInputs.POSITION
import com.facebook.yoga.android.YogaLayout
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

        val response = Json {
            ignoreUnknownKeys = true
        }.decodeFromString<Template>(POSITION("absolute"))

        val renderable = AdaptToYogaLayout(AdaptToNode())(this, response)
        setContentView(
            renderable,
            YogaLayout.LayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, // 1000,
                    ViewGroup.LayoutParams.MATCH_PARENT // 1000,
                )
            )
        )
        // Problems:
        // - Parent layout parameters conflict with given "width" and "height". See how SAMPLE_FLEX is rendered full screen instead of using 900 and 600

    }
}
