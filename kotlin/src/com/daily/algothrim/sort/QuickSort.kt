package com.daily.algothrim.sort

/**
 * 快速排序
 * 不稳定排序
 * 原地排序
 */
class QuickSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            QuickSort().quick(a, 0, a.size - 1)
            a.forEach {
                println(it)
            }
        }
    }

    /**
     * 时间复制度O(nlog n); 最好时间复杂度O(nlog n); 最坏时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    private fun quick(a: IntArray, start: Int, end: Int) {
        if (start < end) {
            // 找到分区位置
            val mid = sort(a, start, end)
            // 分区
            quick(a, start, mid - 1)
            quick(a, mid + 1, end)
        }
    }

    private fun sort(a: IntArray, start: Int, end: Int): Int {
        val pivot = a[end]
        var i = start
        var j = start

        while (j < end) {
            if (a[j] < pivot) {
                val temp = a[i]
                a[i] = a[j]
                a[j] = temp
                i++
            }
            j++
        }

        val temp = a[i]
        a[i] = pivot
        a[end] = temp

        return i
    }
}