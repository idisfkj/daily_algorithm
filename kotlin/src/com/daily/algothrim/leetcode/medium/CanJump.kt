package com.daily.algothrim.leetcode.medium

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 
 */
class CanJump {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanJump().canJump(intArrayOf(2, 3, 1, 1, 5)))
            println(CanJump().canJump(intArrayOf(3, 2, 1, 0, 4)))
            println(CanJump().canJump2(intArrayOf(2, 3, 1, 1, 5)))
            println(CanJump().canJump2(intArrayOf(3, 2, 1, 0, 4)))
        }
    }

    fun canJump(nums: IntArray): Boolean {
        val size = nums.size

        var i = size - 2
        nums[size - 1] = -1
        while (i >= 0) {
            var step = nums[i]
            while (step >= 0) {
                if (i + step < size && nums[i + step] == -1) {
                    nums[i] = -1
                    break
                }
                step--
            }
            i--
        }
        return nums[0] == -1
    }

    /**
     * greed
     */
    fun canJump2(nums: IntArray): Boolean {
        val size = nums.size
        var maxJump = 0
        var i = 0
        while (i < size) {
            if (i <= maxJump) {
                maxJump = Math.max(i + nums[i], maxJump)
                if (maxJump >= size - 1) {
                    return true
                }
            }
            i++
        }
        return false
    }
}