package com.daily.algothrim.leetcode

/**
 * 421. 数组中两个数的最大异或值
 *
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 */
class FindMaximumXOR {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindMaximumXOR().findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8)))
            println(FindMaximumXOR().findMaximumXOR(intArrayOf(8, 10, 2)))
        }
    }

    // 输入：nums = [3,10,5,25,2,8]
    // 输出：28
    // 解释：最大运算结果是 5 XOR 25 = 28.
    fun findMaximumXOR(nums: IntArray): Int {
        var x = 0
        for (k in 30 downTo 0) {
            val seen = hashSetOf<Int>()
            for (num in nums) {
                seen.add(num.shr(k))
            }

            val xNext = x * 2 + 1
            var found = false

            for (num in nums) {
                if (seen.contains(xNext.xor(num.shr(k)))) {
                    found = true
                    break
                }
            }

            x = if (found) {
                xNext
            } else {
                xNext - 1
            }
        }
        return x
    }
}