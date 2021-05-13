package com.daily.algothrim.leetcode

/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 */
class NumWays {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(NumWays().numWays(3, 2))
            println(NumWays().numWays(4, 2))
            println(NumWays().numWays2(3, 2))
            println(NumWays().numWays2(4, 2))
        }
    }

    //输入：steps = 3, arrLen = 2
    //输出：4
    //解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
    //向右，向左，不动
    //不动，向右，向左
    //向右，不动，向左
    //不动，不动，不动
    fun numWays(steps: Int, arrLen: Int): Int {
        val mode = 1000000007
        val n = Math.min(steps + 1, arrLen)

        val status = Array(steps + 1) { IntArray(n) }
        status[0][0] = 1

        for (i in 1..steps) {
            for (j in 0 until n) {
                status[i][j] = status[i - 1][j]
                if (j - 1 >= 0) {
                    status[i][j] = (status[i][j] + status[i - 1][j - 1]) % mode
                }
                if (j + 1 < n) {
                    status[i][j] = (status[i][j] + status[i - 1][j + 1]) % mode
                }
            }
        }
        return status[steps][0]
    }

    fun numWays2(steps: Int, arrLen: Int): Int {
        val mode = 1000000007
        val n = Math.min(steps + 1, arrLen)
        var status = IntArray(n)
        status[0] = 1

        for (i in 1..steps) {
            val statusNext = IntArray(n)
            for (j in 0 until n) {
                statusNext[j] = status[j]
                if (j - 1 >= 0) {
                    statusNext[j] = (statusNext[j] + status[j - 1]) % mode
                }
                if (j + 1 < n) {
                    statusNext[j] = (statusNext[j] + status[j + 1]) % mode
                }
            }
            status = statusNext
        }
        return status[0]
    }
}