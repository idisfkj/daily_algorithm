package com.daily.algothrim.leetcode.medium

/**
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
class Search {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Search().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
            println(Search().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
            println(Search().search(intArrayOf(1), 0))
            println(Search().search(intArrayOf(3, 1), 1))
        }
    }

    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = start + (end - start).shr(1)
            if (target == nums[mid]) return mid
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
        }
        return -1
    }
}