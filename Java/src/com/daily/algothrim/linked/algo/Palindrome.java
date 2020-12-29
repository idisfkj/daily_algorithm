package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 单链表判断回文
 * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(new LinkedNode<>("2",
                new LinkedNode<>("3",
                        new LinkedNode<>("4",
                                new LinkedNode<>("3",
                                        new LinkedNode<>("2", null)))))));
    }

    /**
     * O(n)
     */
    private boolean isPalindrome(LinkedNode<String> singleLinked) {

        if (singleLinked == null || singleLinked.next == null) return true;

        LinkedNode<String> reversalLinked = null;
        LinkedNode<String> fast = singleLinked;
        LinkedNode<String> slow = singleLinked;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            LinkedNode<String> temp = slow.next;
            slow.next = reversalLinked;
            reversalLinked = slow;
            slow = temp;
        }

        LinkedNode<String> temp = slow.next;
        slow.next = reversalLinked;
        reversalLinked = slow;
        slow = temp;

        if (fast.next == null) { // odd
            reversalLinked = reversalLinked.next;
        }

        while (reversalLinked != null && slow != null) {
            if (!reversalLinked.value.equals(slow.value)) return false;
            slow = slow.next;
            reversalLinked = reversalLinked.next;
        }

        return true;
    }
}
