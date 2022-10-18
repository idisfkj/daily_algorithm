package com.daily.algothrim.leetcode.easy

/**
 * 69. x 的平方根
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
class MySqrt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MySqrt().mySqrt(4))
            println(MySqrt().mySqrt(8))
            println(MySqrt().mySqrt(2147395599))
        }
    }

    fun mySqrt(x: Int): Int {
        var l = 0
        var r = x
        var ans = -1

        while (l <= r) {
            val mid = l + (r - l).shr(1)
            if (mid * mid.toLong() <= x) {
                ans = mid
                l = mid + 1
            } else {
                r  = mid - 1
            }
        }
        return ans
    }
}