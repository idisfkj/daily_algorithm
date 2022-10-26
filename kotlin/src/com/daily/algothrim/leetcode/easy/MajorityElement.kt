package com.daily.algothrim.leetcode.easy

/**
 * 169. 多数元素
 */
class MajorityElement {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MajorityElement().majorityElement(intArrayOf(3, 2, 3)))
            println(MajorityElement().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
        }
    }

    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }
}