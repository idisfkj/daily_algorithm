package com.daily.algothrim.linked.algo;

import com.daily.algothrim.linked.LinkedNode;

/**
 * 两个有序链表的合并
 * 以其中一个有序链表作为结果集(firstLinked)，两个链表从头结点开始向后逐一比较；
 * 1. 结果集(firstLinked)的值小于等于非结果集(secondLinked)的值，结果集(firstLinked)继续向后走一步
 * 2. 如果非结果集(secondLinked)链表的值小于结果集(firstLinked)的值，则将非结果集(secondLinked)的值插入到当前结果集(firstLinked)的前一位
 * 3. 最后逐一比较完之后，非结果集(secondLinked)还有剩余，则将剩余的结点逐一添加到结果集(firstLinked)后面。
 */
public class OrderMerge {

    public static void main(String[] args) {
        new OrderMerge().merge(
                new LinkedNode<>(1,
                        new LinkedNode<>(2,
                                new LinkedNode<>(4,
                                        new LinkedNode<>(5,
                                                new LinkedNode<>(8, null))))),
                new LinkedNode<>(0,
                        new LinkedNode<>(3,
                                new LinkedNode<>(6,
                                        new LinkedNode<>(7,
                                                new LinkedNode<>(10,
                                                        new LinkedNode<>(11, null))))))
        ).printAll();
    }


    /**
     * O(n)
     */
    private LinkedNode<Integer> merge(LinkedNode<Integer> firstLinked, LinkedNode<Integer> secondLinked) {
        // 哨兵
        // fistLinked 定为结果集
        LinkedNode<Integer> result = new LinkedNode<>(-1, firstLinked);
        LinkedNode<Integer> pre = result;

        while (firstLinked != null && secondLinked != null) {
            // 已在结果集firstLinked中，继续下一个节点
            if (firstLinked.value < secondLinked.value) {
                pre = firstLinked;
                firstLinked = firstLinked.next;
                continue;
            }

            // 添加到结果集firstLinked中
            LinkedNode<Integer> temp = secondLinked.next;
            pre.next = secondLinked;
            secondLinked.next = firstLinked;
            pre = secondLinked;
            secondLinked = temp;
        }

        // secondLinked 有剩余，直接添加到尾部
        while (secondLinked != null) {
            pre.next = secondLinked;
            pre = secondLinked;
            secondLinked = secondLinked.next;
        }

        return result.next;
    }
}
