package com.daily.algothrim.tree

/**
 * 二叉查找树
 * O(log n) ~ O(n) 分别对应完全二叉树与链表
 */
class BinarySearchTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            BinarySearchTree().apply {
                insert(33)
                insert(16)
                insert(50)
                insert(13)
                insert(18)
                insert(34)
                insert(58)
                insert(15)
                insert(17)
                insert(25)
                insert(51)
                insert(66)
                insert(19)
                insert(27)
                insert(55)
                delete(18)
            }.printAll()
        }
    }

    private var mTree: TreeNode<Int>? = null

    fun find(data: Int): TreeNode<Int>? {
        var temp = mTree
        while (temp != null) {
            temp = when {
                data < temp.data -> {
                    temp.left
                }
                data > temp.data -> {
                    temp.right
                }
                else -> {
                    return temp
                }
            }
        }
        return null
    }

    fun insert(data: Int) {
        if (mTree == null) {
            mTree = TreeNode(data)
            return
        }

        var temp = mTree

        while (temp != null) {
            if (data < temp.data) {
                if (temp.left == null) {
                    temp.left = TreeNode(data)
                    return
                }
                temp = temp.left
            } else if (data > temp.data) {
                if (temp.right == null) {
                    temp.right = TreeNode(data)
                    return
                }
                temp = temp.right
            }
        }
    }

    fun delete(data: Int) {
        var p = mTree
        var pp: TreeNode<Int>? = null

        while (p != null && p.data != data) {
            pp = p
            p = if (data < p.data) {
                p.left
            } else {
                p.right
            }
        }

        if (p == null) return

        // 有两个子节点
        if (p.left != null && p.right != null) {
            // 找右子树最小的节点
            var minP = p.right
            var minPP = p
            while (minP?.left != null) {
                minPP = minP
                minP = minP.left
            }
            p.data = minP?.data ?: 0
            p = minP
            pp = minPP
        }

        // 小于两个节点, 同时确认删除后指向的子节点
        val child: TreeNode<Int>?
        child = when {
            p?.left != null -> {
                p.left
            }
            p?.right != null -> {
                p.right
            }
            else -> {
                null
            }
        }

        when {
            pp == null -> { // 删除的是根节点，且小于两个子节点
                mTree = child
            }
            pp.left == p -> { // 删除的是左节点，或者是有两个子节点时，找到的右子树的最小节点
                pp.left = child
            }
            else -> { // 删除的是右节点
                pp.right = child
            }
        }
    }

    fun findMax(): TreeNode<Int>? {
        var temp = mTree
        while (temp?.right != null) {
            temp = temp.right
        }
        return temp
    }

    fun findMin(): TreeNode<Int>? {
        var temp = mTree
        while (temp?.left != null) {
            temp = temp.left
        }
        return temp
    }

    fun printAll() {
        mTree?.let {
            it.printMid(it)
        }
    }
}