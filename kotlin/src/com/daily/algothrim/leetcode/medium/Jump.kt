package com.daily.algothrim.leetcode.medium

/**
 * 45. 跳跃游戏 II
 */
class Jump {

    companion object {

        @JvmStatic
        fun main(array: Array<String>) {
            println(Jump().jump(intArrayOf(2,3,1,1,4)))
            println(Jump().jump(intArrayOf(2,3,0,1,4)))
        }
    }

    fun jump(nums: IntArray): Int {
        val size = nums.size

        var maxPosition = 0
        var end = 0
        var step = 0

        for (i in 0 until size - 1) {
            maxPosition = Math.max(maxPosition, i + nums[i])
            if (i == end) {
                end = maxPosition
                step++
            }
        }
        return step
    }
}