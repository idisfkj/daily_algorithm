package com.daily.algothrim.leetcode

/**
 * 376. 摆动序列
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * */
class WiggleMaxLength {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(WiggleMaxLength().solution(intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)))
            println(WiggleMaxLength().solution(intArrayOf(1, 7, 4, 9, 2, 5)))
            println(WiggleMaxLength().solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))

            println()

            println(WiggleMaxLength().solution2(intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)))
            println(WiggleMaxLength().solution2(intArrayOf(1, 7, 4, 9, 2, 5)))
            println(WiggleMaxLength().solution2(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
        }
    }

    // 输入: [1,17,5,10,13,15,10,5,16,8]
    // 输出: 7
    fun solution(nums: IntArray): Int {
        var max = 0
        nums.forEachIndexed { index, _ ->
            var n = 1
            var k = index + 1
            var sign = 0
            while (k < nums.size) {
                val sub = nums[k] - nums[k - 1]
                k++
                if (sub * sign < 0 || (sign == 0 && sub != 0)) {
                    n++
                    sign = sub
                } else {
                    continue
                }
            }
            if (max < n) max = n
        }

        return max
    }

    // 心电图或者峰谷
    // 累加相邻峰谷交错数量
    fun solution2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var result = 1
        var sign = 0
        var i = 1

        while (i < nums.size) {
            val sub = nums[i] - nums[i - 1]
            if (sub * sign < 0 || (sign == 0 && sub != 0)) {
                result++
            }
            // 防止中间出现0，导致上面if判断对0的情况+1
            if (sub != 0) sign = sub
            i++
        }

        return result
    }


}