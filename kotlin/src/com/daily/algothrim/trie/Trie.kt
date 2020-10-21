package com.daily.algothrim.trie

/**
 * Trie树，解决字符串查询
 */
class Trie {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Trie().apply {
                insert("hello".toCharArray())
                insert("her".toCharArray())
                insert("hi".toCharArray())
                insert("how".toCharArray())
                insert("so".toCharArray())
                insert("see".toCharArray())
                println(find("see".toCharArray()))
            }
        }
    }

    private val root = TrieNode('/')

    class TrieNode(val data: Char) {
        val children = Array<TrieNode?>(26) { null }
        var isEndingChar = false
    }

    /**
     * O(n)所有字符串的长度之和
     */
    fun insert(text: CharArray) {
        var p = root
        text.forEach {
            val index = it - 'a'
            if (p.children[index] == null) {
                p.children[index] = TrieNode(it)
            }
            p = p.children[index]!!
        }
        p.isEndingChar = true
    }

    /**
     * O(k)查询的字符串长度
     */
    fun find(text: CharArray): Boolean {
        var p = root
        text.forEach {
            val index = it - 'a'
            if (p.children[index] == null) return false
            p = p.children[index]!!
        }
        return p.isEndingChar
    }

}