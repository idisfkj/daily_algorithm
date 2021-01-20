package com.daily.algothrim.leetcode

import kotlin.math.max

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
class MaximumProduct {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaximumProduct().solution(intArrayOf(1, 2, 3, 4)))
        }
    }


    // 三个最大数的乘积或者两个最小负数的与最大正数的乘积
    fun solution(nums: IntArray): Int {
        var max1 = Int.MIN_VALUE
        var max2 = Int.MIN_VALUE
        var max3 = Int.MIN_VALUE
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE

        for (num in nums) {
            when {
                num > max1 -> {
                    max3 = max2
                    max2 = max1
                    max1 = num
                }
                num > max2 -> {
                    max3 = max2
                    max2 = num
                }
                num > max3 -> max3 = num
            }

            if (num < min1) {
                min2 = min1
                min1 = num
            } else if (num < min2) {
                min2 = num
            }
        }

        return max(max1.times(max2).times(max3), max1.times(min1).times(min2))
    }
}