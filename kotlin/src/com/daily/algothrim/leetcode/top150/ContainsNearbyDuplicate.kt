package com.daily.algothrim.leetcode.top150

/**
 * 219. 存在重复元素 II
 */

/*
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。



示例 1：

输入：nums = [1,2,3,1], k = 3
输出：true
示例 2：

输入：nums = [1,0,1,1], k = 1
输出：true
示例 3：

输入：nums = [1,2,3,1,2,3], k = 2
输出：false




提示：

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
class ContainsNearbyDuplicate {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ContainsNearbyDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate2(intArrayOf(1, 2, 3, 1), 3))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate2(intArrayOf(1, 0, 1, 1), 1))
            println(ContainsNearbyDuplicate().containsNearbyDuplicate2(intArrayOf(1, 2, 3, 1, 2, 3), 2))
        }
    }

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val index = map.getOrDefault(nums[i], 0)
                if (i - index <= k) return true
                map.remove(nums[i])
            }
            map[nums[i]] = i
        }
        return false
    }

    fun containsNearbyDuplicate2(nums: IntArray, k: Int): Boolean {
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