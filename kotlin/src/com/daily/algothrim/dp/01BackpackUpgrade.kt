package com.daily.algothrim.dp

/**
 * 01-背包升级版，增加背包价值，求最大价值。
 */
class `01BackpackUpgrade` {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(`01BackpackUpgrade`().dp(5, intArrayOf(2, 2, 4, 6, 3), intArrayOf(3, 4, 8, 9, 6), 9))
            println(`01BackpackUpgrade`().dp2(5, intArrayOf(2, 2, 4, 6, 3), intArrayOf(3, 4, 8, 9, 6), 9))
        }
    }

    /**
     * O(n * w)
     */
    fun dp(n: Int, item: IntArray, value: IntArray, w: Int): Int {
        val status = Array(n) { IntArray(w + 1) { -1 } }

        status[0][0] = 0
        if (item[0] <= w) status[0][item[0]] = value[0]

        var i = 1
        while (i < n) {
            var j = 0
            while (j <= w) { // 不装
                if (status[i - 1][j] >= 0) status[i][j] = status[i - 1][j]
                j++
            }

            var k = 0
            while (k <= w - item[i]) { // 装
                if (status[i - 1][k] >= 0) {
                    // notice
                    val v = status[i - 1][k] + value[i]
                    if (v > status[i][k + item[i]]) {
                        status[i][k + item[i]] = v
                    }
                }
                k++
            }
            i++
        }

        var maxV = -1
        status[n - 1].forEach {
            if (it > maxV) maxV = it
        }

        return maxV
    }

    fun dp2(n: Int, item: IntArray, value: IntArray, w: Int): Int {
        val status = IntArray(w + 1) { -1 }

        status[0] = 0
        if (item[0] <= w) status[item[0]] = value[0]

        var i = 1
        while (i < n) {
            var j = w - item[i]
            while (j >= 0) {
                if (status[j] >= 0) {
                    val v = status[j] + value[i]
                    if (v > status[j + item[i]]) {
                        status[j + item[i]] = v
                    }
                }
                j--
            }
            i++
        }

        var maxV = -1
        status.forEach {
            if (it > maxV) maxV = it
        }

        return maxV
    }
}