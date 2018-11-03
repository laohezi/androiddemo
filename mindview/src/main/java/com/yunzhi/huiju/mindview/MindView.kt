package com.yunzhi.huiju.mindview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class MindView : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    val data: MindData = MindData()


    fun drawNode(node: Node) {


    }

    fun drawLine() {

    }

    fun drawLineNode(node: Node) {

    }

    fun drawRectNode(node: Node) {

    }


}