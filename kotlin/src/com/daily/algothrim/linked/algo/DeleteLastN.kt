package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode
import java.lang.IllegalStateException

/**
 * 删除链表倒数第 n 个结点
 * 使用快慢指针，快指针先走n步，然后快慢指针再一起走，直到快指针走到链表尾部，此时慢指针的位置即为链表倒数第n个结点
 */
class DeleteLastN {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DeleteLastN().delete(LinkedNode("a").apply {
                next = LinkedNode("b").apply {
                    next = LinkedNode("c").apply {
                        next = LinkedNode("d").apply {
                            next = LinkedNode("e").apply {
                                next = LinkedNode("f").apply {
                                    next = LinkedNode("g")
                                }
                            }
                        }
                    }
                }
            }, 3)?.printAll()
        }
    }

    /**
     * O(n)
     */
    private fun delete(singleLinked: LinkedNode<String>?, n: Int): LinkedNode<String>? {
        // 小于等于零，直接返回原链表
        if (n <= 0) return singleLinked

        val result: LinkedNode<String>? = LinkedNode("#").apply { next = singleLinked }
        var prev = result
        var fast = singleLinked
        var low = singleLinked
        var lastPosition = n

        // 快指针先走n步
        while (fast != null && --lastPosition > 0) {
            fast = fast.next
        }

        // 未走完n步，快指针已经到链表尾部，说明n超过链表的长度
        if (lastPosition > 0) {
            throw IllegalStateException("The size of singleLinked less than $n")
        }

        // 快慢指针一起走
        while (fast?.next != null) {
            fast = fast.next
            prev = low
            low = low?.next
        }

        // 删除链表倒数第n个结点
        prev?.next = low?.next

        return result?.next
    }

}