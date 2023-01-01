package com.daily.algothrim.leetcode.medium

/**
 * 6. Z 字形变换
 */
class Convert {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(Convert().convert("PAYPALISHIRING", 3))
            println(Convert().convert("PAYPALISHIRING", 4))
        }
    }

    fun convert(s: String, numRows: Int): String {
        val n = s.length
        if (numRows == 1 || n <= numRows) return s

        val p = numRows + numRows - 2
        val pc = numRows - 1
        val column = (n + p - 1) / p * pc

        val matrix = Array(numRows) {
            CharArray(column) {
                '0'
            }
        }

        var x = 0
        var y = 0

        for (i in 0 until n) {
            matrix[x][y] = s[i]
            if (i % p < numRows - 1) {
                x++
            } else {
                x--
                y++
            }
        }

        val result = StringBuilder()
        for (j in 0 until numRows) {
            for (k in 0 until column) {
                if (matrix[j][k] != '0') {
                    result.append(matrix[j][k])
                }
            }
        }
        return result.toString()
    }
}