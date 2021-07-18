package com.daily.algothrim.leetcode.medium

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */
class CombinationSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
            CombinationSum().combinationSum(intArrayOf(2, 3, 5), 8).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
        }
    }

    // 输入：candidates = [2,3,6,7], target = 7,
    // 所求解集为：
    // [
    //  [7],
    //  [2,2,3]
    // ]
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty()) return listOf()
        val result = arrayListOf<List<Int>>()
        backtracking(target, candidates, 0, arrayListOf(), result)
        return result
    }

    private fun backtracking(
        remind: Int,
        candidates: IntArray,
        index: Int,
        currentList: ArrayList<Int>,
        result: ArrayList<List<Int>>
    ) {
        if (remind == 0) {
            val subList = arrayListOf<Int>()
            subList.addAll(currentList)
            result.add(subList)
            return
        }
        if (remind < 0 || index >= candidates.size) return

        backtracking(remind, candidates, index + 1, currentList, result)
        currentList.add(candidates[index])
        backtracking(remind - candidates[index], candidates, index, currentList, result)
        currentList.removeAt(currentList.size - 1)
    }
}