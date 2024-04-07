package com.daily.algothrim.leetcode.top150

/**
 * 215. 数组中的第K个最大元素
 */
/*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4


提示：

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
class FindKthLargest {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindKthLargest().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
            println(FindKthLargest().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
        }
    }

    /**
     * O(n)
     * O(logn)
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return quickSort(nums, 0, nums.size - 1, nums.size - k)
    }

    private fun quickSort(nums: IntArray, l: Int, r: Int, k: Int): Int {
        if (l == r) return nums[k]
        var i = l - 1
        var j = r + 1
        val x = nums[l]

        while (i < j) {
            do {
                i++
            } while (nums[i] < x)
            do {
                j--
            } while (nums[j] > x)
            if (i < j) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
        return if (k <= j) quickSort(nums, l, j, k) else quickSort(nums, j + 1, r, k)
    }
}