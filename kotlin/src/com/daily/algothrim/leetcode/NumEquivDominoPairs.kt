package com.daily.algothrim.leetcode

/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * */
class NumEquivDominoPairs {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(NumEquivDominoPairs().solution(arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(3, 4),
                    intArrayOf(5, 6)
            )))
        }
    }

    // dominoes[i].size 最大为两位
    // O(n)
    fun solution(dominoes: Array<IntArray>): Int {
        // 组成两位数的正数
        val a = IntArray(100)
        var count = 0

        for (item in dominoes) {
            if (item[0] > item[1]) {
                val temp = item[0]
                item[0] = item[1]
                item[1] = temp
            }

            count += a[item[0] * 10 + item[1]]++
        }

        return count
    }
}