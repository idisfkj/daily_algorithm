package com.daily.algothrim.leetcode.easy

/**
 * 119. 杨辉三角 II
 */
class GetRow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GetRow().getRow(3).forEach {
                print(it)
            }
            println()
            GetRow().getRow(0).forEach {
                print(it)
            }
            println()
        }
    }

    fun getRow(rowIndex: Int): List<Int> {
        var pre = ArrayList<Int>()
        for (i in 0 .. rowIndex) {
            val cur = ArrayList<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    cur.add(1)
                } else {
                    cur.add(pre[j - 1] + pre[j])
                }
            }
            pre = cur
        }
        return pre
    }
}