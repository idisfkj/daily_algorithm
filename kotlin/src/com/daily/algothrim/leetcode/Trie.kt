package com.daily.algothrim.leetcode

/**
 * 208. 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
class Trie {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Trie().apply {
                insert("apple")
                println(search("apple"))
                println(search("app"))
                println(startsWith("app"))
                insert("app")
                println(search("app"))
            }
        }
    }

    /** Initialize your data structure here. */
    class TrieNode {
        var children = Array<TrieNode?>(26) { null }
        var isEnd = false
    }

    private val root = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var p = root
        word.forEach {
            val index = it - 'a'
            if (p.children[index] == null) {
                p.children[index] = TrieNode()
            }
            p = p.children[index]!!
        }
        p.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var p = root
        word.forEach {
            val index = it - 'a'
            if (p.children[index] == null) return false
            p = p.children[index]!!
        }
        return p.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var p = root
        prefix.forEach {
            val index = it - 'a'
            if (p.children[index] == null) return false
            p = p.children[index]!!
        }
        return true
    }

}