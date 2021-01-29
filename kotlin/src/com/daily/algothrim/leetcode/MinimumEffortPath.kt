package com.daily.algothrim.leetcode

import kotlin.math.abs

/**
 * 1631. 最小体力消耗路径
 *
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * */
class MinimumEffortPath {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinimumEffortPath().solution(arrayOf(
                    intArrayOf(1, 2, 2),
                    intArrayOf(3, 8, 2),
                    intArrayOf(5, 3, 5)
            )))
        }
    }

    // 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
    // 输出：2
    // 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
    // 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
    /**
     * O(nm log nm)
     * O(nm)
     */
    fun solution(heights: Array<IntArray>): Int {
        val rSize = heights.size
        val cSize = heights[0].size

        val edges = arrayListOf<Edge>()

        // 构建边，并统计边的权重
        for (i in 0 until rSize) {
            for (j in 0 until cSize) {
                val index = i * cSize + j
                if (i > 0) {
                    edges.add(Edge(abs(heights[i][j] - heights[i - 1][j]), index - cSize, index))
                }
                if (j > 0) {
                    edges.add(Edge(abs(heights[i][j] - heights[i][j - 1]), index - 1, index))
                }
            }
        }

        // 排序
        edges.sortWith(Comparator { o1, o2 ->
            o1.len - o2.len
        })

        val unionFound = DisJoinSetUnion(rSize * cSize)
        var result = 0

        for (edge in edges) {
            // 合并
            unionFound.setUnion(edge.x, edge.y)
            // 判断是否连通
            if (unionFound.isConnected(0, rSize * cSize - 1)) {
                result = edge.len
                break
            }
        }

        return result
    }

    // 并查集
    class DisJoinSetUnion(n: Int) {
        private val parent: IntArray = IntArray(n)
        private val rank: IntArray = IntArray(n)

        init {
            var i = 0
            while (i < n) {
                parent[i] = i
                rank[i] = 1
                i++
            }
        }

        private fun find(index: Int): Int = if (parent[index] == index) index else {
            parent[index] = find(parent[index])
            find(parent[index])
        }

        fun setUnion(x: Int, y: Int): Boolean {
            var pX = find(x)
            var pY = find(y)

            if (pX == pY) return false

            if (rank[pX] < rank[pY]) {
                val temp = pX
                pX = pY
                pY = temp
            }
            // y 合并到 x
            rank[pX] += rank[pY]
            parent[pY] = pX
            return true
        }

        fun isConnected(x: Int, y: Int): Boolean = find(x) == find(y)

    }

    data class Edge(val len: Int, val x: Int, val y: Int)
}