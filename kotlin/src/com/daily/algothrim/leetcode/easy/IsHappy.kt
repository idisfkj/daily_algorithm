package com.daily.algothrim.leetcode.easy

/**
 * 202. 快乐数
 */
class IsHappy {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsHappy().isHappy(19))
            println(IsHappy().isHappy(2))
        }
    }

    fun isHappy(n: Int): Boolean {
        val map = hashSetOf<Int>()
        var temp = n
        while (temp != 1 && !map.contains(temp)) {
            map.add(temp)
            temp = getNext(temp)
        }
        return temp == 1
    }

    private fun getNext(n: Int): Int {
        var sum = 0
        var temp = n
        while (temp > 0) {
            val d = temp % 10
            temp /= 10
            sum += d * d
        }
        return sum
    }
}