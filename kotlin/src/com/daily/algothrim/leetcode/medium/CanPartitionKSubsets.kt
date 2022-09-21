package com.daily.algothrim.leetcode.medium

/**
 * 698. 划分为k个相等的子集
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 */
class CanPartitionKSubsets {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                CanPartitionKSubsets().canPartitionKSubsets(
                    intArrayOf(4, 3, 2, 3, 5, 2, 1), 4
                )
            )
            println(
                CanPartitionKSubsets().canPartitionKSubsets(
                    intArrayOf(1, 2, 3, 4), 3
                )
            )
            println(
                CanPartitionKSubsets().canPartitionKSubsets(
                    intArrayOf(1, 1, 1, 1, 2, 2, 2, 2), 4
                )
            )
        }
    }

    /**
     * 状态压缩 + 记忆化搜索
     */
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        var total = 0
        nums.forEach {
            total += it
        }
        // 不能整除，代表划分不成功
        if (total % k != 0 || nums.isEmpty()) return false
        // 获得每个子集的和，即平均值
        val average = total / k
        nums.sort()
        // 如果排序后，最大值大于平均值，则失败
        if (nums[nums.size - 1] > average) return false
        // 由于 1 <= k <= len(nums) <= 16，所以可以使用正整数s的各个位数来代表每个数的使用情况
        // 1代表未使用，0代表已经使用
        // 同时 s 代表对应的状态个数
        // 例如 k = 4（后续都已4为例）, 对应的s = 16, 即存在16种不同的状态，那么1.shl(4) = 10000 = 16
        // 默认值都为true
        val dp = BooleanArray(1.shl(nums.size)) { true }
        // 1.shl(num.size) - 1  => 1.shl(4) - 1 = 1111 = 15 各个位数都为1代表都未使用
        // p = 0 代表当前的和，初始都未选中，所以为0
        return dfs(nums, average, dp, nums.size, 1.shl(nums.size) - 1, 0)
    }

    private fun dfs(nums: IntArray, average: Int, dp: BooleanArray, n: Int, s: Int, p: Int): Boolean {
        // 如果s = 0 代表0000，各个位数都未0，即nums中的数据都已经使用，且符合条件
        if (s == 0) return true
        // 如果当前S状态已经使用过，即false，则直接返回，跳过
        if (!dp[s]) return dp[s]
        // 标记当前S 的状态已经使用过
        dp[s] = false
        // 遍历nums中各个数
        for (i in 0 until n) {
            // 如果加上当前i的值后，超过平均值，则跳过该值，不做选择
            if (nums[i] + p > average) break
            // 否则，进行标记选择当前值
            // 在标记选择之前，判断当前i值是否已经选择过
            // 这里通过s右运算i位，再与1做且运算，即得到当前i位数的值，如果不为0，则进入下一个数据的选择
            // 例如 s = 1111 = 15, i = 2
            // 1111.shr(2) = 0011, 0011.and(0001) = 0001 != 0
            if ((s.shr(i).and(1)) != 0) {
                // 选择i之后，改变s,进入选中i之后的状态
                // s = 1111, i = 2
                // s = 1111  => 1011(选择i之后的状态)
                // 这里通过 s.xor(1.shl(i)) 来获取这个值： 1011
                // 例如
                // 1111.xor(1.shl(2)) => 1111.xor(0100) => 1011
                // 最后 p为，(p + num[i]) % average
                // 这里取模是为了过滤到下一个子集的选取，即如果当前刚好等于平均值，则继续一个符合的子集。即从0开始。
                if (dfs(nums, average, dp, n, s.xor(1.shl(i)), (p + nums[i]) % average)) {
                    return true
                }
            }
        }
        return false
    }

}