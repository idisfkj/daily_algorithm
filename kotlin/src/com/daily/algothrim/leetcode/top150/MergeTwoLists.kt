package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 21. 合并两个有序链表
 */

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]


提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
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
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val guard = ListNode(-1)
        var temp: ListNode? = guard
        var h1 = list1
        var h2 = list2
        while (h1 != null && h2 != null) {
            if (h1.`val` < h2.`val`) {
                temp?.next = h1
                h1 = h1.next
            } else {
                temp?.next = h2
                h2 = h2.next
            }
            temp = temp?.next
        }
        if (h1 != null) {
            temp?.next = h1
        }

        if (h2 != null) {
            temp?.next = h2
        }

        return guard.next
    }
}