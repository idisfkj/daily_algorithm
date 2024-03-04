package com.daily.algothrim.leetcode.top150

/**
 * 238. 除自身以外数组的乘积
 */

/*
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。



示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]


提示：

2 <= nums.length <= 105
-30 <= nums[i] <= 30
保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内


进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
class ProductExceptSelf {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ProductExceptSelf().productExceptSelf(intArrayOf(1, 2, 3, 4)).forEach {
                println(it)
            }
            println("  ")
            ProductExceptSelf().productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).forEach {
                println(it)
            }
            println("==upgrade==")
            ProductExceptSelf().productExceptSelf2(intArrayOf(1, 2, 3, 4)).forEach {
                println(it)
            }
            println("  ")
            ProductExceptSelf().productExceptSelf2(intArrayOf(-1, 1, 0, -3, 3)).forEach {
                println(it)
            }
        }
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val left = IntArray(size)
        val right = IntArray(size)
        val result = IntArray(size)

        left[0] = 1
        for (i in 1 until size) {
            left[i] = left[i - 1] * nums[i - 1]
        }

        right[size - 1] = 1
        for (j in size - 2 downTo 0) {
            right[j] = right[j + 1] * nums[j + 1]
        }

        for (k in nums.indices) {
            result[k] = left[k] * right[k]
        }
        return result
    }

    fun productExceptSelf2(nums: IntArray): IntArray {
        val size = nums.size
        val result = IntArray(size)

        result[0] = 1
        for (i in 1 until size) {
            result[i] = result[i - 1] * nums[i - 1]
        }
        var r = 1
        for (j in size - 1 downTo 0) {
            result[j] = result[j] * r
            r *= nums[j]
        }
        return result
    }
}