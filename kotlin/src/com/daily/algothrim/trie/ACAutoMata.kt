package com.daily.algothrim.trie

import java.util.*

/**
 * AC自动机, 字符串多模式串匹配
 */
class ACAutoMata {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ACAutoMata().apply {
                insert("ca".toCharArray())
                insert("bc".toCharArray())
                insert("bcd".toCharArray())
                insert("abcd".toCharArray())
                buildFailurePointer()
                match("kdjafbcfjsk".toCharArray())
            }
        }
    }

    private val root = ACNode('/')

    class ACNode(val data: Char) {
        val children = Array<ACNode?>(26) { null }
        var fail: ACNode? = null
        var isEndingChar: Boolean = false
        var length = -1
    }

    /**
     * 将模式串插入trie树中
     */
    fun insert(text: CharArray) {
        var p = root
        text.forEach {
            val index = it - 'a'
            if (p.children[index] == null) {
                p.children[index] = ACNode(it)
            }
            p = p.children[index]!!
        }
        p.isEndingChar = true
        p.length = text.size
    }

    /**
     * 构建AC自动机
     * O(k * len) k trie树的节点数 len 模式串的平均长度
     */
    private fun buildFailurePointer() {
        val queue = LinkedList<ACNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val p = queue.remove()
            var i = 0
            while (i < 26) {
                val pc = p.children[i++] ?: continue
                if (p == root) {
                    pc.fail = root
                } else {
                    var q = p.fail
                    while (q != null) {
                        val qc = q.children[pc.data - 'a']
                        if (qc != null) {
                            pc.fail = qc
                            break
                        }
                        q = q.fail
                    }
                    if (q == null) {
                        pc.fail = root
                    }
                }
                queue.add(pc)
            }
        }
    }

    /**
     * 匹配主串
     * O(n * len) n 主串长度 len 匹配的模式串长度
     */
    private fun match(text: CharArray): Boolean {
        var p: ACNode? = root
        text.forEachIndexed { i, c ->
            val index = c - 'a'
            while (p?.children?.get(index) == null && p != root) {
                p = p?.fail
            }
            p = p?.children?.get(index)
            if (p == null) p = root

            var temp = p
            while (temp != null) {
                if (temp.isEndingChar) {
                    println("match success! start: ${i - temp.length + 1}, match size: ${temp.length}")
                    return true
                }
                temp = temp.fail
            }
        }
        println("match failure!")
        return false
    }

}