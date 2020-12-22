package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 链表中环的检测
 * 使用快慢指针，慢指针每次走一步，快指针每次走两步；当快指针等于慢指针时，说明快指针已经领先慢指针一圈，即该链表存在环。
 */
public class Circle {

    public static void main(String[] args) {
        LinkedNode<Integer> head = new LinkedNode<>(1, null);
        head.setNext(new LinkedNode<>(2,
                new LinkedNode<>(3,
                        new LinkedNode<>(2,
                                new LinkedNode<>(1, head)))));
        System.out.println(new Circle().existCircle(head));
    }

    /**
     * O(n)
     */
    private boolean existCircle(LinkedNode<Integer> linkedList) {
        LinkedNode<Integer> fast = linkedList;
        LinkedNode<Integer> slow = linkedList;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) return true;
        }

        return false;
    }
}
