package com.daily.algothrim.leetcode

import kotlin.math.abs

/**
 * 1584. 连接所有点的最小费用
 *
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * */
class MinCostConnectPoints {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
            // 输出：20
            println(MinCostConnectPoints().solution(arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 2),
                    intArrayOf(3, 10),
                    intArrayOf(5, 2),
                    intArrayOf(7, 0)
            )))
            // 输入：points = [[3,12],[-2,5],[-4,1]]
            // 输出：18
            println(MinCostConnectPoints().solution(arrayOf(
                    intArrayOf(3, 12),
                    intArrayOf(-2, 5),
                    intArrayOf(-4, 1)
            )))
        }
    }

    fun solution(points: Array<IntArray>): Int {
        val n = points.size
        var result = 0
        val edgeList = arrayListOf<Edge>()
        val union = DisJoinSetUnion(n)
        var i = 0
        while (i < n) {
            var j = i + 1
            while (j < n) {
                edgeList.add(Edge(dis(points[i], points[j]), i, j))
                j++
            }
            i++
        }

        // 贪心
        edgeList.sortWith(Comparator { o1, o2 ->
            o1.len - o2.len
        })

        var count = 1
        for (edge in edgeList) {
            if (union.setUnion(edge.x, edge.y)) {
                result += edge.len
                count++
                if (count == n) {
                    break
                }
            }
        }

        return result
    }

    private fun dis(pointA: IntArray, pointB: IntArray): Int {
        return abs(pointA[0] - pointB[0]) + abs(pointA[1] - pointB[1])
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

        private fun find(index: Int): Int = if (parent[index] == index) index else find(parent[index])

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

    }

    data class Edge(val len: Int, val x: Int, val y: Int)
}