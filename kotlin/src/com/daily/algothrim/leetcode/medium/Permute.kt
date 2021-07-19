package com.daily.algothrim.leetcode.medium

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
class Permute {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Permute().permute(intArrayOf(1, 2, 3)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
            Permute().permute(intArrayOf(0, 1)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
            Permute().permute(intArrayOf(1)).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
        }
    }

    // nums = [1,2,3]
    // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    fun permute(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        backtracking(nums, 0, arrayListOf(), result)
        return result
    }

    private fun backtracking(nums: IntArray, currentIndex: Int, subResult: ArrayList<Int>, resultList: ArrayList<List<Int>>) {
        if (subResult.size == nums.size) {
            resultList.add(ArrayList(subResult))
            return
        }

        subResult.add(nums[currentIndex])
        backtracking(nums, currentIndex + 1, subResult, resultList)
        subResult.removeAt(subResult.size - 1)
        var right = currentIndex + 1
        while (right < nums.size) {
            val temp = nums[right]
            nums[right] = nums[currentIndex]
            nums[currentIndex] = temp

            subResult.add(nums[currentIndex])
            backtracking(nums, currentIndex + 1, subResult, resultList)
            subResult.removeAt(subResult.size - 1)

            val tempReversal = nums[right]
            nums[right] = nums[currentIndex]
            nums[currentIndex] = tempReversal

            right++
        }

    }
}