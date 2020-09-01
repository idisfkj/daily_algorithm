package com.daily.algothrim.linked

class LinkedNode<T>(var value: T, var next: LinkedNode<T>? = null) {

    fun printAll() {
        println("$value")
        var temp = next
        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }

}