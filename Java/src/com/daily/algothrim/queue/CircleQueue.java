package com.daily.algothrim.queue;

/**
 * 基于数组的循环队列
 */
public class CircleQueue {

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(6);
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("2"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("3"));
        System.out.println(queue.enqueue("4"));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("5"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("6"));
        System.out.println(queue.enqueue("7"));
        System.out.println(queue.enqueue("8"));
        System.out.println(queue.enqueue("9"));
        System.out.println(queue.enqueue("10"));
    }

    private int n;
    private int head;
    private int tail;
    private String[] queue;

    private CircleQueue(int capacity) {
        n = capacity;
        queue = new String[n];
    }

    private boolean enqueue(String item) {
        // 队满，会浪费一个存储空间
        if ((tail + 1) % n == head) return false;
        queue[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    private String dequeue() {
        if (tail == head) return null;
        String item = queue[head];
        head = (head + 1) % n;
        return item;
    }

}
