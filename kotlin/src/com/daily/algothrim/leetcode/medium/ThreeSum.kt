package com.daily.algothrim.leetcode.medium

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
class ThreeSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ThreeSum().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
            println(ThreeSum().threeSum(intArrayOf(0, 0, 0)))
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        // 排序
        nums.sort()
        val result = arrayListOf<List<Int>>()
        val size = nums.size
        var first = 0
        while (first < size) {
            // first > 0 的判断为了排除【0, 0, 0, 0, ..]的情况
            if (first > 0 && nums[first] == nums[first - 1]) { // 排除相同的值
                first++
                continue
            }
            var second = first + 1
            while (second < size) {
                // second > first + 1 的判断为了排除【0, 0, 0, 0, ..]的情况
                if (second > first + 1 && nums[second] == nums[second - 1]) { // 排除相同的值
                    second++
                    continue
                }
                var third = size - 1
                while (second < third && nums[first] + nums[second] > -nums[third]) { // 三数相加大于零，说明third过大，向前移动，减小third的值
                    third--
                }
                // second与third重合，相加一直大于零，说明当前first不存在相加等于零的情况
                if (second == third) break

                // 存在
                if (nums[first] + nums[second] + nums[third] == 0) {
                    result.add(arrayListOf(nums[first], nums[second], nums[third]))
                }
                second++
            }
            first++
        }
        return result
    }
}