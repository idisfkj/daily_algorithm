package com.daily.algothrim.leetcode

import com.daily.algothrim.linked.LinkedNode

/**
 * 环形链表(leetcode 141)
 */
class HasCycle {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = LinkedNode(1)
            val cycleNode = LinkedNode(2)
            println(HasCycle().hasCycle(head.apply {
                next = cycleNode.apply {
                    next = LinkedNode(3).apply {
                        next = LinkedNode(2).apply {
                            next = LinkedNode(1).apply {
                                next = cycleNode
                            }
                        }
                    }
                }
            }))
        }
    }

    fun hasCycle(head: LinkedNode<Int>?): Boolean {
        var fast = head
        var slow = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (slow == fast) return true
        }

        return false
    }
}