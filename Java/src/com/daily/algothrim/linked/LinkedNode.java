package com.daily.algothrim.linked;

public class LinkedNode<T> {
    public T value;
    public LinkedNode<T> next;

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void printAll() {
        System.out.println(value);
        LinkedNode<T> temp = next;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
