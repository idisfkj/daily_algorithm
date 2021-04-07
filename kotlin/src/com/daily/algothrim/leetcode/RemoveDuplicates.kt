package com.daily.algothrim.leetcode

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
class RemoveDuplicates {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                RemoveDuplicates().removeDuplicates(
                    intArrayOf(
                        1, 1, 1, 2, 2, 3
                    )
                )
            )
            println(
                RemoveDuplicates().removeDuplicates(
                    intArrayOf(
                        0, 0, 1, 1, 1, 2, 3, 3
                    )
                )
            )

            println(
                RemoveDuplicates().removeDuplicates2(
                    intArrayOf(
                        1, 1, 1, 2, 2, 3
                    )
                )
            )
            println(
                RemoveDuplicates().removeDuplicates2(
                    intArrayOf(
                        0, 0, 1, 1, 1, 2, 3, 3
                    )
                )
            )
        }
    }

    // 输入：nums = [1,1,1,2,2,3]
    // 输出：5, nums = [1,1,2,2,3]
    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        if (size <= 2) return size
        var slow = 0
        var fast = 1
        var index = 1
        var moreDouble = false
        while (fast < size) {
            if (nums[slow] == nums[fast] && !moreDouble) {
                moreDouble = true
                nums[index] = nums[fast]
                index++
            } else if (nums[slow] != nums[fast]) {
                moreDouble = false
                nums[index] = nums[fast]
                index++
            }
            fast++
            slow++
        }
        return index
    }

    fun removeDuplicates2(nums: IntArray): Int {
        val size = nums.size
        if (size <= 2) return size
        var slow = 2
        var fast = 2

        while (fast < size) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }

        return slow
    }
}