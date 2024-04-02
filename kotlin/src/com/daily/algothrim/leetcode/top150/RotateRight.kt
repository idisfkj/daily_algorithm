package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 61. 旋转链表
 */

/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
class RotateRight {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RotateRight().rotateRight(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 2)?.printAll()
            println()
            RotateRight().rotateRight(ListNode(0).apply {
                next = ListNode(1).apply {
                    next = ListNode(2)
                }
            }, 4)?.printAll()
        }
    }

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        var n = 0
        var temp = head
        var pre: ListNode? = null

        while (temp != null) {
            n++
            pre = temp
            temp = temp.next
        }

        pre?.next = head

        var m = k % n

        var fast = head
        var slow = head

        while (m-- > 0) {
            fast = fast?.next
        }

        while (fast != head) {
            fast = fast?.next
            pre = slow
            slow = slow?.next
        }

        pre?.next = null
        return slow
    }
}