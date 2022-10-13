package com.daily.algothrim.leetcode.easy

/**
 * 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 */
class PlusOne {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PlusOne().plusOne(intArrayOf(1, 2, 3)).forEach {
                print(it)
            }
            println()
            PlusOne().plusOne(intArrayOf(4, 3, 2, 1)).forEach {
                print(it)
            }
            println()
            PlusOne().plusOne(intArrayOf(0)).forEach {
                print(it)
            }
        }
    }

    fun plusOne(digits: IntArray): IntArray {
        val size = digits.size
        for (i in size - 1 downTo 0) {
            if (digits[i] != 9) {
                digits[i]++
                for (j in i + 1 until size) {
                    digits[j] = 0
                }
                return digits
            }
        }
        val result = IntArray(size + 1)
        result[0] = 1
        return result
    }
}