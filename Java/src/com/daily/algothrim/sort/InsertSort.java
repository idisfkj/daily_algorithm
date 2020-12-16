package com.daily.algothrim.sort;

/**
 * 插入排序
 * 原地排序
 * 稳定排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        new InsertSort().sort(a, a.length);
        for (int value : a) {
            System.out.println(value);
        }
    }


    /**
     * O(n2)
     */
    private void sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
