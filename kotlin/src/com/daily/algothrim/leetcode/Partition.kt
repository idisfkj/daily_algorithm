package com.daily.algothrim.leetcode

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * */
class Partition {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Partition().solution(ListNode(1).apply {
                next = ListNode(4).apply {
                    next = ListNode(3).apply {
                        next = ListNode(2).apply {
                            next = ListNode(5).apply {
                                next = ListNode(2)
                            }
                        }
                    }
                }
            }, 3)?.printAll()
            println()
            Partition().solution(ListNode(1).apply {
                next = ListNode(1)
            }, 2)?.printAll()
        }
    }

    /**
     * O(n)
     */
    // head = 1->4->3->2->5->2, x = 3
    fun solution(head: ListNode?, x: Int): ListNode? {
        var fast = head
        // 哨兵
        val result = ListNode(-1).apply { next = head }
        var preFast: ListNode? = result
        var slow: ListNode? = null

        while (fast != null) {
            val temp = fast.next

            // 找到第一个小于x的节点
            if (fast.`val` >= x && slow == null) {
                slow = preFast
            }

            if (fast.`val` < x && slow != null) {
                val next = slow.next
                slow.next = fast
                fast.next = next
                slow = fast

                preFast?.next = temp
            } else {
                preFast = fast
            }

            fast = temp
        }

        return result.next
    }
}