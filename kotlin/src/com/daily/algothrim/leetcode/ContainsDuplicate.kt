package com.daily.algothrim.leetcode

/**
 * 217. 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * */
class ContainsDuplicate {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ContainsDuplicate().solution(intArrayOf(1, 2, 3, 1)))
            println(ContainsDuplicate().solution(intArrayOf(1, 2, 3, 4)))
            println(ContainsDuplicate().solution(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
        }
    }

    // 时间：O(n)
    // 空间：O(n)
    fun solution(nums: IntArray): Boolean {
        val map = hashMapOf<Int, Boolean>()
        nums.forEach {
            if (map[it] != null) return true
            map[it] = true
        }
        return false
    }
}