package com.daily.algothrim.leetcode

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */
class CountTriplets {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CountTriplets().countTriplets(intArrayOf(2, 3, 1, 6, 7)))
            println(CountTriplets().countTriplets(intArrayOf(1, 1, 1, 1, 1)))
            println(CountTriplets().countTriplets(intArrayOf(2, 3)))
            println(CountTriplets().countTriplets(intArrayOf(1, 3, 5, 7, 9)))
            println(CountTriplets().countTriplets(intArrayOf(7, 11, 12, 9, 5, 2, 7, 17, 22)))
        }
    }

    // a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
    // b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
    // 输入：arr = [2,3,1,6,7]
    // 输出：4
    // 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
    fun countTriplets(arr: IntArray): Int {
        val xors = hashMapOf<Int, Int>()
        val count = hashMapOf<Int, Int>()
        var temp = 0
        var result = 0
        arr.forEachIndexed { index, i ->
            if (xors.containsKey(temp.xor(i))) {
                result += (xors[temp.xor(i)] ?: 0) * index - (count[temp.xor(i)] ?: 0)
            }
            xors[temp] = (xors[temp] ?: 0) + 1
            count[temp] = (count[temp] ?: 0) + index
            temp = temp.xor(i)
        }
        return result
    }
}