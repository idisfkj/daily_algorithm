package com.daily.algothrim.leetcode.top150

/**
 * 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
class PermuteUnique {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PermuteUnique().permuteUnique(
                intArrayOf(1, 1, 2)
            ).forEach {
                println("$it")
            }
        }
    }

    private val result = arrayListOf<List<Int>>()
    private val temp = arrayListOf<Int>()
    private var size = 0

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        size = nums.size
        if (size == 0) return result
        nums.sort()
        val visits = BooleanArray(size)
        backtrace(nums, visits, 0)
        return result
    }

    /**
     * O(n * n!)
     * O(n)
     */
    private fun backtrace(nums: IntArray, visits: BooleanArray, index: Int) {
        if (index == size) {
            result.add(ArrayList(temp))
            return
        }
        for (i in 0 until size) {
            if (visits[i] || (i > 0 && nums[i] == nums[i - 1] && !visits[i - 1])) {
                continue
            }
            visits[i] = true
            temp.add(nums[i])
            backtrace(nums, visits, index + 1)
            visits[i] = false
            temp.removeLast()
        }
    }
}