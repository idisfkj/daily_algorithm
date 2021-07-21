package com.daily.algothrim.leetcode.medium

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
class Merge {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Merge().merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))).forEach {
                println("${it[0]}, ${it[1]}")
            }
            Merge().merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 4))).forEach {
                println("${it[0]}, ${it[1]}")
            }
        }
    }

    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    // 输出：[[1,6],[8,10],[15,18]]
    // 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(Comparator { o1, o2 -> (o1?.get(0) ?: 0) - (o2?.get(0) ?: 0) })

        val result = arrayListOf<IntArray>()
        intervals.forEach {
            val start = it[0]
            val end = it[1]
            if (result.isEmpty() || result[result.size - 1][1] < start) {
                result.add(intArrayOf(start, end))
            } else {
                result[result.size - 1][1] = Math.max(result[result.size - 1][1], end)
            }
        }
        return result.toTypedArray()
    }
}