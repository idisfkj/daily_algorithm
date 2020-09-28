package com.daily.algothrim.lookup

import kotlin.random.Random

/**
 * 跳表O(log n)
 */
class SkipList {
    companion object {
        private const val MAX_LEVEL = 16

        @JvmStatic
        fun main(args: Array<String>) {
            val list = SkipList().apply {
                insert(1)
                insert(2)
                insert(5)
                insert(8)
                insert(10)
                insert(22)
                insert(11)
                insert(7)
                insert(32)
            }
            list.printAll()
            println("find: ${list.find(5)}")
            println("find: ${list.find(3)}")
            println("find: ${list.find(32)}")
            println("find: ${list.find(10)}")
            list.delete(3)
            list.delete(5)
            list.insert(18)
            list.insert(50)
            println("find: ${list.find(5)}")
            println("find: ${list.find(8)}")
            list.printAll()
        }
    }

    private val head = Node(-1, 1)
    private var levelCount = 1

    class Node(val data: Int, val currentLevel: Int) {
        // 当前节点对应层的下一个节点
        val forward = Array<Node?>(MAX_LEVEL) {
            null
        }

        override fun toString(): String {
            return buildString {
                append("data: ")
                append(data)
                append(" => ")
                append("level: ")
                append(currentLevel)
                append("\n")
            }
        }
    }

    fun find(value: Int): Node? {
        var i = levelCount - 1
        var p = head

        while (i >= 0) {
            // 找到对应层的区间位置
            while (p.forward[i]?.data ?: Int.MAX_VALUE < value) {
                p = p.forward[i]!!
            }
            i--
        }

        if (p.forward[0]?.data == value) {
            return p.forward[0]
        }

        return null
    }

    fun insert(value: Int) {
        val level = randomLevel()
        val newNode = Node(value, level)
        val update = Array(level) {
            head
        }

        var i = level - 1
        var p = head

        while (i >= 0) {
            // 找到对应层的区间位置
            while (p.forward[i]?.data ?: Int.MAX_VALUE < value) {
                p = p.forward[i]!!
            }
            update[i] = p
            i--
        }

        var j = 0
        while (j < level) {
            newNode.forward[j] = update[j].forward[j]
            update[j].forward[j] = newNode
            j++
        }

        if (level > levelCount) {
            levelCount = level
        }

    }

    fun delete(value: Int) {
        val update = Array<Node?>(levelCount) {
            null
        }

        var p = head
        var i = levelCount - 1

        while (i >= 0) {
            // 找到对应层的区间位置
            while (p.forward[i]?.data ?: Int.MAX_VALUE < value) {
                p = p.forward[i]!!
            }
            update[i] = p
            i--
        }

        if (p.forward[0]?.data == value) {
            var j = levelCount - 1
            while (j >= 0) {
                if (update[j]?.forward?.get(j)?.data == value) {
                    update[j]?.forward?.set(j, update[j]?.forward?.get(j)?.forward?.get(j))
                }
                j--
            }
        }

        while (levelCount > 1 && head.forward[levelCount] == null) {
            levelCount--
        }

    }

    private fun randomLevel(): Int {
        var level = 1
        while(Random.nextInt() % 2 == 1 && level < MAX_LEVEL) {
            level++
        }
        return level
    }

    fun printAll() {
        var p = head
        while (p.forward[0] != null) {
            println("data: ${p.forward[0]?.data}  => level: ${p.forward[0]?.currentLevel}")
            p = p.forward[0]!!
        }
        println()
    }
}