package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 92. 反转链表 II
 */

/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
 */

class ReverseBetween {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReverseBetween().reverseBetween(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                }, 2, 4
            )?.printAll()
            println()
            ReverseBetween().reverseBetween(ListNode(5), 1, 1)?.printAll()
        }
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val guardHead = ListNode(-1)
        guardHead.next = head
        var temp: ListNode? = guardHead
        var step = 1

        while (temp != null && step < left) {
            temp = temp.next
            step++
        }

        val preHead = temp
        temp = temp?.next
        var pre: ListNode? = null
        val r = temp

        while (temp != null && step <= right) {
            // 翻转
            val next = temp.next
            temp.next = pre
            pre = temp
            temp = next
            step++
        }
        preHead?.next = pre
        r?.next = temp

        return guardHead.next
    }
}