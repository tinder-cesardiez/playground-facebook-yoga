package com.cesards.android.playground.google.flexbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cesards.android.playground.R
import com.cesards.android.playground.data.POSITION
import com.cesards.android.playground.sdui.model.Template
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class GoogleFlexboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_flexbox)

        val response = Json {
            ignoreUnknownKeys = true
        }.decodeFromString<Template>(POSITION("absolute"))

        //val renderable = AdaptToYogaLayout(AdaptToWidgetTree())(this, response)
        //setContentView(renderable)
    }
}