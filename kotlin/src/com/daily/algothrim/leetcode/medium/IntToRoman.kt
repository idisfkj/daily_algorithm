package com.daily.algothrim.leetcode.medium

/**
 * 12. 整数转罗马数字
 */
class IntToRoman {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IntToRoman().intToRoman(1994))
        }
    }

    private val values = arrayOf(
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    )

    private val symbols = arrayOf(
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    )

    fun intToRoman(num: Int): String {
        var temp = num
        return StringBuffer().apply {
            values.forEachIndexed { index, value ->
                val symbol = symbols[index]
                while (temp >= value) {
                    temp -= value
                    append(symbol)
                }
                if (temp == 0) return@apply
            }
        }.toString()
    }
}