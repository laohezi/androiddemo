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
        drawContent(node.content)
        drawDecor(node)
    }

    /*
    * 绘制父子node之间的连接线
    * */
    fun drawLine(parent: Node, child: Node) {

    }


    /*
    * 绘制关系线
    * */
    fun drawRelationship(from: Node, to: Node) {

    }

    fun drawDecor(node: Node) {

    }

    /*
   * 绘制内容
   * */
    private fun drawContent(content: Node.Content?) {

    }


}