package com.daily.algothrim.leetcode.easy

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
class DeleteDuplicates {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DeleteDuplicates().deleteDuplicates(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2)
                    }
                }
            )?.printAll()
            println()
            DeleteDuplicates().deleteDuplicates(
                ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(3).apply {
                                next = ListNode(3)
                            }
                        }
                    }
                }
            )?.printAll()
        }
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null
        var cur = head
        while (cur?.next != null) {
            if (cur.`val` == cur.next?.`val`) {
                cur.next = cur.next?.next
            } else {
                cur = cur.next
            }
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