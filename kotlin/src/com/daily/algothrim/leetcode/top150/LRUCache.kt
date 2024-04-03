package com.daily.algothrim.leetcode.top150

/**
 * 146. LRU 缓存
 */

/*
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。



示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4


提示：

1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put
 */
class LRUCache(capacity: Int) {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LRUCache(2).apply {
                put(1, 1)
                put(2, 2)
                println(get(1))
                put(3, 3)
                println(get(2))
                put(4, 4)
                println(get(1))
                println(get(3))
                println(get(4))
            }
        }
    }

    private var size = 0
    private var head: DListNode? = null
    private var tail: DListNode? = null
    private var n = 0
    private val map = hashMapOf<Int, DListNode>()

    init {
        n = capacity
        head = DListNode(-1, -1)
        tail = DListNode(-1, -1)
        head?.next = tail
        tail?.pre = head
    }

    fun get(key: Int): Int {
        if (!map.containsKey(key)) return -1
        val node = map[key]
        moveToHead(node)
        return node?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node == null) {
            val newNode = DListNode(key, value)
            map[key] = newNode
            addToHead(newNode)
            if (size >= n) {
                val removeNode = removeTail()
                map.remove(removeNode?.key)
            } else {
                size++
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }

    private fun removeNode(node: DListNode?) {
        node?.pre?.next = node?.next
        node?.next?.pre = node?.pre
    }

    private fun addToHead(node: DListNode?) {
        node?.pre = head
        node?.next = head?.next
        head?.next?.pre = node
        head?.next = node
    }

    private fun moveToHead(node: DListNode?) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeTail(): DListNode? {
        val l = tail?.pre
        removeNode(l)
        return l
    }

    class DListNode(val key: Int, var value: Int) {
        var pre: DListNode? = null
        var next: DListNode? = null
    }
}