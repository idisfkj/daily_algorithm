package com.daily.algothrim.leetcode.medium

/**
 * 16. 最接近的三数之和
 */
class ThreeSumClosest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(ThreeSumClosest().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
            println(ThreeSumClosest().threeSumClosest(intArrayOf(0, 0, 0), 1))
        }
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        val size = nums.size
        var bestResult = Int.MAX_VALUE

        for (i in 0 until size) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var j = i + 1
            var k = size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == target) return target

                if (Math.abs(sum - target) < Math.abs(bestResult - target)) {
                    bestResult = sum
                }

                if (sum > target) {
                    k--
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--
                    }
                } else {
                    j++
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++
                    }
                }
            }
        }
        return bestResult
    }

}