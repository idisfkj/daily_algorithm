package com.daily.algothrim.leetcode.medium

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
class MaxArea {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxArea().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
            println(MaxArea().maxArea(intArrayOf(1, 1)))
            println(MaxArea().maxArea(intArrayOf(4, 3, 2, 1, 4)))
            println(MaxArea().maxArea(intArrayOf(1, 2, 1)))
        }
    }

    // [1,8,6,2,5,4,8,3,7]
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size - 1
        var max = 0
        var min = Int.MIN_VALUE
        while (start < end) {
            val startValue = height[start]
            val endValue = height[end]
            val minValue = Math.min(startValue, endValue)
            if (minValue > min) {
                min = minValue
                max = Math.max(max, (end - start) * min)
            }
            if (startValue <= min) {
                start++
            } else {
                end--
            }
        }
        return max
    }
}