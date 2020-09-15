package com.daily.algothrim.stack

import java.util.*

/**
 * 比较含退格的字符串(LeetCode 844)
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 */
class BackSpaceCompare {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(BackSpaceCompare().isEqual("ab#c", "ad#c"))
            println(BackSpaceCompare().isEqual("ab##", "c#d#"))
            println(BackSpaceCompare().isEqual("a##c", "#a#c"))
            println(BackSpaceCompare().isEqual("a#c", "b"))

            // O(N) 的时间复杂度和 O(1) 的空间复杂度
            println(BackSpaceCompare().isEqualO1("ab#c", "ad#c"))
            println(BackSpaceCompare().isEqualO1("ab##", "c#d#"))
            println(BackSpaceCompare().isEqualO1("a##c", "#a#c"))
            println(BackSpaceCompare().isEqualO1("a#c", "b"))
        }
    }

    fun isEqual(S: String, T: String): Boolean {
        return simplify(S) == simplify(T)
    }

    private fun simplify(s: String): String {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '#') {
                if (stack.isNotEmpty()) stack.pop()
            } else {
                stack.push(it)
            }
        }
        return buildString {
            while (stack.isNotEmpty()) {
                append(stack.pop())
            }
        }
    }

    // O(N) 的时间复杂度和 O(1) 的空间复杂度
    fun isEqualO1(S: String, T: String): Boolean {
        var i = nextValidIndex(S, S.length)
        var j = nextValidIndex(T, T.length)

        while (i >= 0 && j >= 0) {
            if (S[i] != T[j]) return false
            i = nextValidIndex(S, i)
            j = nextValidIndex(T, j)
        }

        return i == j
    }

    // 找到下一个有效字符的位置
    private fun nextValidIndex(s: String, index: Int): Int {
        var i = index
        var backCount = 0

        while (--i >= 0) {
            if (s[i] == '#') {
                backCount++
            } else {
                if (backCount == 0) return i
                backCount--
            }
        }
        return i
    }

}