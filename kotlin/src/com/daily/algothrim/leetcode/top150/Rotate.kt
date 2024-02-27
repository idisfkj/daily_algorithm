package com.daily.algothrim.leetcode.top150
/*
189. 轮转数组

给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]

示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]

提示：

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
*/


class Rotate {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
//            Rotate().rotate(nums, 3)
            Rotate().rotate2(nums, 3)
            nums.forEach {
                println(it)
            }
        }
    }

    fun rotate(nums: IntArray, k: Int) {
        // 翻转数组
        val n = nums.size
        val m = k % n
        // 1. 翻转整个原数组
        reverse(nums, 0, n - 1)
        // 2. 翻转[0, k%n-1]
        reverse(nums, 0, m - 1)
        // 3. 翻转[k%n-1, n-1]
        reverse(nums, m, n - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }

    fun rotate2(nums: IntArray, k: Int) {
        val n = nums.size
        val temp = IntArray(n)
        for (i in nums.indices) {
            temp[(i + k) % n] = nums[i]
        }
        temp.copyInto(nums, 0, 0, n)
    }

}