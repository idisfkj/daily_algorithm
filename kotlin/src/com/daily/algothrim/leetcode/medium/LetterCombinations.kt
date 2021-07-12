package com.daily.algothrim.leetcode.medium

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
class LetterCombinations {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LetterCombinations().letterCombinations("23").forEach {
                println(it)
            }
            LetterCombinations().letterCombinations("").forEach {
                println(it)
            }
            LetterCombinations().letterCombinations("2").forEach {
                println(it)
            }
        }
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return arrayListOf()
        val letterMap = hashMapOf<Int, String>()
        letterMap[2] = "abc"
        letterMap[3] = "def"
        letterMap[4] = "ghi"
        letterMap[5] = "jkl"
        letterMap[6] = "mno"
        letterMap[7] = "pqrs"
        letterMap[8] = "tuv"
        letterMap[9] = "wxyz"

        // 234
        val length = digits.length
        val result = arrayListOf<String>()
        backtracking(letterMap, 0, digits, StringBuilder(), length, result)
        return result
    }

    private fun backtracking(letterMap: Map<Int, String>, index: Int, digits: String, letterBuilder: StringBuilder, length: Int, result: ArrayList<String>) {
        if (index == length) {
            result.add(letterBuilder.toString())
            return
        }
        val currentLetter = letterMap[digits[index] - '0'] ?: ""
        val size = currentLetter.length
        for (i in 0 until size) {
            letterBuilder.append(currentLetter[i].toString())
            backtracking(letterMap, index + 1, digits, letterBuilder, length, result)
            letterBuilder.deleteCharAt(index)
        }
    }
}