package com.yunzhi.huiju.mindview

class Node(var parent: Node? = null, var content: Content? = null, var childs:
ArrayList<Node>? = null, var callOuts: ArrayList<Node>? = null, var nodeType: NodeType = NodeType
        .NODE) {
    class Content(val content: String = String())

    class Style {

    }

    enum class NodeType {
        NODE, CALL_OUT, FLOAT_NODE
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


    fun addCallOut(index: Int, node: Node) {
        if (callOuts == null) {
            callOuts = ArrayList<Node>()
        }
        callOuts!!.add(index, node)

    }

    fun addCallOut(node: Node) {
        if (callOuts == null) {
            childs = ArrayList<Node>()
        }
        callOuts!!.add(node)
    }

    fun removeCallOut(node: Node) {
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
