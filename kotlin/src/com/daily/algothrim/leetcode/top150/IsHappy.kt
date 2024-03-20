package com.daily.algothrim.leetcode.top150

/**
 * 202. 快乐数
 */

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。



示例 1：

输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：

输入：n = 2
输出：false


提示：

1 <= n <= 231 - 1
 */
class IsHappy {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(IsHappy().isHappy(19))
            println(IsHappy().isHappy(2))
            println(IsHappy().isHappy2(19))
            println(IsHappy().isHappy2(2))
        }
    }

    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        var temp = n
        while (temp != 1 && !set.contains(temp)) {
            set.add(temp)
            temp = getNext(temp)
        }

        return temp == 1
    }

    private fun getNext(n: Int): Int {
        var temp = n
        var sum = 0
        var d = 0
        while (temp > 0) {
            d = temp % 10
            temp /= 10
            sum += d * d
        }
        return sum
    }

    fun isHappy2(n: Int): Boolean {
        var fast = n
        var slow = n

        do {
            slow = getNext(slow)
            fast = getNext(getNext(fast))
        } while (fast != slow)

        return fast == 1
    }

}