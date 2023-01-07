package com.daily.algothrim.leetcode.medium

import com.daily.algothrim.leetcode.ListNode

/**
 * 24. 两两交换链表中的节点
 */
class SwapPairs {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SwapPairs().swapPairs(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                }
            )?.printAll()
        }
    }

    fun swapPairs(head: ListNode?): ListNode? {
        val guardNode = ListNode(-1)
        guardNode.next = head
        var temp: ListNode? = guardNode

        while (temp?.next?.next != null) {
            val firstNode = temp.next
            val secondNode = temp.next?.next

            temp.next = secondNode
            firstNode?.next = secondNode?.next
            secondNode?.next = firstNode

            temp = firstNode
        }

        return guardNode.next
    }
}