package com.daily.algothrim.leetcode.hard

import java.util.*

/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
class LargestRectangleArea {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(LargestRectangleArea().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
            println(LargestRectangleArea().largestRectangleArea(intArrayOf(2, 4)))
        }
    }

    // 输入：heights = [2,1,5,6,2,3]
    // 输出：10
    fun largestRectangleArea(heights: IntArray): Int {
        var largest = Int.MIN_VALUE
        val size = heights.size
        val left = IntArray(size)
        val right = IntArray(size)
        Arrays.fill(right,  size)

        val stack = Stack<Int>()
        for (i in 0 until size) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i
                stack.pop()
            }
            left[i] = if (stack.isEmpty()) -1 else stack.peek()
            stack.push(i)
        }

        for (j in 0 until size) {
            largest = Math.max(largest, (right[j] - left[j] - 1) * heights[j])
        }

        return largest
    }

}