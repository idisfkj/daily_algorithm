package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 链表中环的检测
 * 使用快慢指针，慢指针每次走一步，快指针每次走两步；当快指针等于慢指针时，说明快指针已经领先慢指针一圈，即该链表存在环。
 */
class Circle {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = LinkedNode(1)
            println(Circle().existCircle(head.apply {
                next = LinkedNode(2).apply {
                    next = LinkedNode(3).apply {
                        next = LinkedNode(2).apply {
                            next = LinkedNode(1).apply {
                                next = head
                            }
                        }
                    }
                }
            }))
        }
    }

    /**
     * O(n)
     */
    fun existCircle(linkedList: LinkedNode<Int>?): Boolean {

        var slow = linkedList
        var fast = linkedList

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) return true
        }

        return false
    }
}