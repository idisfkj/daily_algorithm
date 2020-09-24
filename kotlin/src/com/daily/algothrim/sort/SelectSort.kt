package com.daily.algothrim.sort

/**
 * 选择排序
 * 不稳定排序
 * 原地排序
 */
class SelectSort {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            SelectSort().sort(a, a.size)
            a.forEach {
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
            var j = i + 1
            var k = i
            var min = a[i]
            while (j < n) {
                if (a[j] < min) {
                    min = a[j]
                    k = j
                }
                j++
            }
            a[k] = a[i]
            a[i] = min
            i++
        }
    }
}