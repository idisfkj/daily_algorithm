package com.daily.algothrim.stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。(LeetCode 155)
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 使用辅助栈，每次操作都与实际栈一一对应，只不过每次push的都是实际值与辅助栈顶值中的最小值
 * */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private Stack<Integer> mStack = new Stack<>();
    private Stack<Integer> mMinStack = new Stack<>();

    private void push(int item) {
        mStack.push(item);
        if (mMinStack.isEmpty() || item < mMinStack.peek()) {
            mMinStack.push(item);
        } else {
            mMinStack.push(mMinStack.peek());
        }
    }

    private int pop() {
        mMinStack.pop();
        return mStack.pop();
    }

    private int top() {
        return mStack.peek();
    }

    private int getMin() {
        return mMinStack.peek();
    }
}
