package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 单链表判断回文
 * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
 */
class Palindrome {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Palindrome().isPalindrome(
                    LinkedNode("2").apply {
                        next = LinkedNode("3").apply {
                            next = LinkedNode("4").apply {
                                next = LinkedNode("3").apply {
                                    next = LinkedNode("2")
                                }
                            }
                        }
                    }
            ).apply {
                println(this)
            }
        }
    }

    /**
     * O(n)
     */
    private fun isPalindrome(singleLinked: LinkedNode<String>?): Boolean {
        // size = 1
        // 2
        if (singleLinked?.next == null) {
            return true
        }

        // size = 2
        // 2 -> 2       critical point => lwo 2 ; fast null
        if (singleLinked.next?.next == null) {
            return singleLinked.value == singleLinked.next?.value
        }

        var low = singleLinked
        var fast = singleLinked.next?.next
        var preFast = singleLinked.next
        var reversalLinked: LinkedNode<String>? = null

        // size > 2
        // 2 -> 3 -> 2              critical point => low = 3; fast = null; preFast = null
        // 2 -> 3 -> 3 -> 2         critical point => low = 3; fast = null; preFast = 2
        // 2 -> 3 -> 4 -> 3 -> 2    critical point => low = 4; fast = null; preFast = null
        // and so on
        while (fast != null) {
            val temp = low

            // 向后移动
            low = low?.next
            preFast = fast.next
            fast = fast.next?.next

            // 反转慢指针位链表
            temp?.next = reversalLinked
            reversalLinked = temp
        }

        if (preFast != null) {
            // size为偶数
            val temp = low
            low = low?.next
            temp?.next = reversalLinked
            reversalLinked = temp
        } else {
            // size为奇数
            low = low?.next
        }

        // low继续向后移动，同时与reversalLinked做值比较
        while (low != null) {
            if (reversalLinked?.value != low.value) {
                return false
            }
            low = low.next
            reversalLinked = reversalLinked.next
        }

        return true
    }
}