package com.daily.algothrim.hashtable

/**
 * 散列表
 * O(1)
 */
class HashTable<K, V>(capacity: Int = DEFAULT_CAPACITY) {

    companion object {

        private const val DEFAULT_CAPACITY = 8 // 容量
        private const val LOAD_FACTORY = 0.75 // 装载因子

        @JvmStatic
        fun main(args: Array<String>) {
            HashTable<String, Int>().apply {
                put("zero", 0)
                put("two", 2)
                put("five", 5)
                println("zero ${get("zero")}")
                println("five ${get("five")}")
                put("aa", 12)
                put("bfd", 213)
                put("id", 1213)
                put("pj", 921)
                put("ij", 21)
                put("uu", 898)
                remove("zero")
                put("cc", 231)
                remove("five")
                put("dd", 123)
                put("dd", 222)
                println("dd ${get("dd")}")
                println("five ${get("five")}")
            }
        }
    }

    private var mSize = 0 // 元素大小
    private var mUsed = 0 // 已经使用了的散列表大小
    private var mTable = Array<Entry<K, V>?>(capacity) {
        null
    }

    data class Entry<K, V>(var key: K? = null, var value: V? = null, var next: Entry<K, V>? = null)

    fun put(key: K, value: V) {
        val index = (mTable.size - 1).and(hash(key))
        if (mTable[index] == null) {
            // 建立哨兵
            mTable[index] = Entry()
        }

        var temp = mTable[index]

        if (temp?.next == null) {
            temp?.next = Entry(key, value)
            mUsed++
            mSize++
            if (mUsed >= mTable.size * LOAD_FACTORY) {
                resize()
            }
        } else {
            while (temp?.next != null) {
                temp = temp?.next
                if (temp?.key == key) {
                    temp?.value = value
                    return
                }
            }
            mTable[index]?.next = Entry(key, value, mTable[index]?.next)
            mSize++
        }
    }

    fun remove(key: K) {
        val index = (mTable.size - 1).and(hash(key))
        if (mTable[index]?.next == null) return
        var temp = mTable[index]
        var pre: Entry<K, V>?

        while (temp?.next != null) {
            pre = temp
            temp = temp.next

            if (temp?.key == key) {
                pre.next = temp?.next
                mSize--
                if (mTable[index]?.next == null) mUsed--
                return
            }
        }
    }

    fun get(key: K): V? {
        val index = (mTable.size - 1).and(hash(key))
        if (mTable[index]?.next == null) return null

        var temp = mTable[index]
        while (temp?.next != null) {
            temp = temp.next
            if (temp?.key == key) return temp?.value
        }

        return null
    }

    private fun resize() {
        mUsed = 0
        val oldTable = mTable
        mTable = Array(mTable.size * 2) {
            null
        }
        oldTable.forEach {
            if (it?.next != null) {
                var temp = it
                while (temp?.next != null) {
                    temp = temp.next
                    val index = (mTable.size - 1).and(hash(temp?.key))
                    if (mTable[index] == null) {
                        mUsed++
                        // 建立哨兵
                        mTable[index] = Entry()
                    }
                    mTable[index]?.next = Entry(temp?.key, temp?.value, mTable[index]?.next)
                }
            }
        }
    }

    private fun hash(key: K?): Int {
        return if (key == null) 0 else {
            val h = key.hashCode()
            key.hashCode().xor(h.ushr(16))
        }
    }

}