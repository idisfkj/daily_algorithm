package com.daily.algothrim.leetcode.medium

/**
 * 36. 有效的数独
 */
class IsValidSudoku {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsValidSudoku().isValidSudoku(
                arrayOf(
                    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
                )
            ))
        }
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val column = Array(9) {
            IntArray(9)
        }
        val row = Array(9) {
            IntArray(9)
        }

        val box = Array(3) {
            Array(3) {
                IntArray(9)
            }
        }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val c = board[i][j]
                if (c != '.') {
                    val index = c - '0' - 1
                    column[i][index]++
                    row[j][index]++
                    box[i / 3][j / 3][index]++
                    if (column[i][index] > 1 || row[j][index] > 1 || box[i / 3][j / 3][index] > 1) {
                        return false
                    }
                }
            }
        }

        return true
    }
}