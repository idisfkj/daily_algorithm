package com.daily.algothrim.leetcode

import kotlin.math.max

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
class FindMaxAverage {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindMaxAverage().solution(intArrayOf(1, 12, -5, -6, 50, 3), 4))
        }
    }

    fun solution(nums: IntArray, k: Int): Double {
        var maxTotal = 0
        var tempTotal = 0
        var i = 0
        var j = 0
        val size = nums.size

        while (i < size) {
            if (i < k) {
                maxTotal += nums[i]
                tempTotal = maxTotal
            } else {
                tempTotal = tempTotal - nums[j] + nums[i]
                maxTotal = max(tempTotal, maxTotal)
                j++
            }
            i++
        }
        return maxTotal.toDouble() / k
    }
}