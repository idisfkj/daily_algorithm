package com.daily.algothrim.leetcode

/**
 * 1232. 缀点成线
 *
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 */
class CheckStraightLine {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CheckStraightLine().solution(arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(6, 7)
            )))
            println(CheckStraightLine().solution(arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(7, 7)
            )))
        }
    }

    fun solution(coordinates: Array<IntArray>): Boolean {
        return binary(coordinates, 0, coordinates.size - 1)
    }

    private fun binary(coordinates: Array<IntArray>, start: Int, end: Int): Boolean {
        // 注意 end - 1，代表区间就两个数就不需要判断
        if (start < end - 1) {
            val mid = (start + end).shr(1)
            val startX = coordinates[start][0]
            val startY = coordinates[start][1]
            val midX = coordinates[mid][0]
            val midY = coordinates[mid][1]
            val endX = coordinates[end][0]
            val endY = coordinates[end][1]

            if ((midX - startX).times(endY - midY) != (midY - startY).times(endX - midX)) return false
            if (!binary(coordinates, start, mid) || !binary(coordinates, mid, end)) return false
        }
        return true
    }

}