package com.daily.algothrim.leetcode.medium

/**
 * 50. Pow(x, n)
 */
class MyPow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MyPow().myPow(2.0, 10))
            println(MyPow().myPow(2.1, 3))
            println(MyPow().myPow(2.0, -2))
        }
    }

    fun myPow(x: Double, n: Int): Double {
        return if (n >= 0) quickMul(x, n) else 1.0 / quickMul(x, -n)
    }

    private fun quickMul(x: Double, n: Int): Double {
        if (n == 0) return 1.0

        val y = quickMul(x, n / 2)
        return if (n % 2 == 0) y * y else y * y * x
    }
}