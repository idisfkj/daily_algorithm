package com.daily.algothrim.leetcode.medium

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
class GenerateParenthesis {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GenerateParenthesis().generateParenthesis(3).forEach {
                println(it)
            }
        }
    }

    // n = 3
    // ["((()))","(()())","(())()","()(())","()()()"]
    fun generateParenthesis(n: Int): List<String> {
        val result = arrayListOf<String>()
        backtracking(StringBuilder(), 0, 0, n, result)
        return result
    }

    private fun backtracking(currentStr: StringBuilder, left: Int, right: Int, n: Int, result: ArrayList<String>) {
        if (currentStr.length == 2 * n) {
            result.add(currentStr.toString())
            return
        }

        if (left < n) {
            currentStr.append("(")
            backtracking(currentStr, left + 1, right, n, result)
            currentStr.deleteCharAt(currentStr.length - 1)
        }
        if (right < left) {
            currentStr.append(")")
            backtracking(currentStr, left, right + 1, n, result)
            currentStr.deleteCharAt(currentStr.length - 1)
        }

    }
}