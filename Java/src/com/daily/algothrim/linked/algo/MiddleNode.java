package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 求链表的中间结点
 * 快慢指针
 */
public class MiddleNode {

    public static void main(String[] args) {
        new MiddleNode().middle(new LinkedNode<>("a",
                new LinkedNode<>("b",
                        new LinkedNode<>("c",
                                new LinkedNode<>("d",
                                        new LinkedNode<>("e",
                                                new LinkedNode<>("f",
                                                        new LinkedNode<>("g", null)))))))).printAll();
    }

    /**
     * O(n)
     */
    private LinkedNode<String> middle(LinkedNode<String> singleLinked) {
        LinkedNode<String> fast = singleLinked;
        LinkedNode<String> slow = singleLinked;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
