package com.daily.algothrim.leetcode.top150

import kotlin.math.max

/**
 * 55. 跳跃游戏
 */

/*
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。



示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


提示：

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
class CanJump {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanJump().canJump(intArrayOf(2, 3, 1, 1, 4)))
            println(CanJump().canJump(intArrayOf(3, 2, 1, 0, 4)))
            println(CanJump().canJump(intArrayOf(1, 13, 1, 1, 4)))
        }
    }

    fun canJump(nums: IntArray): Boolean {
        var k = 0
        for (i in nums.indices) {
            if (i > k) return false
            k = max(k, i + nums[i])
        }
        return true
    }
}