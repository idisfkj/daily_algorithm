package com.daily.algothrim.leetcode.medium

/**
 * 8. 字符串转换整数 (atoi)
 */
class MyAtoi {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(MyAtoi().myAtoi("42"))
            println(MyAtoi().myAtoi("   -42"))
            println(MyAtoi().myAtoi("4193 with words"))
            println(MyAtoi().myAtoi("-91283472332"))
        }

    }

    fun myAtoi(s: String): Int {
        Automation().apply {
            s.forEach {
                if (!execute(it)) return@forEach
            }
            return getResult()
        }
    }

}

class Automation {
    private var sign = 1
    private var res = 0L

    private var state = "start"

    private val autoTable = hashMapOf(
        "start" to arrayOf("start", "sign", "number", "end"),
        "sign" to arrayOf("end", "end", "number", "end"),
        "number" to arrayOf("end", "end", "number", "end"),
        "end" to arrayOf("end", "end", "end", "end")
    )

    fun execute(c: Char): Boolean {
        state = autoTable[state]?.get(convertState(c)) ?: return false
        when (state) {
            "number" -> {
                res = res * 10 + (c - '0').toLong()
                res = if (sign == 1) {
                    Math.min(res, Int.MAX_VALUE.toLong())
                } else {
                    Math.min(res, -Int.MIN_VALUE.toLong())
                }
            }

            "sign" -> {
                sign = if (c == '+') 1 else -1
            }

            "start" -> return true
            "end" -> return false
        }
        return true
    }

    fun getResult(): Int {
        return res.toInt() * sign
    }

    private fun convertState(c: Char): Int {
        return when {
            c == ' ' -> 0
            c == '+' || c == '-' -> 1
            c.isDigit() -> 2
            else -> 3
        }
    }
}