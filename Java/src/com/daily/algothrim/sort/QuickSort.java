package com.daily.algothrim.sort;

/**
 * 快速排序
 * 不稳定排序
 * 原地排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        new QuickSort().sort(a, 0, a.length - 1);
        for (int value : a) {
            System.out.println(value);
        }
    }

    /**
     * 时间复制度O(nlog n); 最好时间复杂度O(nlog n); 最坏时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    private void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = quick(a, start, end);
            sort(a, start, mid - 1);
            sort(a, mid + 1, end);
        }
    }

    private int quick(int[] a, int start, int end) {
        int i = start;
        int j = start;
        int pivot = a[end];

        for (; j < end; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }

        int temp = a[i];
        a[i] = pivot;
        a[end] = temp;

        return i;
    }
}
