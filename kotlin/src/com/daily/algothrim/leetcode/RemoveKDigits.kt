package com.daily.algothrim.leetcode

import java.util.*

/**
 * 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
class RemoveKDigits {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // 1219
            println(RemoveKDigits().solution("1432219", 3))
            // 200
            println(RemoveKDigits().solution("10200", 1))
            // 0
            println(RemoveKDigits().solution("10", 2))
            // 0
            println(RemoveKDigits().solution("1234567890", 9))
        }
    }

    /**
     * O(n)
     * 贪心算法
     * 从左往右比较，当前的值比后面的大即高位比低位大，就移除当前值
     */
    fun solution(num: String, k: Int): String {
        var times = k
        val stack = LinkedList<Char>()
        num.forEach {
            // 高位比低位大
            while (stack.isNotEmpty() && times > 0 && stack.peekLast() > it) {
                stack.removeLast()
                times--
            }
            stack.add(it)
        }

        // 还有次数剩余，直接从后面低位移除
        repeat(times) {
            if (stack.isNotEmpty()) {
                stack.removeLast()
            } else {
                return@repeat
            }
        }

        // 消除高位0
        while (stack.isNotEmpty() && stack.peek() == '0') {
            stack.poll()
        }

        val result = StringBuilder().apply {
            stack.forEach {
                append(it)
            }
        }
        return if (result.isEmpty()) "0" else result.toString()
    }
}