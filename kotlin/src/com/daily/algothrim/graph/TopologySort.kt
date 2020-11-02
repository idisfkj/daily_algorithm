package com.daily.algothrim.graph

import java.util.*

/**
 * 拓扑排序
 */
class TopologySort(private val v: Int) {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TopologySort(4).apply {
                addEdge(0, 1)
                addEdge(0, 2)
                addEdge(0, 3)
                addEdge(1, 2)
                addEdge(1, 3)
                addEdge(2, 3)
                topologySortByKahn()
                println()
                topologySortByDFS()
            }
        }
    }

    private val adj = Array(v) { LinkedList<Int>() }

    fun addEdge(s: Int, t: Int) {
        // s优先于t执行，t依赖于s
        adj[s].add(t)
    }

    /**
     * 卡恩
     * O(V+E)
     */
    fun topologySortByKahn() {
        val inDegree = IntArray(v)
        var i = 0
        // t依赖于s，s的入度+1
        // 统计入度
        while (i < v) {
            var j = 0
            while (j < adj[i].size) {
                val w = adj[i][j]
                inDegree[w]++
                j++
            }
            i++
        }

        val queue = LinkedList<Int>()
        var k = 0
        while (k < v) {
            // 初始化入度为0的进入队列
            if (inDegree[k] == 0) queue.offer(k)
            k++
        }

        // 遍历消除入度为零的节点
        while (queue.isNotEmpty()) {
            val n = queue.pop()
            print("->$n")
            var m = 0
            while (m < adj[n].size) {
                val w = adj[n][m]
                // 依赖当前入度为零的节点，对应的入度减1
                inDegree[w]--
                // 入度为0入队
                if (inDegree[w] == 0) queue.offer(w)
                m++
            }
        }
    }

    /**
     * 深度优先搜索
     * O(V+E)
     */
    fun topologySortByDFS() {
        val reverseAdj = Array(v) { LinkedList<Int>() }
        var i = 0
        while (i < v) {
            var j = 0
            while (j < adj[i].size) {
                val w = adj[i][j]
                // 生成逆邻接表，对应w依赖于i
                reverseAdj[w].add(i)
                j++
            }
            i++
        }

        var k = 0
        val visited = BooleanArray(v)
        while (k < v) {
            if (!visited[k]) {
                visited[k] = true
                // 递归寻找k依赖的节点
                recurDFS(k, visited, reverseAdj)
            }
            k++
        }
    }

    private fun recurDFS(k: Int, visited: BooleanArray, reverseAdj: Array<LinkedList<Int>>) {
        var m = 0
        while (m < reverseAdj[k].size) {
            val w = reverseAdj[k][m]
            if (!visited[w]) {
                visited[w] = true
                recurDFS(w, visited, reverseAdj)
            }
            m++
        }
        print("->$k")
    }
}