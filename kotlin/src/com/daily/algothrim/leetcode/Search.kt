package com.daily.algothrim.leetcode

/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 */
class Search {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Search().search(intArrayOf(2,5,6,0,0,1,2), 0))
            println(Search().search(intArrayOf(2,5,6,0,0,1,2), 3))
            println(Search().search(intArrayOf(1,0,1,1,1), 0))
        }
    }

    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty()) return false

        var start = 0
        var end = nums.size - 1
        var mid: Int

        while (start <= end) {
            mid = start + (end - start).shr(1)

            if (nums[mid] == target) return true

            // 1. 无法分清左右是否有序，向后挪一位将重复的去除，重新比较
            if (nums[start] == nums[mid]) {
                start++
                continue
            }

            if (nums[start] < nums[mid]) { // 2. 前半部分有序
                if (nums[mid] > target && nums[start] <= target) { // 在前半部分
                    end = mid - 1
                } else { // 在后半部分
                    start = mid + 1
                }
            } else { // 3. 后半部分有序
                if (nums[mid] < target && nums[end] >= target) { // 在后半部分
                    start = mid + 1
                } else { // 在前半部分
                    end = mid - 1
                }
            }
        }
        return false
    }
}