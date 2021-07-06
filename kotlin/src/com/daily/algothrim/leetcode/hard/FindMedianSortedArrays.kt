package com.daily.algothrim.leetcode.hard

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 */
class FindMedianSortedArrays {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindMedianSortedArrays().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
            println(FindMedianSortedArrays().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
        }
    }

    /**
     * lg(n+m)
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        val totalSize = size1 + size2
        return if (totalSize % 2 == 1) {
            val k = totalSize / 2
            getKthElement(nums1, nums2, k + 1)
        } else {
            val k1 = totalSize / 2
            val k2 = totalSize / 2 - 1
            (getKthElement(nums1, nums2, k1 + 1) + getKthElement(nums1, nums2, k2 + 1)) / 2.0
        }
    }

    private fun getKthElement(nums1: IntArray, nums2: IntArray, k: Int): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        var index1 = 0
        var index2 = 0
        var kthElement = k

        while (true) {
            if (index1 == size1) {
                return nums2[index2 + kthElement - 1].toDouble()
            }

            if (index2 == size2) {
                return nums1[index1 + kthElement - 1].toDouble()
            }

            if (kthElement == 1) return Math.min(nums1[index1], nums2[index2]).toDouble()

            val half = kthElement / 2
            val currentIndex1 = Math.min(index1 + half, size1) - 1
            val currentIndex2 = Math.min(index2 + half, size2) - 1
            val node1 = nums1[currentIndex1]
            val node2 = nums2[currentIndex2]
            if (node1 <= node2) {
                kthElement -= currentIndex1 - index1 + 1
                index1 = currentIndex1 + 1
            } else {
                kthElement -= currentIndex2 - index2 + 1
                index2 = currentIndex2 + 1
            }
        }
    }
}