package com.daily.algothrim.leetcode

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * */
class SummaryRanges {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SummaryRanges().solution(intArrayOf(0, 1, 2, 4, 5, 7)).apply {
                forEach {
                    println(it)
                }
            }
            println()
            SummaryRanges().solution2(intArrayOf(0, 1, 2, 4, 5, 7)).apply {
                forEach {
                    println(it)
                }
            }
        }
    }

    // 0,1,2,4,5,7
    fun solution(nums: IntArray): List<String> {
        val list = arrayListOf<String>()
        var flag = false
        var start = 0
        var current = 0
        nums.forEach {
            when {
                !flag -> {
                    flag = true
                    start = it
                    current = start
                }
                current + 1 == it -> current = it
                else -> {
                    if (start == current) {
                        list.add("$start")
                    } else {
                        list.add("$start->$current")
                    }
                    start = it
                    current = it
                }
            }
        }

        if (flag) {
            if (start == current) {
                list.add("$start")
            } else {
                list.add("$start->$current")
            }
        }

        return list
    }

    fun solution2(nums: IntArray): List<String> {
        val list = arrayListOf<String>()
        var i = 0
        var j = 0
        val n = nums.size
        while (i < n) {
            if (i + 1 == n || nums[i + 1] != nums[i] + 1) {
                if (i == j) {
                    list.add("${nums[i]}")
                } else {
                    list.add("${nums[j]}->${nums[i]}")
                }
                j = i + 1
            }
            i++
        }
        return list
    }
}