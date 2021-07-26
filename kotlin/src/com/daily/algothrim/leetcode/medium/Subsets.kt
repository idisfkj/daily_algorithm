package com.daily.algothrim.leetcode.medium

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
class Subsets {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Subsets().subsets(intArrayOf(1, 2, 3)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
            Subsets().subsets(intArrayOf(0)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
        }
    }

    // 输入：nums = [1,2,3]
    // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        backtracking(nums, 0, arrayListOf(), result)
        return result
    }

    private fun backtracking(nums: IntArray, index: Int, subList: ArrayList<Int>, result: ArrayList<List<Int>>) {
        if (index == nums.size) {
            result.add(ArrayList(subList))
            return
        }

        backtracking(nums, index + 1, subList, result)

        subList.add(nums[index])
        backtracking(nums, index + 1, subList, result)
        subList.removeAt(subList.size - 1)
    }
}