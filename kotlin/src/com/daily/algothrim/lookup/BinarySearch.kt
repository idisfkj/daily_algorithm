package com.daily.algothrim.lookup

/**
 * 二分查找
 */
class BinarySearch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(1, 2, 4, 5, 6, 9, 29, 93, 95, 213, 741)
            println(BinarySearch().search(a, a.size, 93))
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
                a[mid] < value -> {
                    low = mid + 1
                }
                a[mid] > value -> {
                    high = mid - 1
                }
                else -> {
                    return mid
                }
            }
        }
        return -1
    }
}