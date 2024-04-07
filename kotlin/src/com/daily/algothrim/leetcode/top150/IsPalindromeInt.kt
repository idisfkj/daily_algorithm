package com.daily.algothrim.leetcode.top150

/**
 * 9. 回文数
 */

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数
是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。


示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

提示：

-231 <= x <= 231 - 1

进阶：你能不将整数转为字符串来解决这个问题吗？
 */
class IsPalindromeInt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsPalindromeInt().isPalindrome(121))
            println(IsPalindromeInt().isPalindrome(-121))
            println(IsPalindromeInt().isPalindrome(10))
        }
    }

    /**
     * O(logn)
     * O(1)
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false

        var reverseInt = 0
        var temp = x

        while (temp > reverseInt) {
            reverseInt = reverseInt * 10 + temp % 10
            temp /= 10
        }

        return temp == reverseInt || temp == reverseInt / 10
    }

}