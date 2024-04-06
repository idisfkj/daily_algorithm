package com.daily.algothrim.leetcode.top150

/**
 * 207. 课程表
 */

/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

提示：

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
prerequisites[i] 中的所有课程对 互不相同
 */
class CanFinish {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanFinish().canFinish(2, arrayOf(intArrayOf(1, 0))))
            println(CanFinish().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
        }
    }

    private var valid = true
    private var edges = arrayListOf<ArrayList<Int>>()

    /**
     * O(m+n)
     * O(m+n)
     */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val visits = Array(numCourses) { 0 }

        for (i in 0 until numCourses) {
            edges.add(arrayListOf())
        }

        for (item in prerequisites) {
            edges[item[1]].add(item[0])
        }

        for (i in 0 until numCourses) {
            if (visits[i] == 0) {
                dfs(i, visits)
            }
        }
        return valid
    }

    private fun dfs(u: Int, visits: Array<Int>) {
        visits[u] = 1
        for (v in edges[u]) {
            if (visits[v] == 0) {
                dfs(v, visits)
                if (!valid) return
            } else if (visits[v] == 1) {
                valid = false
                return
            }
        }
        visits[u] = 2
    }

}