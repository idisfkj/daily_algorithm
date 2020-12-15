package com.daily.algothrim.sort;

/**
 * 计数排序
 * 稳定排序
 * 非原地排序
 */
public class CountSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4, 3, 5, 3, 2, 1, 5, 0, 0, 4, 6};
        new CountSort().sort(a, a.length);
        for (int value : a) {
            System.out.println(value);
        }
    }

    /**
     * O(n)
     */
    private void sort(int[] a, int n) {

        // 找到最大值
        int max = 0;
        for (int value : a) {
            if (max < value) max = value;
        }

        // 计数
        int[] count = new int[max + 1];
        for (int value : a) {
            count[value]++;
        }

        // 求和
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // 排序
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            temp[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }

        // 拷贝
        System.arraycopy(temp, 0, a, 0, n);

    }
}
