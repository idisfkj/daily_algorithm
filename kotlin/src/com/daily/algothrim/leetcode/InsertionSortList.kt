package com.daily.algothrim.leetcode

/**
 * 147. 对链表进行插入排序
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * */
class InsertionSortList {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            InsertionSortList().solution(ListNode(4).apply {
                next = ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(3)
                    }
                }
            })?.printAll()
            println()
            InsertionSortList().solution2(ListNode(4).apply {
                next = ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(3)
                    }
                }
            })?.printAll()
        }
    }

    // 4->2->1->3 2->4->1->3 // 4->2
    // 1->2->3->4
    // 反转
    fun solution(head: ListNode?): ListNode? {
        var reversal: ListNode? = null
        var p = head
        var cur: ListNode?

        while (p != null) {
            cur = p
            p = cur.next

            var q = reversal
            var pre: ListNode? = null
            while (q != null) {
                if (cur.`val` < q.`val`) {
                    pre = q
                    q = q.next
                } else {
                    break
                }
            }

            if (pre != null) {
                pre.next = cur
                cur.next = q
            } else {
                cur.next = reversal
                reversal = cur
            }
        }

        var pre: ListNode? = null
        while (reversal != null) {
            val curr = reversal
            reversal = reversal.next
            curr.next = pre
            pre = curr
        }
        return pre
    }

    // 从前往后查找插入点
    fun solution2(head: ListNode?): ListNode? {
        var result: ListNode? = null
        var p = head

        while (p != null) {
            val cur = p
            p = p.next

            var q = result
            var pre: ListNode? = null
            while (q != null) {
                if (cur.`val` < q.`val`) {
                    break
                }
                pre = q
                q = q.next
            }

            if (pre == null) {
                cur.next = result
                result = cur
            } else {
                pre.next = cur
                cur.next = q
            }
        }

        return result
    }
}

