package com.daily.algothrim.leetcode

/**
 * 1489. 找到最小生成树里的关键边和伪关键边
 *
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 *
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 *
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 *
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 * */
class FindCriticalAndPseudoCriticalEdges {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            FindCriticalAndPseudoCriticalEdges().solution(5, arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 2),
                    intArrayOf(0, 3, 2),
                    intArrayOf(0, 4, 3),
                    intArrayOf(3, 4, 3),
                    intArrayOf(1, 4, 6)
            )).forEach { item ->
                println("$item")
            }

            FindCriticalAndPseudoCriticalEdges().solution(4, arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 1),
                    intArrayOf(0, 3, 1)
            )).forEach { item ->
                println("$item")
            }
        }
    }

    fun solution(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val m = edges.size

        // 增加索引位
        val newEdges = Array(m) {
            IntArray(4)
        }

        var i = 0
        while (i < m) {
            var j = 0
            while (j < 3) {
                newEdges[i][j] = edges[i][j]
                j++
            }
            // 保存索引
            newEdges[i][3] = i
            i++
        }

        newEdges.sortWith(Comparator { o1, o2 ->
            o1[2] - o2[2]
        })

        // 找到最小权重值
        var minValue = 0
        val union = UnionFind(n)
        var k = 0
        while (k < m) {
            if (union.setUnion(newEdges[k][0], newEdges[k][1])) {
                minValue += newEdges[k][2]
            }
            k++
        }

        // 结果集
        val result = MutableList<MutableList<Int>>(2) {
            mutableListOf()
        }

        var p = 0
        while (p < m) {
            // 找到关键边
            var unionFind = UnionFind(n)
            var q = 0
            var value = 0
            while (q < m) {
                // 排除p当前边，计算它的权重值
                if (p != q && unionFind.setUnion(newEdges[q][0], newEdges[q][1])) {
                    value += newEdges[q][2]
                }
                q++
            }

            // 不为连通图，或者权重大于最小权重
            if (unionFind.count != 1 || (unionFind.count == 1 && value > minValue)) {
                result[0].add(newEdges[p][3])
                p++
                continue
            }

            // 找到伪关键边
            // 由于上面已经排除了关键边，所以剩下的就是伪关键边或者不是最小生成树的边
            unionFind = UnionFind(n)
            // 假设p是伪关键边，计算它的权重值
            unionFind.setUnion(newEdges[p][0], newEdges[p][1])
            value = newEdges[p][2]
            q = 0
            while (q < m) {
                if (p != q && unionFind.setUnion(newEdges[q][0], newEdges[q][1])) {
                    value += newEdges[q][2]
                }
                q++
            }

            // 基于p边能够得到最小生成树，所以该边是伪关键边
            if (value == minValue) {
                result[1].add(newEdges[p][3])
            }

            p++
        }

        return result
    }


    class UnionFind(n: Int) {
        private val parent = IntArray(n)
        private val size = IntArray(n)
        var count = n

        init {
            var i = 0
            while (i < n) {
                parent[i] = i
                size[i] = 1
                i++
            }
        }

        private fun find(index: Int): Int = if (parent[index] == index) index else find(parent[index])

        fun setUnion(x: Int, y: Int): Boolean {
            var xP = find(x)
            var yP = find(y)

            if (xP == yP) return false

            if (size[xP] < size[yP]) {
                val temp = xP
                xP = yP
                yP = temp
            }

            size[xP] += size[yP]
            parent[yP] = xP
            count--

            return true
        }
    }
}