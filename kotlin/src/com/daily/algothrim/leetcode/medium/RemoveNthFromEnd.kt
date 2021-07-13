package com.daily.algothrim.leetcode.medium

import com.daily.algothrim.leetcode.ListNode

/**
 * 19. 删除链表的倒数第 N 个结点
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *  进阶：你能尝试使用一趟扫描实现吗？
 */
class RemoveNthFromEnd {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RemoveNthFromEnd().removeNthFromEnd(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 2)?.printAll()
        }
    }

    // head = [1,2,3,4,5], n = 2
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val result = ListNode(-1).apply { next = head }
        var slow: ListNode? = result
        var fast: ListNode? = result

        for (i in 0 until n) {
            fast = fast?.next
        }

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next

        }
        slow?.next = slow?.next?.next

        return result.next
    }
}