package com.daily.algothrim.lookup

/**
 * 二分查找最后一个小于等于给定的值
 */
class BinarySearchV4 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(1, 2, 4, 5, 6, 9, 29, 93, 93, 93, 95, 213, 741)
            println(BinarySearchV4().search(a, a.size, 93))
        }
    }

    /**
     * O(log n)
     */
    fun search(a: IntArray, n: Int, value: Int): Int {
        var low = 0
        var high = n - 1
        while (low <= high) {
            val mid = low + (high - low).shr(1)
            when {
                a[mid] <= value -> {
                    if (mid == n - 1 || a[mid + 1] > value) return mid
                    low = mid + 1
                }
                else -> {
                    high = mid - 1
                }
            }
        }

        return -1
    }
}