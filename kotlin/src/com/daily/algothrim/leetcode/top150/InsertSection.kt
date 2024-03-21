package com.daily.algothrim.leetcode.top150

import kotlin.math.max
import kotlin.math.min

/**
 * 57. 插入区间
 */

/*
给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。

在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。

返回插入之后的 intervals。

注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。



示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。


提示：

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals 根据 starti 按 升序 排列
newInterval.length == 2
0 <= start <= end <= 105
 */
class InsertSection {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            InsertSection().insert(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9)
                ), intArrayOf(2, 5)
            ).forEach {
                println("[${it[0]}, ${it[1]}]")
            }
            println()
            InsertSection().insert(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16),
                ), intArrayOf(4, 8)
            ).forEach {
                println("[${it[0]}, ${it[1]}]")
            }
        }
    }

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = arrayListOf<IntArray>()
        var inserted = false

        for (item in intervals) {
            // 插入左侧无交集
            if (item[1] < newInterval[0]) {
                result.add(item)
            } else if (item[0] > newInterval[1]) {
                // 插入右侧无交集
                if (!inserted) {
                    result.add(newInterval)
                    inserted = true
                }
                result.add(item)
            } else {
                // 有交集
                if (!inserted) {
                    result.add(intArrayOf(min(item[0], newInterval[0]), max(item[1], newInterval[1])))
                    inserted = true
                }
                result[result.size - 1][1] = max(result[result.size - 1][1], item[1])
            }
        }
        if (!inserted) {
            result.add(newInterval)
        }
        return result.toTypedArray()
    }
}