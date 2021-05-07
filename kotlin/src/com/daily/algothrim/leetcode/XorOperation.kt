package com.daily.algothrim.leetcode

/**
 * 1486. 数组异或操作
 *
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 */
class XorOperation {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(XorOperation().xorOperation(5, 0))
            println(XorOperation().xorOperation(4, 3))
            println(XorOperation().xorOperation2(5, 0))
            println(XorOperation().xorOperation2(4, 3))
        }
    }

    fun xorOperation(n: Int, start: Int): Int {
        var result = start
        for (i in 1 until n) {
            result = result.xor(start + 2 * i)
        }
        return result
    }

    fun xorOperation2(n: Int, start: Int): Int {
        val s = start.shr(1)
        val e = n.and(start).and(1)
        val result = sumXor(s - 1).xor(sumXor(s + n - 1))
        return result.shl(1).or(e)
    }

    private fun sumXor(x: Int): Int {
        return when (x % 4) {
            0 -> x
            1 -> 1
            2 -> x + 1
            else -> 0
        }
    }


}