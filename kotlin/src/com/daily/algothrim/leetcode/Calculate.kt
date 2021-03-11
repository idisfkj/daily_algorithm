package com.daily.algothrim.leetcode

import java.util.*

/**
 * 227. 基本计算器 II
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 */
class Calculate {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Calculate().calculate("2*2"))
            println(Calculate().calculate("3+2*2"))
            println(Calculate().calculate(" 3/2"))
            println(Calculate().calculate(" 3+5 / 2"))
        }
    }

    //输入：s = "3+2*2"
    // 3+2+1*1
    //输出：7
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var sign = 1
        var result = 1

        var i = 0
        val size = s.length
        while (i < size) {
            when (val c = s[i]) {
                '+' -> {
                    sign = 1
                    if (stack.isNotEmpty()) {
                        result += stack.pop()
                    }
                    stack.push(result)
                }
                '-' -> {
                    sign = -1
                    if (stack.isNotEmpty()) {
                        result += stack.pop()
                    }
                    stack.push(result)
                }
                '*' -> {
                    var current = 0
                    while (i + 1 < size && (s[i + 1].isDigit() || s[i + 1] == ' ')) {
                        if (s[++i] != ' ') current = (current * 10) + (s[i] - '0')
                    }
                    result *= current
                }
                '/' -> {
                    var current = 0
                    while (i + 1 < size && (s[i + 1].isDigit() || s[i + 1] == ' ')) {
                        if (s[++i] != ' ') current = (current * 10) + (s[i] - '0')
                    }
                    result /= current
                }
                ' ' -> {
                }
                else -> {
                    var current = c - '0'
                    while (i + 1 < size && s[i + 1].isDigit()) {
                        current = (current * 10) + (s[i + 1] - '0')
                        i++
                    }
                    result = current * sign
                }
            }
            i++
        }

        while (stack.isNotEmpty()) {
            result += stack.pop()
        }

        return result
    }
}