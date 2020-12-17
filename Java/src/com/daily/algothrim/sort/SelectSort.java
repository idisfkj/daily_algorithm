package com.daily.algothrim.sort;

/**
 * 选择排序
 * 不稳定排序
 * 原地排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        new SelectSort().sort(a, a.length);
        for (int value : a) {
            System.out.println(value);
        }
    }

    /**
     * O(n2)
     */
    private void sort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int min = a[i];
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    k = j;
                }
            }
            a[k] = a[i];
            a[i] = min;
        }
    }
}
