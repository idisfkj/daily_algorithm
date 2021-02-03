package com.daily.algothrim.leetcode

import java.util.*

/**
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 */
class MedianSlidingWindow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MedianSlidingWindow().solution(intArrayOf(1,3,-1,-3,5,3,6,7), 3).forEach {
                println(it)
            }
            println()
            MedianSlidingWindow().solution(intArrayOf(1, 4, 2, 3), 4).forEach {
                println(it)
            }
            println()
            MedianSlidingWindow().solution(intArrayOf(2147483647,2147483647), 2).forEach {
                println(it)
            }
        }
    }

    // nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
    // 返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
    // O(nlogn)
    // O(n)
    fun solution(nums: IntArray, k: Int): DoubleArray {
        val dh = DualHeap(k)
        for (i in 0 until k) {
            dh.insert(nums[i])
        }
        val result = DoubleArray(nums.size - k + 1)

        result[0] = dh.getMedian()

        for (j in k until nums.size) {
            dh.insert(nums[j])
            dh.erase(nums[j - k])
            result[j - k + 1] = dh.getMedian()
        }

        return result
    }

    class DualHeap(private val k: Int) {

        private val small = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
            return@Comparator o2.compareTo(o1)
        })

        private val large = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
            return@Comparator o1.compareTo(o2)
        })

        private val delayed = hashMapOf<Int, Int>()

        private var smallSize = 0
        private var largeSize = 0

        fun getMedian(): Double {
            return if (k.and(1) == 1) small.peek().toDouble() else ((small.peek().toDouble() + large.peek().toDouble())) / 2
        }

        fun insert(num: Int) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num)
                ++smallSize
            } else {
                large.offer(num)
                ++largeSize
            }
            makeBalance()
        }

        fun erase(num: Int) {
            delayed[num] = delayed.getOrDefault(num, 0) + 1

            if (num <= small.peek()) {
                --smallSize
                if (num == small.peek()) {
                    prune(small)
                }
            } else {
                --largeSize
                if (num == large.peek()) {
                    prune(large)
                }
            }
            makeBalance()
        }

        private fun prune(heap: PriorityQueue<Int>) {
            while (heap.isNotEmpty()) {
                val num = heap.peek()
                if (delayed.containsKey(num)) {
                    delayed[num] = delayed[num]?.minus(1) ?: 0
                    if (delayed[num] == 0) {
                        delayed.remove(num)
                    }
                    heap.poll()
                } else {
                    break
                }
            }
        }

        private fun makeBalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll())
                --smallSize
                ++largeSize
                prune(small)
            } else if (smallSize < largeSize) {
                small.offer(large.poll())
                ++smallSize
                --largeSize
                prune(large)
            }
        }

    }
}