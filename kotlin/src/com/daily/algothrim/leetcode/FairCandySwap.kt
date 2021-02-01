package com.daily.algothrim.leetcode

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 */
class FairCandySwap {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            FairCandySwap().solution(intArrayOf(1, 1), intArrayOf(2, 2)).forEach {
                println(it)
            }
        }

    }

    // 输入：A = [1,1], B = [2,2]
    // 输出：[1,2]
    // O(m+n)
    // O(m)
    fun solution(A: IntArray, B: IntArray): IntArray {
        val map = HashSet<Int>()
        var sumA = 0
        var sumB = 0
        val result = IntArray(2)

        for (a in A) {
            sumA += a
            map.add(a)
        }

        for (b in B) {
            sumB += b
        }

        val sub = (sumA - sumB) / 2

        for (b in B) {
            val a = b + sub
            if (map.contains(a)) {
                result[0] = a
                result[1] = b
                break
            }
        }

        return result
    }
}