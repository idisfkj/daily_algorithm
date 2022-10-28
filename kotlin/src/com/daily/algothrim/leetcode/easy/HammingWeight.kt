package com.daily.algothrim.leetcode.easy

/**
 * 191. 位1的个数
 */
class HammingWeight {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(HammingWeight().hammingWeight(11))
            println(HammingWeight().hammingWeight(256))
        }
    }

    fun hammingWeight(n:Int):Int {
        var count = 0
        var temp = n
        while (temp != 0) {
            temp = temp.and(temp - 1)
            count++
        }
        return count
    }
}