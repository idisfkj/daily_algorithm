package com.daily.algothrim.leetcode

import java.util.*

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * */
class AllCellsDistOrder {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            AllCellsDistOrder().solution(2, 3, 1, 2).forEach {
                println("[${it[0]}, ${it[1]}]")
            }
        }
    }

    // 图的广度优先搜索
    // 或者桶排序？？桶的大小为最大曼哈顿距离
    fun solution(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val result = Array(R * C) { IntArray(2) }
        val visited = BooleanArray(R * C)
        val deque = ArrayDeque<IntArray>()
        deque.offer(intArrayOf(r0, c0))
        visited[r0 * C + c0] = true
        var index = 0

        while (deque.isNotEmpty()) {
            val cur = deque.poll()
            result[index++] = cur

            if (cur[0] - 1 >= 0 && !visited[(cur[0] - 1) * C + cur[1]]) {
                deque.offer(intArrayOf(cur[0] - 1, cur[1]))
                visited[(cur[0] - 1) * C + cur[1]] = true
            }

            if (cur[1] - 1 >= 0 && !visited[cur[0] * C + cur[1] - 1]) {
                deque.offer(intArrayOf(cur[0], cur[1] - 1))
                visited[cur[0] * C + cur[1] - 1] = true
            }

            if (cur[0] + 1 < R && !visited[(cur[0] + 1) * C + cur[1]]) {
                deque.offer(intArrayOf(cur[0] + 1, cur[1]))
                visited[(cur[0] + 1) * C + cur[1]] = true
            }

            if (cur[1] + 1 < C && !visited[cur[0] * C + cur[1] + 1]) {
                deque.offer(intArrayOf(cur[0], cur[1] + 1))
                visited[cur[0] * C + cur[1] + 1] = true
            }
        }

        return result
    }

}