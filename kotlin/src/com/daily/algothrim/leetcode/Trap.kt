package com.daily.algothrim.leetcode

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * */
class Trap {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Trap().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        }
    }

    fun trap(height: IntArray): Int {
        if (height.size <= 2) return 0

        val n = height.size
        val leftMax = IntArray(n)
        val rightMax = IntArray(n)

        leftMax[0] = height[0]
        for (i in 1 until n) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i])
        }

        rightMax[n - 1] = height[n - 1]
        var m = n - 2
        while (m >= 0) {
            rightMax[m] = Math.max(rightMax[m + 1], height[m])
            m--
        }

        var sum = 0
        for (j in 0 until n) {
            sum += Math.min(leftMax[j], rightMax[j]) - height[j]
        }

        return sum
    }
}