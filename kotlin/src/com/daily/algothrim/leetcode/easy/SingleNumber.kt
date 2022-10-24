package com.daily.algothrim.leetcode.easy

/**
 * 136. 只出现一次的数字
 */
class SingleNumber {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SingleNumber().singleNumber(intArrayOf(2, 2, 1)))
            println(SingleNumber().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
        }
    }

    fun singleNumber(nums: IntArray): Int {
        var result = 0
        nums.forEach {
            result = result.xor(it)
        }
        return result
    }

}