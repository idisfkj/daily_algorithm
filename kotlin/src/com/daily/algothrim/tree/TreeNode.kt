package com.daily.algothrim.tree

data class TreeNode<T>(var data: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {
    fun printMid(node: TreeNode<T>) {
        println(node.data)
        node.left?.let { printMid(it) }
        node.right?.let { printMid(it) }
    }

}
