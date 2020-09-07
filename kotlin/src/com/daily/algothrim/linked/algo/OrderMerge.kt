package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 两个有序链表的合并
 * 以其中一个有序链表作为结果集(firstLinked)，两个链表从头结点开始向后逐一比较；
 * 1. 结果集(firstLinked)的值小于等于非结果集(secondLinked)的值，结果集(firstLinked)继续向后走一步
 * 2. 如果非结果集(secondLinked)链表的值小于结果集(firstLinked)的值，则将非结果集(secondLinked)的值插入到当前结果集(firstLinked)的前一位
 * 3. 最后逐一比较完之后，非结果集(secondLinked)还有剩余，则将剩余的结点逐一添加到结果集(firstLinked)后面。
 */
class OrderMerge {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            OrderMerge().merge(LinkedNode(1).apply {
                next = LinkedNode(2).apply {
                    next = LinkedNode(4).apply {
                        next = LinkedNode(5).apply {
                            next = LinkedNode(8)
                        }
                    }
                }
            }, LinkedNode(0).apply {
                next = LinkedNode(3).apply {
                    next = LinkedNode(6).apply {
                        next = LinkedNode(7).apply {
                            next = LinkedNode(10).apply {
                                next = LinkedNode(11)
                            }
                        }
                    }
                }
            })?.printAll()
        }
    }

    /**
     * O(n)
     */
    private fun merge(firstLinked: LinkedNode<Int>?, secondLinked: LinkedNode<Int>?): LinkedNode<Int>? {

        var first = firstLinked // 结果集
        var second = secondLinked // 非结果集
        val result: LinkedNode<Int>? = LinkedNode(-1).apply { next = firstLinked } // 结果集头结点
        var prev = result // 结果集当前比较位置的前一结点

        while (first != null && second != null) {
            // 1. 结果集小于等于非结果集，继续向后移动比较
            if (first.value <= second.value) {
                // 记录结果集前一结点
                prev = first
                first = first.next
                continue
            }

            // 插入
            prev?.next = second
            val temp = second.next
            second.next = first
            prev = second
            second = temp
        }

        // 3. 非结果集还有剩余，将剩余的结点逐一插入到结果集尾部
        while (second != null) {
            prev?.next = second
            prev = second
            second = second.next
        }

        return result?.next
    }
}