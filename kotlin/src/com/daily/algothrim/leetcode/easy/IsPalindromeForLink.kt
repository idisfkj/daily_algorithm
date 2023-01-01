package com.daily.algothrim.leetcode.easy

/**
 * 234. 回文链表
 */
class IsPalindromeForLink {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(IsPalindromeForLink().isPalindrome(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(2).apply {
                            next = ListNode(1)
                        }
                    }
                }
            ))
        }
    }

    fun isPalindrome(head: ListNode?): Boolean {
        head ?: return true

        val halfEndNode = findHalfEndNode(head)
        val reverseHalfEndNextNode = reverseLink(halfEndNode?.next)

        var p1: ListNode? = head
        var p2: ListNode? = reverseHalfEndNextNode
        var result = true

        while (result && p2 != null) {
            if (p1?.`val` != p2.`val`) {
                result = false
            }
            p1 = p1?.next
            p2 = p2.next
        }

        halfEndNode?.next = reverseLink(reverseHalfEndNextNode)

        return result
    }

    private fun reverseLink(node: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = node

        while (curr != null) {
            val temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }

    private fun findHalfEndNode(node: ListNode): ListNode? {
        var fast: ListNode? = node
        var slow: ListNode? = node

        while (fast?.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow
    }
}