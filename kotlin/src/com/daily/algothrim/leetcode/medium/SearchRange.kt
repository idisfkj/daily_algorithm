package com.daily.algothrim.leetcode.medium

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
class SearchRange {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SearchRange().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).forEach {
                println(it)
            }
            SearchRange().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).forEach {
                println(it)
            }
            SearchRange().searchRange(intArrayOf(), 0).forEach {
                println(it)
            }
            SearchRange().searchRange(intArrayOf(2, 2), 3).forEach {
                println(it)
            }
        }
    }

    // nums = [5,7,7,8,8,10], target = 8
    // [3,4]
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val result = IntArray(2)
        val start = binarySearch(nums, target, true)
        val end = binarySearch(nums, target)
        if (start in 0..end && end < nums.size && nums[start] == target && nums[end] == target) {
            result[0] = start
            result[1] = end
        } else {
            result[0] = -1
            result[1] = -1
        }

        return result
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Boolean = false): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left).shr(1)
            if (target < nums[mid] || (start && target <= nums[mid])) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return if (start) right + 1 else left - 1
    }
}