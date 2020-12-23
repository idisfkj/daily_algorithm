package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 删除链表倒数第 n 个结点
 * 使用快慢指针，快指针先走n步，然后快慢指针再一起走，直到快指针走到链表尾部，此时慢指针的位置即为链表倒数第n个结点
 */
public class DeleteLastN {

    public static void main(String[] args) {
        LinkedNode<String> result = new DeleteLastN().delete(new LinkedNode<>("a",
                new LinkedNode<>("b",
                        new LinkedNode<>("c",
                                new LinkedNode<>("d",
                                        new LinkedNode<>("e",
                                                new LinkedNode<>("f",
                                                        new LinkedNode<>("g", null))))))), 3);
        if (result != null) {
            result.printAll();
        }
    }

    /**
     * O(n)
     */
    private LinkedNode<String> delete(LinkedNode<String> singleLinked, int n) {
        if (n <= 0) return singleLinked;

        LinkedNode<String> result = new LinkedNode<>("#", singleLinked);
        LinkedNode<String> pre = result;
        LinkedNode<String> fast = singleLinked;
        LinkedNode<String> slow = singleLinked;

        while (fast != null && --n > 0) {
            fast = fast.next;
        }

        if (n != 0) throw new IllegalStateException("The size of singleLinked less than " + n);

        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow.next;

        return result.next;
    }
}
