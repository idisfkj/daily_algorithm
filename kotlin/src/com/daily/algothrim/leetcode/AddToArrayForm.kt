package com.daily.algothrim.leetcode

import kotlin.math.pow

/**
 * 989. 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * */
class AddToArrayForm {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(AddToArrayForm().solution(intArrayOf(1, 2, 0, 0), 34))
//            println(AddToArrayForm().solution(intArrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9), 1))
            println(AddToArrayForm().solution2(intArrayOf(1, 2, 0, 0), 34))
            println(AddToArrayForm().solution2(intArrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9), 1))
        }
    }

    // 输入：A = [1,2,0,0], K = 34
    // 输出：[1,2,3,4]
    // 解释：1200 + 34 = 1234
    // 这种方式会超出int、long类型边界
    fun solution(A: IntArray, K: Int): List<Int> {
        val result = mutableListOf<Int>()
        val n = A.size
        var i = n
        var num = 0

        while (--i >= 0) {
            num += A[i].times(10f.pow(n - i - 1)).toInt()
        }
        num += K

        num.toString().forEach {
            result.add(it - '0')
        }

        return result
    }

    /**
     * O(max(A.size, logK))
     */
    fun solution2(A: IntArray, K: Int): List<Int> {
        val result = mutableListOf<Int>()
        val n = A.size
        var i = n
        var sum: Int
        var k = K

        // 从低向高位
        while (--i >= 0) {
            // 取当前位数值
            val curr = k % 10
            // 求和
            sum = curr + A[i]
            // 剩余位数数值
            k /= 10
            // 进位
            if (sum >= 10) {
                sum %= 10
                k++
            }
            result.add(sum)
        }

        // k有剩余
        while (k > 0) {
            result.add(k % 10)
            k /= 10
        }

        return result.reversed()
    }
}