package com.daily.algothrim.leetcode.medium

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
class SortColors {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2, 0, 2, 1, 1, 0)
            SortColors().sortColors(nums)
            nums.forEach {
                println(it)
            }
            val nums1 = intArrayOf(2, 0, 2, 1, 1, 0)
            SortColors().sortColors2(nums1)
            nums1.forEach {
                println(it)
            }
        }
    }

    fun sortColors(nums: IntArray) {
        val bucket = IntArray(3)

        nums.forEach {
            bucket[it]++
        }

        var start = 0
        bucket.forEachIndexed { index, i ->
            nums.fill(index, start, start + i)
            start += i
        }
    }

    fun sortColors2(nums: IntArray) {
        var p0 = 0
        var p1 = 0

        for (i in 0 until nums.size) {
            if (nums[i] == 1) {
                val temp = nums[i]
                nums[i] = nums[p1]
                nums[p1] = temp
                p1++
            } else if (nums[i] == 0) {
                var temp = nums[i]
                nums[i] = nums[p0]
                nums[p0] = temp
                if (p0 < p1) {
                    temp = nums[i]
                    nums[i] = nums[p1]
                    nums[p1] = temp
                }
                p0++
                p1++
            }
        }
    }
}