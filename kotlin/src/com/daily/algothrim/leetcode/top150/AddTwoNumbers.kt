package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode

/**
 * 2. 两数相加
 */

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]


提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */
class AddTwoNumbers {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AddTwoNumbers().addTwoNumbers(ListNode(2).apply {
                next = ListNode(4).apply {
                    next = ListNode(3)
                }
            }, ListNode(5).apply {
                next = ListNode(6).apply {
                    next = ListNode(4)
                }
            })?.printAll()
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head1 = l1
        var head2 = l2
        val guard = ListNode(-1)
        var temp = guard
        var flag = 0

        while (head1 != null && head2 != null) {
            val node = ListNode((head1.`val` + head2.`val` + flag) % 10)
            flag = (head1.`val` + head2.`val` + flag) / 10
            temp.next = node
            temp = node
            head1 = head1.next
            head2 = head2.next
        }

        while (head1 != null) {
            val node = ListNode((head1.`val` + flag) % 10)
            flag = (head1.`val` + flag) / 10
            temp.next = node
            temp = node
            head1 = head1.next
        }

        while (head2 != null) {
            val node = ListNode((head2.`val` + flag) % 10)
            flag = (head2.`val` + flag) / 10
            temp.next = node
            temp = node
            head2 = head2.next
        }

        if (flag > 0) {
            temp.next = ListNode(flag)
        }

        return guard.next
    }
}