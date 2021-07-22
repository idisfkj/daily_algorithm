package com.daily.algothrim.leetcode.easy

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
class ClimbStairs {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ClimbStairs().climbStairs(2))
            println(ClimbStairs().climbStairs(3))
            println(ClimbStairs().climbStairs2(2))
            println(ClimbStairs().climbStairs2(3))
        }
    }

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2

        for (i in 2 until n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n - 1]
    }

    fun climbStairs2(n: Int): Int {
        var p = 0
        var q: Int
        var r = 1

        for (i in 0 until n) {
            q = p
            p = r
            r = p + q
        }
        return r
    }
}