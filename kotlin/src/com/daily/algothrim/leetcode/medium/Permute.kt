package com.daily.algothrim.leetcode.medium

import java.util.*
import kotlin.collections.ArrayList

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
    private val result = ArrayList<List<Int>>()
    private val temp = arrayListOf<Int>()
    private var size = 0
    fun permute(nums: IntArray): List<List<Int>> {
        size = nums.size
        if (size == 0) return result
        for (i in 0 until size) {
            temp.add(nums[i])
        }
        backtrack(nums, 0)
        return result
    }

    private fun backtrack(nums: IntArray, index: Int) {
        if (index == size) {
            result.add(ArrayList(temp))
            return
        }
        for (i in index until size) {
            Collections.swap(temp, i, index)
            backtrack(nums, index + 1)
            Collections.swap(temp, i, index)
        }

    }

}