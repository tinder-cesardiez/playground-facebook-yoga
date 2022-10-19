package com.cesards.android.playground.google.flexbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.cesards.android.playground.POSITION
import com.cesards.android.playground.R
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToNode
import com.cesards.android.playground.facebook.yoga.adapter.AdaptToYogaLayout
import com.cesards.android.playground.sdui.model.Template
import com.facebook.yoga.android.YogaLayout
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class GoogleFlexboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_flexbox)

        val response = Json {
            ignoreUnknownKeys = true
        }.decodeFromString<Template>(POSITION("absolute"))

        val renderable = AdaptToYogaLayout(AdaptToNode())(this, response)
        setContentView(renderable)
    }
}