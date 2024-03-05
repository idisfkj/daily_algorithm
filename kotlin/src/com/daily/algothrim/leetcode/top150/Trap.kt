package com.daily.algothrim.leetcode.top150

/**
 * 42. 接雨水
 */

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
class Trap {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Trap().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
            println(Trap().trap(intArrayOf(4,2,0,3,2,5)))
        }
    }

    fun trap(height: IntArray): Int {
        var maxHeight = -1
        var maxIndex = 0
        var result = 0
        for (i in height.indices) {
            if (height[i] > maxHeight) {
                maxHeight = height[i]
                maxIndex = i
            }
        }

        var temp = Int.MIN_VALUE
        for (l in 0 until maxIndex) {
            if (height[l] >= temp) {
                temp = height[l]
                continue
            }
            result += temp - height[l]
        }

        temp = Int.MIN_VALUE
        for (r in height.size - 1 downTo maxIndex + 1) {
            if (height[r] >= temp) {
                temp = height[r]
                continue
            }
            result += temp - height[r]
        }
        return result
    }
}