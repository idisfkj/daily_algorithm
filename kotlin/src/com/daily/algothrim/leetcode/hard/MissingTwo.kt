package com.daily.algothrim.leetcode.hard

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 *
 * 提示：
 * nums.length <= 30000
 */
class MissingTwo {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MissingTwo().missingTwo(intArrayOf(1)).apply {
                println("${this[0]} ${this[1]}")
            }
            MissingTwo().missingTwo(intArrayOf(2, 3)).apply {
                println("${this[0]} ${this[1]}")
            }
            println("${2.xor(-2)}")
        }
    }

    fun missingTwo(nums: IntArray): IntArray {
        var xor = 0

        // n - 2
        for (i in nums) {
            xor = xor.xor(i)
        }
        val n = nums.size + 2
        // n
        for (i in 1 .. n) {
            xor = xor.xor(i)
        }

        val lsb = xor.and(-xor)

        var value1 = 0
        var value2 = 0
        // n - 2
        for (i in nums) {
            if (lsb.and(i) != 0) {
                value1 = value1.xor(i)
            } else {
                value2 = value2.xor(i)
            }
        }

        // n
        for (i in 1..n) {
            if (lsb.and(i) != 0) {
                value1 = value1.xor(i)
            } else {
                value2 = value2.xor(i)
            }
        }

        return intArrayOf(value1, value2)
    }
}