package com.daily.algothrim.sort;

/**
 * 冒泡排序
 * 稳定排序
 * 原地排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a, a.length);
        for (int value : a) {
            System.out.println(value);
        }

        System.out.println();

        int[] b = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        bubbleSort.optSort(b, b.length);
        for (int value : b) {
            System.out.println(value);
        }
    }

    /**
     * O(n2)
     */
    private void sort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private void optSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }
}
