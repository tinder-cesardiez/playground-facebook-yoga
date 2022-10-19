package com.cesards.android.playground.sdui

import android.app.Application
import com.cesards.android.playground.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.uidebugger.UIDebuggerFlipperPlugin
import com.facebook.soloader.SoLoader

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // FB Yoga init
        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            //client.addPlugin(UIDebuggerFlipperPlugin(this, DescriptorMapping.withDefaults()))
            //client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.start()
        }
    }
}