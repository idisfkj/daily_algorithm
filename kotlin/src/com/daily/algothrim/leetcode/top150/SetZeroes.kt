package com.daily.algothrim.leetcode.top150

/**
 * 73. 矩阵置零
 */

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。



示例 1：


输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
示例 2：


输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]


提示：

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


进阶：

一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 */
class SetZeroes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var matrix = arrayOf(
                intArrayOf(1,1,1),
                intArrayOf(1,0,1),
                intArrayOf(1,1,1)
            )
            SetZeroes().setZeroes(matrix)
            matrix.forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }

            println()

            matrix = arrayOf(
                intArrayOf(0,1,2,0),
                intArrayOf(3,4,5,2),
                intArrayOf(1,3,1,5)
            )
            SetZeroes().setZeroes(matrix)
            matrix.forEach {
                it.forEach { item ->
                    print("$item, ")
                }
                println()
            }
        }
    }

    fun setZeroes(matrix: Array<IntArray>) {
        val rowCount = matrix.size
        val columnCont = matrix[0].size

        var booleanRow = false
        var booleanColumn = false

        for (j in 0 until columnCont) {
            if (matrix[0][j] == 0) {
                booleanRow = true
                break
            }
        }

        for (i in 0 until rowCount) {
            if (matrix[i][0] == 0) {
                booleanColumn = true
                break
            }
        }

        for (i in 1 until rowCount) {
            for (j in 1 until columnCont) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1 until rowCount) {
            for (j in 1 until columnCont) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (booleanRow) {
            for (j in 0 until columnCont) {
                matrix[0][j] = 0
            }
        }

        if (booleanColumn) {
            for (i in 0 until rowCount) {
                matrix[i][0] = 0
            }
        }
    }
}