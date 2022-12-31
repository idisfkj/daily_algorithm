package com.daily.algothrim.leetcode.easy

import java.util.Stack

/**
 * 232. 用栈实现队列
 */
class MyQueue {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            MyQueue().apply {
                push(1)
                push(2)
                println(peek())
                println(pop())
                println(empty())
            }
        }

    }

    private val inStack = Stack<Int>()
    private val outStack = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        in2out()
        return outStack.pop()
    }

    fun peek(): Int {
        in2out()
        return outStack.peek()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun in2out() {
        if (outStack.isEmpty()) {
            while (inStack.isNotEmpty()) {
                outStack.push(inStack.pop())
            }
        }
    }
}