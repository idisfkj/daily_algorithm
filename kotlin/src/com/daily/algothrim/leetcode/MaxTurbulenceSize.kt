package com.daily.algothrim.leetcode

/**
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 */
class MaxTurbulenceSize {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxTurbulenceSize().solution(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)))
            println(MaxTurbulenceSize().solution(intArrayOf(4, 8, 12, 16)))
            println(MaxTurbulenceSize().solution(intArrayOf(100)))
            println(MaxTurbulenceSize().solution(intArrayOf(9, 9)))
        }
    }

    // 输入：[9,4,2,10,7,8,8,1,9]
    // 输出：5
    // 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
    fun solution(arr: IntArray): Int {
        val size = arr.size
        if (size == 1) return 1

        var max = 0
        var temp = 1
        var i = 0
        var flag = false

        while (i < size - 1) {
            val sub = arr[i] - arr[i + 1]
            if (sub > 0 && !flag) {
                temp++
            } else if (sub < 0 && flag) {
                temp++
            } else {
                max = Math.max(max, temp)
                temp = if (sub != 0) 2 else 1
            }

            flag = sub > 0
            i++
        }

        max = Math.max(max, temp)
        return max
    }

}