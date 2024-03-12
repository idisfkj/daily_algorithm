package com.daily.algothrim.leetcode.top150

import kotlin.math.min

/**
 * 209. 长度最小的子数组
 */

/*
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 连续
子数组
 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0


提示：

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 */
class MinSubArrayLen {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinSubArrayLen().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
            println(MinSubArrayLen().minSubArrayLen(4, intArrayOf(1, 4, 4)))
            println(MinSubArrayLen().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
        }
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        var result = Int.MAX_VALUE
        var start = 0
        if (nums[start] >= target) return 1
        var end = 1
        var curTotal = nums[start]
        while (end < n) {
            curTotal += nums[end]
            if (curTotal >= target) {
                result = min(result, end - start + 1)
                while (start < end) {
                    curTotal -= nums[start++]
                    if (curTotal < target) break
                    result = min(result, end - start)
                }
            }
            end++
        }
        return if (result <= n) result else 0
    }
}