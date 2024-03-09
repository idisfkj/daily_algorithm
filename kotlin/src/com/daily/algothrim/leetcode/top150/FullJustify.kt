package com.daily.algothrim.leetcode.top150

/**
 * 68. 文本左右对齐
 */

/*
给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

注意:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。


示例 1:

输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
示例 2:

输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。
     第二行同样为左对齐，这是因为这行只包含一个单词。
示例 3:

输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]


提示:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] 由小写英文字母和符号组成
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */
class FullJustify {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            FullJustify().fullJustify(
                arrayOf(
                    "This", "is", "an", "example", "of", "text", "justification."
                ), 16
            ).forEach {
                println(it)
            }
            println()

            FullJustify().fullJustify(
                arrayOf(
                    "What", "must", "be", "acknowledgment", "shall", "be"
                ), 16
            ).forEach {
                println(it)
            }
            println()

            FullJustify().fullJustify(
                arrayOf(
                    "Science",
                    "is",
                    "what",
                    "we",
                    "understand",
                    "well",
                    "enough",
                    "to",
                    "explain",
                    "to",
                    "a",
                    "computer.",
                    "Art",
                    "is",
                    "everything",
                    "else",
                    "we",
                    "do"
                ), 20
            ).forEach {
                println(it)
            }
        }
    }

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ans = ArrayList<String>()
        var right = 0
        val n = words.size
        while (true) {
            val left = right // 当前行的第一个单词在 words 的位置
            var sumLen = 0 // 统计这一行单词长度之和
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < n && sumLen + words[right].length + right - left <= maxWidth) {
                sumLen += words[right++].length
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                val sb = join(words, left, n, " ")
                sb.append(blank(maxWidth - sb.length))
                ans.add(sb.toString())
                return ans
            }

            val numWords = right - left
            val numSpaces = maxWidth - sumLen

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                val sb = StringBuffer(words[left])
                sb.append(blank(numSpaces))
                ans.add(sb.toString())
                continue
            }

            // 当前行不只一个单词
            val avgSpaces = numSpaces / (numWords - 1)
            val extraSpaces = numSpaces % (numWords - 1)
            val sb = StringBuffer()
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))) // 拼接额外加一个空格的单词
            sb.append(blank(avgSpaces))
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))) // 拼接其余单词
            ans.add(sb.toString())
        }
    }

    // blank 返回长度为 n 的由空格组成的字符串
    private fun blank(n: Int): String {
        val sb = StringBuffer()
        for (i in 0 until n) {
            sb.append(' ')
        }
        return sb.toString()
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    private fun join(words: Array<String>, left: Int, right: Int, sep: String): StringBuffer {
        val sb = StringBuffer(words[left])
        for (i in left + 1 until right) {
            sb.append(sep)
            sb.append(words[i])
        }
        return sb
    }
}