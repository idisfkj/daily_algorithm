package com.daily.algothrim.backtracking

/**
 * 01-背包
 */
class `01Backpack` {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            `01Backpack`().apply {
                backtracking(0, intArrayOf(2, 2, 4, 6, 3), 5, 9, 0)
                println(maxW)
            }
        }
    }

    private var maxW = Int.MIN_VALUE

    /**
     * O(2^n)
     * w: 可装的背包最大重量
     * cw: 当前装的重量
     * item: 背包重量数组
     * n: 背包个数
     * i: 当前背包
     */
    fun backtracking(i: Int, item: IntArray, n: Int, w: Int, cw: Int) {
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw
            return
        }
        backtracking(i + 1, item, n, w, cw) // 不装
        if (cw + item[i] < w) { // 装
            backtracking(i + 1, item, n, w, cw + item[i])
        }
    }
}