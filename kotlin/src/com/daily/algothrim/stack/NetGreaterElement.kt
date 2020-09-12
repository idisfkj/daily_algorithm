package com.daily.algothrim.stack

import java.util.*

/**
 * 下一个更大元素 I(LeetCode 496)
 *
 * 给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:

 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1。
 *
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2的数组大小都不超过1000。
 *
 * 1. 遍历nums2数组，在遍历之后将对应的数据压入栈中，用栈来保存之前遍历的数据
 * 2. 在遍历nums2数组时，当前值每次都循环与栈顶元素（之前的数据）做比较，如果栈不为空且当前数据大于栈顶数据，则将栈顶元素出栈，
 * 并将栈顶元素作为key与当前元素作为value保存到map中；此时map中保存的就是nums1中对应数据在num2中对应位置的右边的第一个比其大的值（如果存在大话）
 * 3. 遍历nums1与map中的数据进行匹配，不存在则对应位置默认-1
 *
 */
class NetGreaterElement {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            NetGreaterElement().solution(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).forEach {
                println(it)
            }
        }
    }

    fun solution(nums1: IntArray, nums2: IntArray): IntArray {
        val stack = Stack<Int>()
        val map = mutableMapOf<Int, Int>()

        var i = 0
        while (i < nums2.size) {
            while (stack.isNotEmpty() && nums2[i] > stack.peek()) {
                map[stack.pop()] = nums2[i]
            }
            stack.push(nums2[i++])
        }

        nums1.forEachIndexed { index, item ->
            nums1[index] = map.getOrDefault(item, -1)
        }

        return nums1
    }
}