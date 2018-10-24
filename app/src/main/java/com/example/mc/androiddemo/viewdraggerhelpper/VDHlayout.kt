package com.example.mc.androiddemo.viewdraggerhelpper

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.widget.ViewDragHelper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout

class VDHlayout(context: Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {
    private var viewDragHelper: ViewDragHelper? = null

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return viewDragHelper!!.shouldInterceptTouchEvent(ev!!)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        viewDragHelper!!.processTouchEvent(event!!)
        return true
    }

    init {
        viewDragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return true
            }

            override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                return left
            }

            override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
                return top
            }

        })
    }


}