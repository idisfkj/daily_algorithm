package com.daily.algothrim.bitmap

import kotlin.random.Random

/**
 * 位图
 */
class BitMap(private val nBits: Int) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            BitMap(100000000).apply {
                var i = 0
                while (i++ < 100000000) {
                    val random = Random.nextInt(1000000000)
                    set(random)
                }
                testTemp.forEach {
                    if (!get(it)) {
                        return@apply
                    }
                }
                print("success!")
            }
        }
    }

    private val array = IntArray(nBits / 32 + 1) // 32 int 数据占32位
    private val testTemp = ArrayList<Int>() // 测试集合

    fun set(k: Int) {
        if (k > nBits) return
        testTemp.add(k)
        val bBite = k / 32
        val bBiteIndex = k % 32
        array[bBite] = array[bBite].or(1.shl(bBiteIndex))
    }

    fun get(k: Int): Boolean {
        if (k > nBits) return false
        val bBite = k / 32
        val bBiteIndex = k % 32
        return array[bBite].and(1.shl(bBiteIndex)) != 0
    }

}