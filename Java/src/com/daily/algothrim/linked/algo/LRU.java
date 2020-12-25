package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 使用单链表实现LRU
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 2.1 如果此时缓存未满，则将此结点直接插入到链表的头部;
 * 2.2 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 */
public class LRU {

    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        LRU lru = new LRU();

        lru.cache(lru.cache(lru.cache(lru.cache(lru.cache(lru.cache(lru.cache(null, 1), 2), 3), 4), 5), 4), 6).printAll();
    }

    /**
     * O(n)
     */
    private LinkedNode<Integer> cache(LinkedNode<Integer> singleLinked, int item) {
        // 缓存为空
        if (singleLinked == null) return new LinkedNode<>(item, null);

        // 头节点
        if (singleLinked.value == item) return singleLinked;

        LinkedNode<Integer> pre = singleLinked;
        LinkedNode<Integer> temp = singleLinked;
        int size = 1;

        while (temp.next != null) {
            LinkedNode<Integer> current = temp.next;
            // 存在缓存, 移到头节点
            if (current.value == item) {
                temp.next = current.next;
                current.next = singleLinked;
                return current;
            }
            size++;
            pre = temp;
            temp = temp.next;
        }

        // 缓存已满，删除尾节点
        if (size == MAX_SIZE) {
            pre.next = null;
        }

        // 将新数据移到到头节点
        return new LinkedNode<>(item, singleLinked);
    }
}
