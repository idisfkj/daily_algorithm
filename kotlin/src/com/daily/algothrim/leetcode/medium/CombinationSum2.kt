package com.daily.algothrim.leetcode.medium

/**
 * 40. 组合总和 II
 */
class CombinationSum2 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CombinationSum2().combinationSum2(
                intArrayOf(10, 1, 2, 7, 6, 1, 5), 8
            ).forEach {
                it.forEach { item ->
                    print(item)
                }
                println()
            }
        }

    }

    private val freq = ArrayList<Array<Int>>()
    private val ans = ArrayList<ArrayList<Int>>()
    private val sequence = ArrayList<Int>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        for (item in candidates) {
            val size = freq.size
            if (freq.isEmpty() || item != freq[size - 1][0]) {
                freq.add(arrayOf(item, 1))
            } else {
                freq[size - 1][1]++
            }
        }
        dfs(0, target)
        return ans
    }

    private fun dfs(pos: Int, rest: Int) {
        if (rest == 0) {
            ans.add(ArrayList(sequence))
            return
        }

        if (pos == freq.size || rest < freq[pos][0]) return

        dfs(pos + 1, rest)

        val most = Math.min(rest / freq[pos][0], freq[pos][1])
        for (i in 1..most) {
            sequence.add(freq[pos][0])
            dfs(pos + 1, rest - i * freq[pos][0])
        }
        for (i in 1..most) {
            sequence.remove(sequence[sequence.size - 1])
        }
    }
}