package com.daily.algothrim.leetcode

import com.daily.algothrim.linked.LinkedNode

/**
 * 两数相加(leetcode 2)
 *
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class AddTwoNumbers {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AddTwoNumbers().solution(LinkedNode(2, LinkedNode(4, LinkedNode(3))),
                    LinkedNode(5, LinkedNode(6, LinkedNode(4))))?.printAll()
        }
    }

    /**
     * O(m+n)
     */
    fun solution(l1: LinkedNode<Int>?, l2: LinkedNode<Int>?): LinkedNode<Int>? {
        var a = l1
        var b = l2

        val result = LinkedNode(-1)
        var temp: LinkedNode<Int>? = result
        var carry = 0

        while (a != null || b != null) {
            val add = (a?.value ?: 0) + (b?.value ?: 0) + carry
            carry = add / 10
            temp?.next = LinkedNode(add % 10)
            temp = temp?.next
            a = a?.next
            b = b?.next

            if (carry > 0) temp?.next = LinkedNode(carry)
        }

        return result.next
    }
}