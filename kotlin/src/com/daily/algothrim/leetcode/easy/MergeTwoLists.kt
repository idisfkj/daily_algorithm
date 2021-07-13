package com.daily.algothrim.leetcode.easy

import com.daily.algothrim.leetcode.ListNode

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class MergeTwoLists {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MergeTwoLists().mergeTwoLists(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(4)
                }
            }, ListNode(1).apply {
                next = ListNode(3).apply {
                    next = ListNode(4)
                }
            })?.printAll()
            MergeTwoLists().mergeTwoLists(null, null)?.printAll()
            MergeTwoLists().mergeTwoLists(null, ListNode(0))?.printAll()
        }
    }

    // l1 = [1,2,4], l2 = [1,3,4]
    // [1,1,2,3,4,4]
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(-1)
        var temp: ListNode? = result
        var left = l1
        var right = l2

        while (left != null && right != null) {
            if (left.`val` <= right.`val`) {
                temp?.next = left
                left = left.next
            } else {
                temp?.next = right
                right = right.next
            }
            temp = temp?.next
        }

        if (left != null) {
            temp?.next = left
        }

        if (right != null) {
            temp?.next = right
        }

        return result.next
    }
}