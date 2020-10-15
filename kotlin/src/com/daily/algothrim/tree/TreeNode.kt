package com.daily.algothrim.tree

data class TreeNode<T>(var data: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {
    fun printMid(node: TreeNode<T>) {
        node.left?.let { printMid(it) }
        println(node.data)
        node.right?.let { printMid(it) }
    }

}
