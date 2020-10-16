package com.daily.algothrim.graph

import java.util.*

/**
 * 图的广度与深度优先搜索
 */
class Graph(private val v: Int) {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Graph(8).apply {
                addEdge(0, 1)
                addEdge(0, 3)
                addEdge(1, 2)
                addEdge(1, 4)
                addEdge(2, 5)
                addEdge(3, 4)
                addEdge(4, 5)
                addEdge(4, 6)
                addEdge(5, 7)
                addEdge(6, 7)
                bfs(0, 6)
                println()
                dfs(0, 6)
            }
        }
    }


    private val adj: Array<LinkedList<Int>> = Array(v) {
        LinkedList()
    }

    fun addEdge(s: Int, t: Int) {
        adj[s].add(t)
        adj[t].add(s)
    }

    /**
     * 广度优先搜索,借助队列
     * 时间：O(E) E -> 边
     * 空间：O(V) V -> 顶点
     */
    fun bfs(s: Int, t: Int) {
        val prev = IntArray(v) { -1 } // 访问路径的倒序，也是最短路径
        val visited = BooleanArray(v) { false } // 已经访问的顶点设置为true
        val deque = ArrayDeque<Int>() // 将当前访问的顶点加入队列中，一遍方法它下层相邻的顶点

        deque.offer(s)

        while (deque.isNotEmpty()) {
            val p = deque.poll()

            var i = 0
            while (i < adj[p].size) {
                val w = adj[p][i]
                if (!visited[w]) {
                    visited[w] = true
                    prev[w] = p
                    if (w == t) {
                        printPrev(s, t, prev)
                        return
                    }
                    deque.offer(w)
                }
                i++
            }
        }
    }

    private var found = false

    /**
     * 深度优先搜索,借助递归栈，即栈
     * 时间：O(E) E -> 边
     * 空间：O(V) V -> 顶点
     */
    fun dfs(s: Int, t: Int) {
        val prev = IntArray(v) { -1 } // 访问路径的倒序，非最短路径
        val visited = BooleanArray(v) { false } // 已经访问的顶点设置为true
        recurDfs(s, t, prev, visited)
        printPrev(s, t, prev)
    }

    private fun recurDfs(s: Int, t: Int, prev: IntArray, visited: BooleanArray) {
        if (found) return
        visited[s] = true
        if (s == t) {
            found = true
            return
        }

        var i = 0
        while (i < adj[s].size) {
            val w = adj[s][i]
            if (!visited[w]) {
                visited[w] = true
                prev[w] = s
                recurDfs(w, t, prev, visited)
            }
            i++
        }
    }

    private fun printPrev(s: Int, t: Int, prev: IntArray) {
        if (prev[t] != -1 && t != s) {
            printPrev(s, prev[t], prev)
        }
        println("$t")
    }

}