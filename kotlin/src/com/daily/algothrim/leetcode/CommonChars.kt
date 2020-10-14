package com.daily.algothrim.leetcode

/**
 * 查找常用字符(leetcode 1002)
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
class CommonChars {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CommonChars().solution(arrayOf("bella", "label", "roller")).forEach {
                println(it)
            }
            println()
            CommonChars().solution(arrayOf("cool", "lock", "cook")).forEach {
                println(it)
            }
            println()
            CommonChars().solutionV2(arrayOf("bella", "label", "roller")).forEach {
                println(it)
            }
            println()
            CommonChars().solutionV2(arrayOf("cool", "lock", "cook")).forEach {
                println(it)
            }
            println()
            CommonChars().solutionV2(arrayOf("acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd")).forEach {
                println(it)
            }
        }
    }

    fun solution(A: Array<String>): List<String> {
        var result = mutableListOf<String>()
        var temp = mutableListOf<String>()
        if (A.isEmpty()) return emptyList()

        A[0].forEachIndexed { index, c ->
            result.add(index, c.toString())
        }

        var i = 1
        while (i < A.size) {
            A[i].forEach {
                if (result.contains(it.toString())) {
                    temp.add(it.toString())
                    result.remove(it.toString())
                }
            }
            result = temp
            temp = mutableListOf()
            i++
        }

        return result
    }

    /**
     * 计数
     */
    fun solutionV2(A: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val min = IntArray(26) {
            Int.MAX_VALUE
        }
        A.forEach {
            val cur = IntArray(26)
            it.forEach { char ->
                // 统计字符出现的次数
                cur[char - 'a'] = cur[char - 'a'] + 1
            }

            cur.forEachIndexed { index, i ->
                // 所以字符串中对应字符出现的最小次数
                min[index] = min[index].coerceAtMost(i)
            }

        }

        min.forEachIndexed { index, i ->
            var j = 0
            while (j++ < i) {
                result.add(('a' + index).toString())
            }
        }

        return result
    }
}