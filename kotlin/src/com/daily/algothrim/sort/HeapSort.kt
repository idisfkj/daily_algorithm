package com.daily.algothrim.sort

/**
 * 堆排序
 * 不稳定排序(存在不相邻交换数据)
 * 原地排序
 *
 * 数据交换次数比快速排序多，但排序时间复杂度相对稳定。
 * 堆使用数组存储是间隔的，所以对于cpu缓存不友好
 */
class HeapSort {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // -1为占位符, 堆下标从1开始
            val a = intArrayOf(-1, 1, 5, 6, 2, 4, 93, 289, 534, 2, 3)
            HeapSort().sort(a, a.size)
            a.forEach {
                println(it)
            }
        }
    }


    /**
     * O(nlog n)
     */
    fun sort(a: IntArray, n: Int) {
        // 建堆
        buildHeap(a, n)
        var k = n - 1

        // 排序
        while (k > 1) {
            swap(a, 1, k)
            // 堆化
            heapify(a, 1, --k)
        }

    }


    /**
     * O(n)
     */
    private fun buildHeap(a: IntArray, n: Int) {
        var i = n / 2
        while (i >= 1) {
            heapify(a, i--, n)
        }
    }

    /**
     * O(log n)
     */
    private fun heapify(a: IntArray, pos: Int, n: Int) {
        var i = pos
        while (true) {
            var j = i
            if (2 * i < n && a[j] < a[2 * i]) j = 2 * i
            if (2 * i + 1 < n && a[j] < a[2 * i + 1]) j = 2 * i + 1
            if (j == i) break
            swap(a, i, j)
            i = j
        }
    }

    private fun swap(a: IntArray, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

}