package com.cesards.android.playground.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class CarouselView(context: Context) : View(context) {

    private val rectangle = Rect()
    private val paint = Paint().apply {
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        //canvas.drawColor(Color.BLACK)
        rectangle.top = 0 + paddingTop
        rectangle.bottom = height - paddingBottom
        rectangle.left = 0 + paddingLeft
        rectangle.right = width - paddingRight
        canvas.drawRect(rectangle, paint)
    }


}