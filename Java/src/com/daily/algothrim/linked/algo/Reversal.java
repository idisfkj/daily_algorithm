package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 单链表反转
 */
public class Reversal {

    public static void main(String[] args) {
        new Reversal().reversal(new LinkedNode<>("a",
                new LinkedNode<>("b",
                        new LinkedNode<>("c",
                                new LinkedNode<>("d",
                                        new LinkedNode<>("a", null)))))).printAll();
    }

    /**
     * O(n)
     */
    private LinkedNode<String> reversal(LinkedNode<String> singleLinked) {
        LinkedNode<String> result = null;
        LinkedNode<String> temp;

        while (singleLinked != null) {
            temp = singleLinked.next;
            singleLinked.next = result;
            result = singleLinked;
            singleLinked = temp;
        }

        return result;
    }
}
