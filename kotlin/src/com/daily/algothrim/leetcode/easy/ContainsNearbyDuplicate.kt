package com.daily.algothrim.leetcode.easy

/**
 * 219. 存在重复元素 II
 */
class ContainsNearbyDuplicate {

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            println(ContainsNearbyDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
        }
    }

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = hashSetOf<Int>()
        for (i in nums.indices) {
            if (i > k) {
                set.remove(nums[i - k - 1])
            }
            if (!set.add(nums[i])) {
                return true
            }
        }
        return false
    }
}