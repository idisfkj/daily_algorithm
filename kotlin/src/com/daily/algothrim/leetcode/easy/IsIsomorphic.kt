package com.daily.algothrim.leetcode.easy

/**
 * 205. 同构字符串
 */
class IsIsomorphic {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(IsIsomorphic().isIsomorphic("egg", "add"))
            println(IsIsomorphic().isIsomorphic("foo", "bar"))
        }
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        val s2t = hashMapOf<Char, Char>()
        val t2s = hashMapOf<Char, Char>()

        for (i in s.indices) {
            val x = s[i]
            val y = t[i]
            if (s2t.containsKey(x) && s2t[x] != y || t2s.containsKey(y) && t2s[y] != x) {
                return false
            }
            s2t[x] = y
            t2s[y] = x
        }
        return true
    }
}