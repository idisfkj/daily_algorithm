package com.daily.algothrim.leetcode.easy

import java.util.LinkedList

/**
 * 225. 用队列实现栈
 */
class MyStack {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MyStack().apply {
                push(1)
                push(2)
                println(top())
                println(pop())
                println(empty())
            }
        }
    }

    private var queue1: LinkedList<Int> = LinkedList()
    private var queue2: LinkedList<Int> = LinkedList()

    fun push(x: Int) {
        queue1.offer(x)
        while (queue2.isNotEmpty()) {
            queue1.offer(queue2.poll())
        }
        val temp = queue1
        queue1 = queue2
        queue2 = temp
    }

    fun pop(): Int {
        return queue2.poll()
    }

    fun top(): Int {
        return queue2.peek()
    }

    fun empty(): Boolean {
        return queue2.isEmpty()
    }

}