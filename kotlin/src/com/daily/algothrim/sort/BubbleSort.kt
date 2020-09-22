package com.daily.algothrim.sort

/**
 * 冒泡排序
 * 稳定排序
 * 原地排序
 */
class BubbleSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            BubbleSort().sort(a, a.size)
            a.forEach {
                println(it)
            }
            println()
            val b = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            BubbleSort().optSort(b, b.size)
            b.forEach {
                println(it)
            }
        }
    }

    /**
     * O(n2)
     */
    fun sort(a: IntArray, n: Int) {
        var i = 0
        while (i < n) {
            var j = 0
            while (j < n - 1 - i) {
                if (a[j] > a[j + 1]) {
                    val temp = a[j]
                    a[j] = a[j + 1]
                    a[j + 1] = temp
                }
                j++
            }
            i++
        }
    }

    fun optSort(a: IntArray, n: Int) {
        var i = 0
        while (i < n) {
            var j = 0
            var flag = false
            while (j < n - 1 - i) {
                if (a[j] > a[j + 1]) {
                    val temp = a[j]
                    a[j] = a[j + 1]
                    a[j + 1] = temp
                    flag = true
                }
                j++
            }
            if (!flag) break
            i++
        }
    }
}