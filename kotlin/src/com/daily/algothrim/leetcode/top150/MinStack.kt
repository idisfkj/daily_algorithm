package com.daily.algothrim.leetcode.top150

import java.util.LinkedList
import kotlin.math.min

/**
 * 155. 最小栈
 */

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。


示例 1:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.


提示：

-231 <= val <= 231 - 1
pop、top 和 getMin 操作总是在 非空栈 上调用
push, pop, top, and getMin最多被调用 3 * 104 次
 */

class MinStack {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MinStack().apply {
                push(-2)
                push(0)
                push(-3)
                println(getMin())
                pop()
                println(top())
                println(getMin())
            }
        }
    }

    private val stack = LinkedList<Int>()
    private val minStack = LinkedList<Int>().apply {
        push(Int.MAX_VALUE)
    }

    fun push(`val`: Int) {
        stack.push(`val`)
        minStack.push(min(minStack.peek(), `val`))
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}