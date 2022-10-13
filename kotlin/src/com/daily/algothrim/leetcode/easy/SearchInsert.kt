package com.daily.algothrim.leetcode.easy

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
class SearchInsert {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SearchInsert().searchInsert(intArrayOf(1,3,5,6), 5))
            println(SearchInsert().searchInsert(intArrayOf(1,3,5,6), 2))
            println(SearchInsert().searchInsert(intArrayOf(1,3,5,6), 7))
        }
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left).shr(1)
            if (target <= nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}