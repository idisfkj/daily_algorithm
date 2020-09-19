package com.daily.algothrim.sort


/**
 * 归并排序
 */
class MergeSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(10, 1, 4, 2, 5, 643, 654, 234, 2)
            MergeSort().sort(a, 0, a.size - 1)
            a.forEach {
                println(it)
            }
        }
    }

    private fun sort(a: IntArray, start: Int, end: Int) {
        if (start < end) {
            val mid = (start + end) / 2
            // 分治递归
            sort(a, start, mid)
            sort(a, mid + 1, end)
            // 合并
            merge(a, start, end)
        }
    }

    private fun merge(a: IntArray, start: Int, end: Int) {
        val mid = (start + end) / 2
        var i = start
        var j = mid + 1
        var k = 0
        val temp = IntArray(end - start + 1)
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++]
            } else {
                temp[k++] = a[j++]
            }
        }

        // i有剩余
        while (i <= mid) {
            temp[k++] = a[i++]
        }

        // j有剩余
        while (j <= end) {
            temp[k++] = a[j++]
        }

        // 将temp转移到a中
        temp.forEachIndexed { index, item ->
            a[start + index] = item
        }
    }
}