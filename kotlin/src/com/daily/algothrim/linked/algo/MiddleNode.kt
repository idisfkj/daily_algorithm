package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 求链表的中间结点
 * 快慢指针
 */
class MiddleNode {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MiddleNode().middle(LinkedNode("a").apply {
                next = LinkedNode("b").apply {
                    next = LinkedNode("c").apply {
                        next = LinkedNode("d").apply {
                            next = LinkedNode("e").apply {
                                next = LinkedNode("f")
                            }
                        }
                    }
                }
            })?.printAll()
        }
    }

    /**
     * O(n)
     */
    private fun middle(singleLinked: LinkedNode<String>?): LinkedNode<String>? {
        var fast = singleLinked
        var slow = singleLinked

        while (fast?.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        return slow
    }
}