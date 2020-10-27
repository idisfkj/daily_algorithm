package com.daily.algothrim.dynamic

/**
 * 01-背包
 */
class `01Backpack` {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(`01Backpack`().backtracking(5, 9, intArrayOf(2, 2, 4, 6, 3)))
            println(`01Backpack`().backtracking2(5, 9, intArrayOf(2, 2, 4, 6, 3)))
        }
    }

    /**
     * O(n * w)
     */
    fun backtracking(n: Int, w: Int, weight: IntArray): Int {

        val status = Array(n) { BooleanArray(w + 1) }

        // 初始化
        status[0][0] = true
        if (weight[0] <= w) {
            status[0][weight[0]] = true
        }

        var i = 1

        while (i < n) { // n个物品
            var j = 0
            while (j <= w) { // 不装
                if (status[i - 1][j]) status[i][j] = status[i - 1][j]
                j++
            }

            var k = 0
            while (k <= w - weight[i]) { // 装
                if (status[i - 1][k]) status[i][k + weight[i]] = true
                k++
            }
            i++
        }

        var m = w
        while (m >= 0) {
            if (status[n - 1][m]) return m
            m--
        }

        return 0
    }

    fun backtracking2(n: Int, w: Int, weight: IntArray): Int {
        val status = BooleanArray(w + 1)
        status[0] = true
        if (weight[0] <= w) status[weight[0]] = true

        var i = 1

        while (i < n) {
            var j = w - weight[i]

            while (j >= 0) { // 装
                if (status[j]) status[j + weight[i]] = true
                j--
            }

            i++
        }

        var k = w
        while (k >= 0) {
            if (status[k]) return k
            k--
        }

        return 0
    }
}