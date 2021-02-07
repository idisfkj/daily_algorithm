package com.daily.algothrim.leetcode

/**
 * 665. 非递减数列
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
class CheckPossibility {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CheckPossibility().solution(intArrayOf(4, 2, 3)))
            println(CheckPossibility().solution(intArrayOf(4, 2, 1)))
            println(CheckPossibility().solution(intArrayOf(4, 2)))
            println(CheckPossibility().solution(intArrayOf(2)))
            println(CheckPossibility().solution(intArrayOf(3, 4, 2, 3)))
        }
    }

    // 输入: nums = [4,2,3]
    // 输出: true
    // 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
    fun solution(nums: IntArray): Boolean {
        val size = nums.size
        var adjustTime = 0
        for (i in 0 until size - 1) {
            val x = nums[i]
            val y = nums[i + 1]
            if (x > y) {
                adjustTime++
                if (adjustTime > 1) return false
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x
                }
            }

        }

        return true
    }

}