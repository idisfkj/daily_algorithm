package com.daily.algothrim.leetcode

/**
 * 1579. 保证图可完全遍历
 *
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 */
class MaxNumEdgesToRemove {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxNumEdgesToRemove().solution(4, arrayOf(
                    intArrayOf(3, 1, 2),
                    intArrayOf(3, 2, 3),
                    intArrayOf(1, 1, 3),
                    intArrayOf(1, 2, 4),
                    intArrayOf(1, 1, 2),
                    intArrayOf(2, 3, 4)
            )))
            println(MaxNumEdgesToRemove().solution(2, arrayOf(
                    intArrayOf(1, 1, 2),
                    intArrayOf(2, 1, 2),
                    intArrayOf(3, 1, 2)
            )))
        }
    }

    // n = 2, edges = [[1,1,2],[2,1,2],[3,1,2]]
    // n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
    fun solution(n: Int, edges: Array<IntArray>): Int {
        val unionFoundX = UnionFound(n)
        val unionFoundY = UnionFound(n)

        var result = 0

        edges.forEach {
            if (it[0] == 3) {
                if (!unionFoundX.setUnion(it[1], it[2])) {
                    result++
                } else {
                    unionFoundY.setUnion(it[1], it[2])
                }
            }
        }

        edges.forEach {
            if (it[0] == 1) {
                if (!unionFoundX.setUnion(it[1], it[2])) {
                    result++
                }
            } else if (it[0] == 2) {
                if (!unionFoundY.setUnion(it[1], it[2])) {
                    result++
                }
            }
        }

        if (unionFoundX.count != 1 || unionFoundY.count != 1) return -1

        return result
    }

    class UnionFound(n: Int) {
        private val p = Array(n + 1) { it }
        var count = n

        private fun find(index: Int): Int = if (p[index] == index) index else {
            p[index] = find(p[index])
            find(p[index])
        }

        fun setUnion(x: Int, y: Int): Boolean {
            val xP = find(x)
            val yP = find(y)

            if (xP == yP) return false

            p[xP] = yP

            count--
            return true
        }
    }

}