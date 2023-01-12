package com.daily.algothrim.leetcode.medium

/**
 * 47. 全排列 II
 */
class PermuteUnique {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            PermuteUnique().permuteUnique(intArrayOf(1,1,2)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
            PermuteUnique().permuteUnique(intArrayOf(2,2,1,1)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
        }
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val size = nums.size
        val visits = BooleanArray(size)
        val ans = arrayListOf<List<Int>>()
        val perm = ArrayList<Int>()

        nums.sort()
        backtrack(nums, 0, ans, perm, visits)
        return ans
    }

    private fun backtrack(
        nums: IntArray,
        index: Int,
        ans: ArrayList<List<Int>>,
        perm: ArrayList<Int>,
        visits: BooleanArray
    ) {
        if (index == nums.size) {
            ans.add(ArrayList(perm))
            return
        }
        for (i in nums.indices) {
            if (visits[i] || (i > 0 && nums[i] == nums[i - 1] && !visits[i - 1])) {
                continue
            }
            perm.add(nums[i])
            visits[i] = true
            backtrack(nums, index + 1, ans, perm, visits)
            visits[i] = false
            perm.removeLast()
        }
    }
}