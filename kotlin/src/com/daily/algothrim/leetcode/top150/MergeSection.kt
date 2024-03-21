package com.daily.algothrim.leetcode.top150

import kotlin.math.max

/**
 * 56. 合并区间
 */

/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。



示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

class MergeSection {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MergeSection().merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                )
            ).forEach {
                println("[${it[0]}, ${it[1]}]")
            }
            println()
            MergeSection().merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(4, 5),
                )
            ).forEach {
                println("[${it[0]}, ${it[1]}]")
            }
            println()
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { o1, o2 ->
            o1[0] - o2[0]
        }
        val result = arrayListOf<IntArray>()
        for (item in intervals) {
            val start = item[0]
            val end = item[1]
            if (result.isEmpty() || result[result.size - 1][1] < start) {
                result.add(intArrayOf(start, end))
            } else {
                result[result.size - 1][1] = max(result[result.size - 1][1], end)
            }
        }
        return result.toTypedArray()
    }
}