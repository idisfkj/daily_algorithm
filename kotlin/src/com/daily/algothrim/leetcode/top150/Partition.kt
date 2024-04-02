package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 86. 分隔链表
 */

/*
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。

示例 1：

输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
示例 2：

输入：head = [2,1], x = 2
输出：[1,2]


提示：

链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200
 */
class Partition {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Partition().partition(
                ListNode(1).apply {
                    next = ListNode(4).apply {
                        next = ListNode(3).apply {
                            next = ListNode(2).apply {
                                next = ListNode(5).apply {
                                    next = ListNode(2)
                                }
                            }
                        }
                    }
                }, 3
            )?.printAll()
            println()
            Partition().partition(ListNode(2).apply {
                next = ListNode(1)
            }, 2)?.printAll()
        }
    }

    /**
     * O(n)
     * O(1)
     */
    fun partition(head: ListNode?, x: Int): ListNode? {
        var temp = head
        val guardLeft = ListNode(-1)
        var endLeft: ListNode? = guardLeft

        val guardRight = ListNode(-1)
        var endRight: ListNode? = guardRight

        while (temp != null) {
            if (temp.`val` < x) {
                endLeft?.next = temp
                endLeft = endLeft?.next
            } else {
                endRight?.next = temp
                endRight = endRight?.next
            }
            temp = temp.next
        }
        endRight?.next = null
        endLeft?.next = guardRight.next
        return guardLeft.next
    }
}