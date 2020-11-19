package com.daily.algothrim.leetcode

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * */
class MoveZeroes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(0, 1, 0, 3, 12)
            MoveZeroes().solution(nums).apply {
                nums.forEach {
                    println(it)
                }
            }
            println()
            val nums2 = intArrayOf(0, 0, 1)
            MoveZeroes().solution2(nums2).apply {
                nums2.forEach {
                    println(it)
                }
            }
        }
    }

    // [0,1,0,3,12] [1, 0, 0, 3, 12]
    // [1,3,12,0,0]

    // [0,0,1]
    fun solution(nums: IntArray) {
        var i = 0
        while (i < nums.size) {
            var k = 0
            while (k < nums.size - i - 1) {
                if (nums[k] == 0) {
                    val temp = nums[k + 1]
                    nums[k + 1] = nums[k]
                    nums[k] = temp
                }
                k++
            }
            i++
        }
    }

    fun solution2(nums: IntArray) {
        var right = 0
        var left = 0
        val n = nums.size

        while (right < n) {
            if (nums[right] != 0) {
                val temp = nums[right]
                nums[right] = nums[left]
                nums[left] = temp
                left++
            }
            right++
        }
    }

}