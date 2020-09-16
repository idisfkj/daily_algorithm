package com.daily.algothrim.queue

/**
 * 基于数组的循环队列
 */
class CircleQueue(capacity: Int) {

    private var n = capacity
    private var head = 0
    private var tail = 0
    private var queue = arrayOfNulls<String>(capacity)

    fun enqueue(item: String): Boolean {
        // 队满，会浪费一个存储空间
        if ((tail + 1) % n == head) return false
        queue[tail] = item
        tail = (tail + 1) % n
        return true
    }

    fun dequeue(): String? {
        if (tail == head) return null
        val item = queue[head]
        head = (head + 1) % n
        return item
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CircleQueue(6).apply {
                println(enqueue("1"))
                println(enqueue("2"))
                println(dequeue())
                println(enqueue("3"))
                println(enqueue("4"))
                println(dequeue())
                println(dequeue())
                println(enqueue("5"))
                println(dequeue())
                println(enqueue("6"))
                println(enqueue("7"))
                println(enqueue("8"))
                println(enqueue("9"))
                println(enqueue("10"))
            }
        }
    }

}