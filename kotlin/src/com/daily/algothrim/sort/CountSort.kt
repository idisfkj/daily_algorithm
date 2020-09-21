package com.daily.algothrim.sort

/**
 * 计数排序
 */
class CountSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(3, 2, 4, 3, 5, 3, 2, 1, 5, 0, 0, 4, 6)
            CountSort().sort(a, a.size)
            a.forEach {
                println(it)
            }
        }
    }

    /**
     * O(n)
     */
    fun sort(a: IntArray, n: Int) {
        // 找到数据范围
        var max = 0
        a.forEach {
            if (it > max) max = it
        }

        // 统计每个值的个数
        val c = IntArray(max + 1)
        a.forEach {
            c[it]++
        }

        // 每个值的个数求和
        for (i in 1 until max + 1) {
            c[i] = c[i] + c[i - 1]
        }

        //  排序到临时temp数组中
        var j = n - 1
        val temp = IntArray(n)
        while (j >= 0) {
            temp[c[a[j]] - 1] = a[j]
            c[a[j]]--
            j--
        }

        // 转移到a中
        temp.forEachIndexed { index, i ->
            a[index] = i
        }

    }
}