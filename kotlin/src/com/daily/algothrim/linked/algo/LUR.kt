package com.daily.algothrim.linked.algo

import com.daily.algothrim.linked.LinkedNode

/**
 * 使用单链表实现LUR
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 2.1 如果此时缓存未满，则将此结点直接插入到链表的头部;
 * 2.2 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 */
class LUR {

    companion object {
        private const val MAX_SIZE = 5

        @JvmStatic
        fun main(args: Array<String>) {
            LUR().apply {
                cache(null, 1).apply {
                    cache(this, 2).apply {
                        cache(this, 3).apply {
                            cache(this, 4).apply {
                                cache(this, 5).apply {
                                    cache(this, 4).apply {
                                        cache(this, 6)?.printAll()
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    /**
     * O(n)
     */
    private fun cache(singleLinked: LinkedNode<Int>?, item: Int): LinkedNode<Int>? {
        // 缓存为空，将第一个加入
        if (singleLinked == null) {
            return LinkedNode(item)
        }

        var head = singleLinked

        // 判断头节点
        if (head.value == item) {
            return head
        }

        var size = 1
        var tempNode = head
        var preTempNode = head

        while (tempNode?.next != null) {
            val currentNode = tempNode.next
            // 1. 已在缓存中, 将其移动到头节点
            if (currentNode?.value == item) {
                tempNode.next = currentNode.next
                currentNode.next = head
                head = currentNode
                return head
            }
            size++
            preTempNode = tempNode
            tempNode = tempNode.next
        }

        // 2. 缓存中不存在
        // 缓存已经满, 删除尾部节点
        if (size == MAX_SIZE) {
            preTempNode?.next = null
        }

        // 将其添加到头节点
        val newItem = LinkedNode(item)
        newItem.next = head
        head = newItem

        return head
    }

}