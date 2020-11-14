package com.daily.algothrim.leetcode


/**
 * 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * */
class RelativeSortArray {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            RelativeSortArray().solution(intArrayOf(
                    2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19
            ), intArrayOf(
                    2, 1, 4, 3, 9, 6
            )).forEach {
                println(it)
            }
            println()
            RelativeSortArray().solution2(intArrayOf(
                    2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19
            ), intArrayOf(
                    2, 1, 4, 3, 9, 6
            )).forEach {
                println(it)
            }
        }
    }

    // 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    // 输出：[2,2,2,1,4,3,3,9,6,7,19]
    fun solution(arr1: IntArray, arr2: IntArray): IntArray {
        // 将arr2构建成散列表
        val rule = hashMapOf<Int, Int>()
        arr2.forEachIndexed { index, i ->
            rule[i] = index
        }

        // 快速排序
        quickSort(arr1, 0, arr1.size - 1, rule)

        return arr1
    }

    private fun quickSort(a: IntArray, start: Int, end: Int, rule: Map<Int, Int>) {
        if (start < end) {
            val mid = sort(a, start, end, rule)
            quickSort(a, start, mid - 1, rule)
            quickSort(a, mid + 1, end, rule)
        }
    }

    private fun sort(a: IntArray, start: Int, end: Int, rule: Map<Int, Int>): Int {
        val pivot = a[end]
        val pivotIndex = rule[pivot]

        var n = start
        var m = start

        while (n < end) {
            val curIndex = rule[a[n]]
            if (pivotIndex != null && curIndex != null) {
                if (curIndex < pivotIndex) {
                    if (n != m) {
                        swap(a, n, m)
                    }
                    m++
                }
            } else if (curIndex != null) {
                if (n != m) {
                    swap(a, n, m)
                }
                m++
            } else if (pivotIndex == null) {
                if (a[n] < pivot) {
                    if (n != m) {
                        swap(a, n, m)
                    }
                    m++
                }
            }
            n++
        }

        swap(a, m, end)

        return m
    }

    private fun swap(a: IntArray, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

    /**
     * 计数
     */
    fun solution2(arr1: IntArray, arr2: IntArray): IntArray {
        val result = IntArray(arr1.size)

        // 找到最大值
        var max = Int.MIN_VALUE
        arr1.forEach {
            if (max < it) max = it
        }

        // 构建计数容器
        val count = IntArray(max + 1)

        // 开始计数
        arr1.forEach {
            count[it] = count[it] + 1
        }

        // 优先排序arr2中的数据
        var j = 0
        arr2.forEach {
            var i = count[it]
            while (i-- > 0) {
                result[j++] = it
            }
            count[it] = 0
        }

        // 将排序剩余的
        count.forEachIndexed { index, i ->
            var k = i
            while (k-- > 0) {
                result[j++] = index
            }
        }

        return result
    }
}