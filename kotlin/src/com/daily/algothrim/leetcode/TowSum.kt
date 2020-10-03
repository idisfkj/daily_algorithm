package com.daily.algothrim.leetcode

/**
 * 两数之和
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class TowSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TowSum().solution(intArrayOf(2, 7, 11, 15), 9).forEach {
                println(it)
            }
        }
    }

    /**
     * O(n)
     */
    fun solution(num: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        val map = hashMapOf<Int, Int>()

        num.forEachIndexed { index, i ->
            if (map.containsKey(i)) {
                map[i]?.let {
                    return intArrayOf(it, index)
                }
            }
            map[target - i] = index
        }
        return result
    }
}