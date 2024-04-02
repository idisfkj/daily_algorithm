package com.daily.algothrim.leetcode.top150

import com.daily.algothrim.leetcode.ListNode
import java.util.Stack

/**
 * 82. 删除排序链表中的重复元素 II
 */

/*
给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。

示例 1：

输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：

输入：head = [1,1,1,2,3]
输出：[2,3]
 
提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
 */
class DeleteDuplicates {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DeleteDuplicates().deleteDuplicates(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(5)
                                }
                            }
                        }
                    }
                }
            })?.printAll()
            println()
            DeleteDuplicates().deleteDuplicates(ListNode(1).apply {
                next = ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(3)
                        }
                    }
                }
            })?.printAll()
            println()
            DeleteDuplicates().deleteDuplicates2(ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(4).apply {
                                    next = ListNode(5)
                                }
                            }
                        }
                    }
                }
            })?.printAll()
            println()
            DeleteDuplicates().deleteDuplicates2(ListNode(1).apply {
                next = ListNode(1).apply {
                    next = ListNode(1).apply {
                        next = ListNode(2).apply {
                            next = ListNode(3)
                        }
                    }
                }
            })?.printAll()
        }
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        val guard = ListNode(-1)
        guard.next = head
        val stack = Stack<ListNode>()
        var temp = head

        while (temp != null) {
            if (stack.isNotEmpty() && temp.`val` == stack.peek().`val`) {
                while (temp?.next != null && temp.next?.`val` == stack.peek().`val`) {
                    temp = temp.next
                }
                stack.pop()
                if (stack.isEmpty()) {
                    guard.next = temp?.next
                } else {
                    stack.peek().next = temp?.next
                }
            } else {
                if (stack.isEmpty()) guard.next = temp
                stack.push(temp)
            }
            temp = temp?.next
        }
        return guard.next
    }

    fun deleteDuplicates2(head: ListNode?): ListNode? {
        val guard = ListNode(-1)
        guard.next = head
        var cur: ListNode? = guard

        while (cur?.next != null && cur.next?.next != null) {
            if (cur.next?.`val` == cur.next?.next?.`val`) {
                val value = cur.next?.`val`
                while (cur.next != null && cur.next?.`val` == value) {
                    cur.next = cur.next?.next
                }
            } else {
                cur = cur.next
            }
        }
        return guard.next
    }

}