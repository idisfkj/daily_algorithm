package com.daily.algothrim.leetcode.medium

/**
 * 18. 四数之和
 */
class FourSum {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            FourSum().fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).forEach {
                it.forEach { i ->
                    print(i)
                }
                println()
            }
            FourSum().fourSum(intArrayOf(2,2,2,2,2), 8).forEach {
                it.forEach { i ->
                    print(i)
                }
                println()
            }
            FourSum().fourSum(intArrayOf(0,0,0,1000000000,1000000000,1000000000,1000000000), 1000000000).forEach {
                it.forEach { i ->
                    print(i)
                }
                println()
            }
        }
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        val size = nums.size

        if (size < 4) return result

        nums.sort()
        for (i in 0 until size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            if (nums[i].toLong() + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break
            if (nums[i].toLong() + nums[size - 3] + nums[size - 2] + nums[size - 1] < target) continue

            for (j in i + 1 until size - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                if (nums[i].toLong() + nums[j] + nums[j + 1] + nums[j + 2] > target) break
                if (nums[i].toLong() + nums[j] + nums[size - 2] + nums[size - 1] < target) continue

                var l = j + 1
                var r = size - 1
                while (l < r) {
                    val sum = nums[i].toLong() + nums[j] + nums[l] + nums[r]
                    if (sum == target.toLong()) {
                        result.add(arrayListOf(nums[i], nums[j], nums[l], nums[r]))
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++
                        }
                        l++
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--
                        }
                        r--
                    } else if (sum < target) {
                        l++
                    } else {
                        r--
                    }
                }
            }
        }
        return result
    }

}