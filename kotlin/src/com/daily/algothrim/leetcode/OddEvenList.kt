package com.daily.algothrim.leetcode

/**
 * 328. 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * */
class OddEvenList {

    // 输入: 1->2->3->4->5->NULL =>1->3->2->4->5->NULL
    // 输出: 1->3->5->2->4->NULL

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            OddEvenList().solution(
                    (ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(3).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(5)
                                }
                            }
                        }
                    })
            )?.printAll()
        }
    }

    fun solution(head: ListNode?): ListNode? {
        var odd = head
        val firstEven = head?.next // 第一个偶数节点
        var endOdd = head // 最后一个奇数节点

        // 寻找下一个奇数节点
        while (odd?.next != null && odd.next?.next != null) {
            val curr = odd.next?.next
            val preCurr = odd.next
            val nextCurr = curr?.next

            endOdd?.next = curr
            endOdd = curr
            curr?.next = firstEven
            preCurr?.next = nextCurr
            odd = preCurr
        }

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun printAll() {
        println("$`val`")
        var temp = next
        while (temp != null) {
            println(temp.`val`)
            temp = temp.next
        }
    }
}