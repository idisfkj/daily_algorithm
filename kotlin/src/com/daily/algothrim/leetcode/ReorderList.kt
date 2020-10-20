package com.daily.algothrim.leetcode

import com.daily.algothrim.linked.LinkedNode


/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * */
class ReorderList {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = LinkedNode(
                1,
                LinkedNode(
                    2, LinkedNode(
                        3,
                        LinkedNode(4, LinkedNode(5))
                    )
                )
            )
            ReorderList().solution(head)
            head.printAll()
        }
    }

    fun solution(head: LinkedNode<Int>?) {
        if (head == null) return

        val middleNode = middleNode(head)
        var l2 = middleNode?.next
        middleNode?.next = null
        l2 = reverseList(l2)
        mergeList(head, l2)
    }

    private fun middleNode(head: LinkedNode<Int>?): LinkedNode<Int>? {
        var slow = head
        var fast = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    private fun reverseList(head: LinkedNode<Int>?): LinkedNode<Int>? {
        var prev: LinkedNode<Int>? = null
        var curr = head

        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }

    private fun mergeList(l1: LinkedNode<Int>?, l2: LinkedNode<Int>?) {
        var node1: LinkedNode<Int>? = l1
        var node2: LinkedNode<Int>? = l2

        while (node1 != null && node2 != null) {
            val temp1 = node1.next
            val temp2 = node2.next

            node1.next = node2
            node1 = temp1

            node2.next = node1
            node2 = temp2
        }
    }
}