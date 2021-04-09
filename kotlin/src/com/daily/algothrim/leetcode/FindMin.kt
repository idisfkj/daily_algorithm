package com.daily.algothrim.leetcode

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * */
class FindMin {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindMin().findMin(intArrayOf(1, 3, 5)))
            println(FindMin().findMin(intArrayOf(2, 2, 2, 0, 1)))
            println(FindMin().findMin(intArrayOf(4, 5, 6, 7, 0, 1, 4)))
            println(FindMin().findMin(intArrayOf(1, 0, 1, 1, 1)))
        }
    }

    // 6，7，0，1，4，4，5
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        var min = nums[start]
        var mid: Int

        while (start <= end) {
            mid = start + (end - start).shr(1)
            when {
                nums[start] == nums[mid] -> {
                    min = Math.min(nums[start], min)
                    start++
                }
                nums[start] < nums[mid] -> {
                    min = Math.min(nums[start], min)
                    start = mid + 1
                }
                else -> {
                    min = Math.min(nums[mid], min)
                    end = mid - 1
                }
            }
        }

        return min
    }

    fun findMin2(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            val pivot = low + (high - low).shr(1)
            when {
                nums[pivot] < nums[high] -> high = pivot
                nums[pivot] > nums[high] -> low = pivot + 1
                else -> high -= 1
            }
        }
        return nums[low]
    }

}