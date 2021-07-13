package com.daily.algothrim.leetcode.hard

import com.daily.algothrim.leetcode.ListNode

/**
 * 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
class MergeKLists {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MergeKLists().mergeKLists(arrayOf(
                ListNode(1).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                },
                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4)
                    }
                },
                ListNode(2).apply {
                    next = ListNode(6)
                }
            ))?.printAll()
        }
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isNullOrEmpty()) return null
        return sort(0, lists.size - 1, lists)
    }

    private fun sort(l: Int, r: Int, lists: Array<ListNode?>): ListNode? {
        if (l == r) return lists[l]
        val m = l + (r - l).shr(1)
        return merge(sort(l, m, lists), sort(m + 1, r, lists))
    }

    private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
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