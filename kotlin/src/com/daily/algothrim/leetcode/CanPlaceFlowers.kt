package com.daily.algothrim.leetcode

/**
 * 605. 种花问题
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * */
class CanPlaceFlowers {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanPlaceFlowers().solution(intArrayOf(0, 1, 1, 0, 0, 1, 1), 1))
        }
    }


    /**
     * O(n)
     */
    fun solution(flowerbed: IntArray, n: Int): Boolean {
        var i = 0
        val size = flowerbed.size
        var num = 0
        while (i < size) {
            if (flowerbed[i] == 0 && (i == size - 1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1
                num++
            }
            i++
        }

        return num >= n
    }
}