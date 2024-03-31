package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 25. K 个一组翻转链表
 */

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：

输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000

进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */

class ReverseKGroup {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReverseKGroup().reverseKGroup(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 2)?.printAll()
            println()
            ReverseKGroup().reverseKGroup(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 3)?.printAll()
        }
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k == 1) return head
        var n = 0
        var temp = head

        while (temp != null) {
            n++
            temp = temp.next
        }

        var time = n / k
        val guard = ListNode(-1)
        guard.next = head
        var timePre: ListNode? = guard
        var timeTemp = timePre?.next
        while (time-- > 0) {
            var cur = timeTemp
            var i = 0
            var pre: ListNode? = null
            while (cur != null && i++ < k) {
                // 翻转
                val next = cur.next
                cur.next = pre
                pre = cur
                cur = next
            }
            timeTemp?.next = cur
            timePre?.next = pre
            timePre = timeTemp
            timeTemp = timeTemp?.next
        }

        return guard.next
    }
}