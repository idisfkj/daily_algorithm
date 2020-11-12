package com.daily.algothrim.leetcode

/**
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * */
class SortArrayByParityII {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SortArrayByParityII().solution(intArrayOf(4, 2, 5, 7)).forEach {
                println(it)
            }
        }
    }

    fun solution(A: IntArray): IntArray {
        var evenIndex = 0
        var oddIndex = 1

        while (evenIndex < A.size) {
            // 索引为偶数值为奇数
            if (A[evenIndex] % 2 != 0) {
                while (oddIndex < A.size) {
                    // 索引为奇数值为偶数
                    if (A[oddIndex] % 2 == 0) {
                        val temp = A[evenIndex]
                        A[evenIndex] = A[oddIndex]
                        A[oddIndex] = temp
                        break
                    }
                    oddIndex += 2
                }
            }
            evenIndex += 2
        }

        return A
    }
}