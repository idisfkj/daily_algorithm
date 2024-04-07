package com.daily.algothrim.leetcode.top150

/**
 * 70. 爬楼梯
 */

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

提示：

1 <= n <= 45
 */
class ClimbStairs {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ClimbStairs().climbStairs(2))
            println(ClimbStairs().climbStairs(3))
        }
    }

    /**
     * O(n)
     * O(n)
     */
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}