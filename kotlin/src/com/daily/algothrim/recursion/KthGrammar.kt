package com.daily.algothrim.recursion

/**
 * 第K个语法符号(LeetCode 779)
 *
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数N和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 注意：
 *
 * N的范围[1, 30].
 * K的范围[1, 2^(N-1)].
 *
 */
class KthGrammar {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(KthGrammar().kthGrammar(4, 5))
            println(KthGrammar().kthGrammarReverse(4, 5))
        }
    }

    //  第一行: 0
    //  第二行: 01
    //  第三行: 0110
    //  第四行: 01101001

    // 第 K 个数字是上一行第 (K+1) / 2 个数字生成的。如果上一行的数字为 0，被生成的数字为 1 - (K%2)，如果上一行的数字为 1，被生成的数字为 K%2
    // O(n)
    private fun kthGrammar(N: Int, K: Int): Int {
        if (N == 1) return 0
        return (K.inv() and 1) xor kthGrammar(N - 1, (K + 1) / 2)
    }

    // 每一行前一半部分等于上一行，后一半部分等于上一行的 0 1 反转
    // O(n)
    private fun kthGrammarReverse(N: Int, K: Int): Int {
        if (N == 1) return 0
        // K位于前一半部分
        if (K <= (1 shl (N - 2))) {
            return kthGrammarReverse(N - 1, K)
        }
        // K 位于后一半部分
        return kthGrammarReverse(N - 1, K - (1 shl (N - 1))) xor 1
    }
}