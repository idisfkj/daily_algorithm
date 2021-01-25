package com.daily.algothrim.leetcode

/**
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 */
class RegionsBySlashes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(RegionsBySlashes().solution(arrayOf("\\/", "/\\")))
        }
    }

    //输入：
    //[
    //  "\\/",
    //  "/\\"
    //]
    //输出：4
    // 每一个网格基于对角线拆分成4个三角形
    fun solution(grid: Array<String>): Int {
        val n = grid.size
        // 拆分的三角形的个数
        val size = 4 * n * n

        val unionFound = UnionFound(size)

        grid.forEachIndexed { i, s ->
            s.toCharArray().forEachIndexed { j, c ->
                val index = 4 * (i * n + j)
                when (c) {
                    '/' -> {
                        // 合并0 3, 1 2
                        unionFound.setUnion(index, index + 3)
                        unionFound.setUnion(index + 1, index + 2)
                    }
                    '\\' -> {
                        // 合并0 1, 2 3
                        unionFound.setUnion(index, index + 1)
                        unionFound.setUnion(index + 2, index + 3)
                    }
                    else -> {
                        // 合并0 1 2 3
                        unionFound.setUnion(index, index + 1)
                        unionFound.setUnion(index + 1, index + 2)
                        unionFound.setUnion(index + 2, index + 3)
                    }
                }

                // 从左向右 合并单元格
                if (j + 1 < n) {
                    unionFound.setUnion(index + 1, 4 * (i * n + j + 1) + 3)
                }
                // 从上到下 合并单元格
                if (i + 1 < n) {
                    unionFound.setUnion(index + 2, 4 * ((i + 1) * n + j))
                }
            }
        }
        return unionFound.count
    }

    class UnionFound(n: Int) {
        private val p = Array(n) { it }
        var count = n

        private fun find(index: Int): Int = if (index == p[index]) index else find(p[index])

        fun setUnion(x: Int, y: Int) {
            val xP = find(x)
            val yP = find(y)

            if (xP == yP) return

            p[xP] = yP
            count--
        }

    }

}