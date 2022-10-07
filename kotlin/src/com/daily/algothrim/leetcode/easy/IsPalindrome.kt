package com.daily.algothrim.leetcode.easy

/**
 * 9. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
class IsPalindrome {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(IsPalindrome().isPalindrome(121))
            println(IsPalindrome().isPalindrome(-121))
            println(IsPalindrome().isPalindrome(10))
        }

    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x % 10 == 0 && x != 0) return false
        var temp = x
        var reverse = 0

        while (temp > reverse) {
            reverse = temp % 10 + reverse * 10
            temp /= 10
        }

        return reverse == temp || reverse / 10 == temp
    }
}