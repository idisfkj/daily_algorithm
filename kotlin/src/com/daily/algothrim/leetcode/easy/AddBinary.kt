package com.daily.algothrim.leetcode.easy

/**
 * 67. 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 *
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
class AddBinary {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(AddBinary().addBinary("11", "1"))
            println(AddBinary().addBinary("1010", "1011"))
        }

    }

    fun addBinary(a: String, b: String): String {
        var carry = 0
        val result = StringBuilder()

        val n = Math.max(a.length, b.length)
        for (i in 0 until n) {
            if (i < a.length) {
                carry += a[a.length - i - 1] - '0'
            }
            if (i < b.length) {
                carry += b[b.length - i - 1] - '0'
            }
            result.append(carry % 2)
            carry /= 2
        }

        if (carry > 0) {
            result.append(carry)
        }

        result.reverse()

        return result.toString()
    }
}