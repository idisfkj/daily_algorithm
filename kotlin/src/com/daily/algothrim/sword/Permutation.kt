package com.daily.algothrim.sword

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
class Permutation {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = Permutation().permutation("abc")
            result.forEach {
                println(it)
            }
        }
    }

    fun permutation(s: String): Array<String> {
        val result = arrayListOf<String>()
        val c = s.toCharArray()
        dfs(0, c, result)
        return result.toArray(arrayOf())
    }

    private fun dfs(x: Int, c: CharArray, res: MutableList<String>) {
        if (x == c.size - 1) {
            res.add(c.contentToString())
            return
        }
        val set = hashSetOf<Char>()
        for (i in x until c.size) {
            if (set.contains(c[i])) continue
            set.add(c[i])
            swap(x, i, c)
            dfs(x + 1, c, res)
            swap(i, x, c)
        }
    }

    private fun swap(x: Int, i: Int, c: CharArray) {
        val temp = c[x]
        c[x] = c[i]
        c[i] = temp
    }
}