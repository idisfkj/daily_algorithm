package com.daily.algothrim.leetcode.easy

/**
 * 118. 杨辉三角
 */
class Generate {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Generate().generate(5).forEach {list ->
                list.forEach {
                    print(it)
                }
                print(",")
            }
            println()
            Generate().generate(1).forEach {list ->
                list.forEach {
                    print(it)
                }
                print(",")
            }
        }
    }

    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        for (i in 0 until numRows) {
            val row = arrayListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    row.add(1)
                } else {
                    row.add(result[i - 1][j - 1] + result[i - 1][j])
                }
            }
            result.add(row)
        }
        return result
    }
}