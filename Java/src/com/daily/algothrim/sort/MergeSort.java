package com.daily.algothrim.sort;

/**
 * 归并排序
 * 稳定排序
 * 不是原地排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{10, 1, 4, 2, 5, 643, 654, 234, 2};
        new MergeSort().sort(a, 0, a.length - 1);
        for (int value : a) {
            System.out.println(value);
        }
    }

    /**
     * 时间复杂度: O(nlog n)
     * 空间复杂度: O(n)
     */
    private void sort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, end);
        }
    }

    private void merge(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, a, start, temp.length);
    }
}
