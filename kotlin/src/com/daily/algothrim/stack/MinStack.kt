package com.daily.algothrim.stack

import java.util.*


/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。(LeetCode 155)
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 使用辅助栈，每次操作都与实际栈一一对应，只不过每次push的都是实际值与辅助栈顶值中的最小值
 * */
class MinStack {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val minStack = MinStack()
            minStack.push(-2)
            minStack.push(0)
            minStack.push(-3)
            println(minStack.getMin())
            minStack.pop()
            println(minStack.top())
            println(minStack.getMin())
        }
    }

    private val mStack = Stack<Int>()
    private val mMinStack = Stack<Int>()

    fun push(item: Int) {
        mStack.push(item)
        if (mMinStack.isEmpty() || item < mMinStack.peek()) {
            mMinStack.push(item)
        } else {
            mMinStack.push(mMinStack.peek())
        }
    }

    fun pop() {
        mMinStack.pop()
        mStack.pop()
    }

    fun top(): Int {
        return mStack.peek()
    }

    fun getMin(): Int {
        return mMinStack.peek()
    }
}