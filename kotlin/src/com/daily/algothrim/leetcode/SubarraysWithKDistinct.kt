package com.daily.algothrim.leetcode

/**
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 */
class SubarraysWithKDistinct {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SubarraysWithKDistinct().solution(intArrayOf(1, 2, 1, 2, 3), 2))
        }
    }

    // 输入：A = [1,2,1,2,3], K = 2
    // 输出：7
    // 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
    fun solution(A: IntArray, K: Int): Int {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1)
    }

    private fun atMostKDistinct(A: IntArray, K: Int): Int {
        val size = A.size

        var left = 0
        var right = 0

        var count = 0
        var result = 0

        val freg = IntArray(size + 1)

        while (right < size) {
            if (freg[A[right]] == 0) {
                count++
            }
            freg[A[right]]++
            right++

            while (count > K) {
                freg[A[left]]--
                if (freg[A[left]] == 0) {
                    count--
                }
                left++
            }
            result += right - left
        }
        return result
    }
}