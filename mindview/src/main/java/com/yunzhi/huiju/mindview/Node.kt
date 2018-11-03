package com.yunzhi.huiju.mindview

open class Node(var parent: Node? = null,
                var content: Content? = null,//内容
                var childs: ArrayList<Node>? = null,//子节点
                var callOuts: ArrayList<CallOut>? = null,//注释节点
                var relateNodes: ArrayList<Node>? = null//连接节点,本节点为出发点

) {
    class Content(
            val content: String = String()//html文本或者是富文本编辑器保存的内容,格式暂时还不固定
    )

    class Style {
        var width: Int = -1 //边框宽度,默认为-1,表示没有限制


    }


    enum class State {
        FOLD, UNFOLD
    }

    fun addNode(index: Int, node: Node) {
        if (childs == null) {
            childs = ArrayList<Node>()
        }
        childs!!.add(index, node)
    }


    fun addNode(node: Node) {
        if (childs == null) {
            childs = ArrayList<Node>()
        }
        childs!!.add(node)
    }

    fun removeNode(node: Node) {
        childs?.let {
            it.remove(node)
        }
    }

    fun removeNode(index: Int) {
        childs?.let {
            it.removeAt(index)
        }
    }


    fun addCallOut(index: Int, node: CallOut) {
        if (callOuts == null) {
            callOuts = ArrayList<CallOut>()
        }
        callOuts!!.add(index, node)

    }

    fun addCallOut(node: CallOut) {
        if (callOuts == null) {
            callOuts = ArrayList<CallOut>()
        }
        callOuts!!.add(node)
    }

    fun removeCallOut(node: CallOut) {
        callOuts?.let {
            it.remove(node)
        }
    }

    fun removeCallOut(index: Int) {
        callOuts?.let {
            it.removeAt(index)
        }
    }
}
