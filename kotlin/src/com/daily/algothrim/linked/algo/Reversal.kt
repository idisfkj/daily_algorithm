package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 单链表反转
 */
class Reversal {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Reversal().reversal(LinkedNode("a").apply {
                next = LinkedNode("b").apply {
                    next = LinkedNode("c").apply {
                        next = LinkedNode("d").apply {
                            next = LinkedNode("a")
                        }
                    }
                }
            })?.printAll()
        }
    }

    /**
     * O(n)
     */
    fun reversal(singleLinked: LinkedNode<String>?): LinkedNode<String>? {
        var result: LinkedNode<String>? = null
        var current = singleLinked
        var next: LinkedNode<String>?

        while (current != null) {
            next = current.next
            current.next = result
            result = current
            current = next
        }
        return result
    }
}