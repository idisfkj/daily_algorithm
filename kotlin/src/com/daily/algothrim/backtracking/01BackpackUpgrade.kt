package com.daily.algothrim.backtracking

/**
 * 01-背包升级版，增加背包价值，求最大价值。
 */
class `01BackpackUpgrade` {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            `01BackpackUpgrade`().apply {
                backtracking(0, 5, intArrayOf(2, 2, 4, 6, 3), intArrayOf(3, 4, 8, 9, 6), 9, 0, 0)
                println(maxV)
            }
        }
    }

    private var maxV = Int.MIN_VALUE

    /**
     * O(2^n)
     * w: 可装的背包最大重量
     * cw: 当前装的重量
     * cv: 当前背包价值
     * item: 背包重量数组
     * value: 背包价值数组
     * n: 背包个数
     * i: 当前背包
     */
    fun backtracking(i: Int, n: Int, item: IntArray, value: IntArray, w: Int, cw: Int, cv: Int) {
        if (i == n || cw == w) {
            if (maxV < cv) maxV = cv
            return
        }

        backtracking(i + 1, n, item, value, w, cw, cv) // 不装
        if (cw + item[i] <= w) { // 装
            backtracking(i + 1, n, item, value, w, cw + item[i], cv + value[i])
        }
    }
}