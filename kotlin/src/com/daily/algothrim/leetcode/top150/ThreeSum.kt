package com.daily.algothrim.leetcode.top150

/**
 * 15. 三数之和
 */
/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。


提示：

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
class ThreeSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ThreeSum().threeSum(intArrayOf(-1,0,1,2,-1,-4)).forEach {
                println("[${it[0]}, ${it[1]}, ${it[2]}]")
            }
            println()
            ThreeSum().threeSum(intArrayOf(0,1,1)).forEach {
                println("[${it[0]}, ${it[1]}, ${it[2]}]")
            }
            println()
            ThreeSum().threeSum(intArrayOf(0,0,0)).forEach {
                println("[${it[0]}, ${it[1]}, ${it[2]}]")
            }
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        nums.sort()
        val n = nums.size
        var i = 0
        var j: Int
        var k: Int

        while (i < n - 2 && nums[i] <= 0) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++
                continue
            }
            j = i + 1
            k = n - 1
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++
                } else {
                    result.add(arrayListOf(nums[i], nums[j], nums[k]))
                    j++
                    while (j < k && nums[j] == nums[j - 1]) j++
                }
            }
            i++
        }
        return result
    }
}