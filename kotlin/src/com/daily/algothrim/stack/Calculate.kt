package com.daily.algothrim.stack

import java.util.*

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。(LeetCode 224)
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格.
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 *
 * 1. 通过设定一个符号位将所有的运算转化成加法
 * 2. 遇到数字都带上之前的符号位，再与之前的结果做加法运算
 * 3. 遇到'('将之前的符号位与结果保留到栈中，然后再重复1 2 步骤计算括号里面的值
 * 4. 遇到')'取出之前保留的符号位与结果，与当前结果做加法运算
 */
class Calculate {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Calculate().calculate("(1+(4+5+2)-3)+(6+8)"))
        }
    }

    /**
     * O(n)
     */
    fun calculate(s: String): Int {
        val numberStack = Stack<Int>()
        var sign = 1 // 符号位
        var result = 0
        var index = 0
        while (index < s.length) {
            when (s[index]) {
                '+' -> {
                    sign = 1
                }
                '-' -> {
                    sign = -1
                }
                '(' -> {
                    // 将当前结果加入栈中
                    numberStack.push(result)
                    result = 0
                    // 将当前符号位加入栈中
                    numberStack.push(sign)
                    sign = 1
                }
                ')' -> {
                    // 取出之前保留的符号位与结果，与当前结果做加法运算
                    result = numberStack.pop() * result + numberStack.pop()
                }
                ' ' -> {
                }
                else -> {
                    // 计算出当前的数值，可以能为多位数
                    var cur = s[index] - '0'
                    while (index + 1 < s.length && s[index + 1].isDigit()) {
                        cur = cur * 10 + (s[++index] - '0')
                    }
                    // 遇到数字带上之前的符号位，再与之前的结果做加法运算
                    result += cur * sign
                }
            }
            index++
        }
        return result
    }
}