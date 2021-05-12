package com.daily.algothrim.leetcode

/**
 * 1310. 子数组异或查询
 *
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 */
class XorQueries {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            XorQueries().xorQueries(intArrayOf(1,3,4,8), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3))).apply {
                forEach {
                    println(it)
                }
            }
        }
    }

    //输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
    //输出：[2,7,14,8]
    //解释：
    //数组中元素的二进制表示形式是：
    //1 = 0001
    //3 = 0011
    //4 = 0100
    //8 = 1000
    //查询的 XOR 值为：
    //[0,1] = 1 xor 3 = 2
    //[1,2] = 3 xor 4 = 7
    //[0,3] = 1 xor 3 xor 4 xor 8 = 14
    //[3,3] = 8
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val querySize = queries.size
        val arrSize = arr.size
        val result = IntArray(querySize)

        val xorIteration = IntArray(arrSize + 1)
        for (i in 0 until arrSize) {
            xorIteration[i + 1] = xorIteration[i].xor(arr[i])
        }

        for (i in 0 until querySize) {
            result[i] = xorIteration[queries[i][0]].xor(xorIteration[queries[i][1] + 1])
        }

        return result
    }
}