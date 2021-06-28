package com.daily.algothrim.leetcode.easy

/**
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
class Reverse {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Reverse().reverse(123))
            println(Reverse().reverse(-123))
            println(Reverse().reverse(120))
            println(Reverse().reverse(0))
        }
    }

    // 输入：x = 123
    // 输出：321
    // 时间复杂度：O(\log |x|)O(log∣x∣)。翻转的次数即 xx 十进制的位数。
    // 空间复杂度：O(1)O(1)。
    fun reverse(x: Int): Int {
        var k = x
        var temp: Int
        var result = 0
        while (k != 0) {
            if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10) return 0
            temp = k % 10
            k /= 10
            result = result * 10 + temp
        }
        return result
    }
}