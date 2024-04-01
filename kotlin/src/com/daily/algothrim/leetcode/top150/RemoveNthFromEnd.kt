package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 19. 删除链表的倒数第 N 个结点
 */

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


进阶：你能尝试使用一趟扫描实现吗？
 */

class RemoveNthFromEnd {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RemoveNthFromEnd().removeNthFromEnd(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                }, 2
            )?.printAll()
            println()
            RemoveNthFromEnd().removeNthFromEnd(ListNode(1), 1)?.printAll()
            println()
            RemoveNthFromEnd().removeNthFromEnd(ListNode(1).apply {
                next = ListNode(2)
            }, 1)?.printAll()
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val guard = ListNode(-1)
        guard.next = head
        var fast: ListNode? = guard
        var slow: ListNode? = guard

        for (i in 0 until n) {
            fast = fast?.next
        }

        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        slow?.next = slow?.next?.next

        return guard.next
    }

}