package com.daily.algothrim.leetcode.top150

/**
 * 179. 最大数
 */

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。



示例 1：

输入：nums = [10,2]
输出："210"
示例 2：

输入：nums = [3,30,34,5,9]
输出："9534330"


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */

class LargestNumber {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LargestNumber().largestNumber(intArrayOf(10, 2)))
            println(LargestNumber().largestNumber(intArrayOf(3, 30, 34, 5, 9)))
            println(LargestNumber().largestNumber(intArrayOf(1000000000, 1000000000)))
        }
    }

    /**
     * O(nlognlogm) n 序列长度，m32位整数最大值
     * O(logn)
     */
    fun largestNumber(nums: IntArray): String {
        if (nums.isEmpty()) return ""
        val list = nums.sortedWith { x, y ->
            (y.toString() + x.toString()).compareTo((x.toString() + y.toString()))
        }
        if (list[0] == 0) return "0"
        return StringBuilder().apply {
            list.forEach {
                append(it)
            }
        }.toString()
    }
}