package com.cesards.android.playground.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cesards.android.playground.R
import com.cesards.android.playground.facebook.yoga.YogaDynamicPayloadActivity
import com.cesards.android.playground.facebook.yoga.YogaInitialTestActivity
import com.cesards.android.playground.google.flexbox.GoogleFlexboxActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        findViewById<View>(R.id.button_1).setOnClickListener {
            startActivity(Intent(this, YogaInitialTestActivity::class.java))
        }
        findViewById<View>(R.id.button_2).setOnClickListener {
            startActivity(Intent(this, YogaDynamicPayloadActivity::class.java))
        }
        findViewById<View>(R.id.button_3).setOnClickListener {
            startActivity(Intent(this, GoogleFlexboxActivity::class.java))
        }
    }
}