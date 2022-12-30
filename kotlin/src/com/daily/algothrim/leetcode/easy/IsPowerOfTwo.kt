package com.daily.algothrim.leetcode.easy

/**
 * 231. 2 的幂
 */
class IsPowerOfTwo {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(IsPowerOfTwo().isPowerOfTwo(1))
            println(IsPowerOfTwo().isPowerOfTwo(16))
            println(IsPowerOfTwo().isPowerOfTwo(3))
            println(IsPowerOfTwo().isPowerOfTwo(4))
        }

    }

    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && n.and(n - 1) == 0
    }

}