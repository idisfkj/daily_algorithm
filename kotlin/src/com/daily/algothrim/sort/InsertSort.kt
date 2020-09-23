package com.daily.algothrim.sort

/**
 * 插入排序
 * 原地排序
 * 稳定排序
 */
class InsertSort {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            InsertSort().sort(a, a.size)
            a.forEach {
                println(it)
            }
        }
    }

    /**
     * O(n2)
     */
    fun sort(a: IntArray, n: Int) {
        var i = 1
        while (i < n) {
            var j = i - 1
            val value = a[i]
            while (j >= 0) {
                if (value < a[j]) {
                    a[j + 1] = a[j]
                } else {
                    break
                }
                j--
            }
            a[j + 1] = value
            i++
        }
    }
}