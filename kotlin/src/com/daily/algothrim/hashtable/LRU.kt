package com.daily.algothrim.hashtable

/**
 * 基于散列表与双向链表实现LRU
 * O(1)
 */
class LRU<K, V>(private val capacity: Int = DEFAULT_CAPACITY) {

    companion object {
        private const val DEFAULT_CAPACITY = 8

        @JvmStatic
        fun main(args: Array<String>) {
            LRU<String, Int>().apply {
                cache("one", 1)
                cache("two", 2)
                cache("three", 3)
                cache("four", 4)
                cache("five", 5)
                cache("six", 6)
                cache("123", 126)
                cache("123", 1211126)
                cache("1ii23", 1126)
                cache("1i=i23", 189)
                println("get key: 123 => value: ${get("123")}")
                println("remove key: one")
                remove("one")
                println("remove key: five")
                remove("five")
                cache("two", 2)
                cache("six", 6)
            }.printAll()
        }
    }

    data class LinkedNode<K, V>(
            var prev: LinkedNode<K, V>? = null,
            var next: LinkedNode<K, V>? = null,
            var key: K? = null,
            var value: V? = null
    )

    private var mHead: LinkedNode<K, V>? = LinkedNode()
    private var mTail: LinkedNode<K, V>? = LinkedNode()

    private var mSize: Int = 0

    private val mTable: HashTable<K, LinkedNode<K, V>> = HashTable(capacity)

    init {
        mHead?.next = mTail
    }

    fun cache(key: K, value: V) {
        val item = mTable.get(key)

        if (item == null) {
            // 没有缓存
            val newNode = LinkedNode(key = key, value = value)
            mSize++
            // 缓存已满，删除尾节点
            if (mSize > capacity) {
                mSize--
                removeNode(mTail?.prev)
            }
            // 添加到头节点
            addToHead(newNode)
            // 添加到散列表中
            mTable.put(key, newNode)
        } else {
            // 有缓存, 移除并添加到头节点
            item.value = value
            removeNode(item)
            addToHead(item)
        }
    }

    fun get(key: K): V? {
        val item = mTable.get(key) ?: return null

        removeNode(item)
        addToHead(item)

        return item.value
    }

    fun remove(key: K) {
        val item = mTable.get(key) ?: return

        removeNode(item)
        mTable.remove(key)
        mSize--
    }

    private fun addToHead(node: LinkedNode<K, V>) {
        node.next = mHead?.next
        node.prev = mHead
        mHead?.next?.prev = node
        mHead?.next = node
    }

    private fun removeNode(node: LinkedNode<K, V>?) {
        node?.next?.prev = node?.prev
        node?.prev?.next = node?.next
    }

    fun printAll() {
        println(buildString {
            append("\nLRU Result: \n")
            var temp = mHead
            while (temp?.next != null && temp.next?.value != null) {
                temp = temp.next
                append("key: ${temp?.key} => value: ${temp?.value}")
                append("\n")
            }
        })
    }

}