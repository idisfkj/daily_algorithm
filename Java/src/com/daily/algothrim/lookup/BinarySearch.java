package com.daily.algothrim.lookup;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 6, 9, 29, 93, 95, 213, 741};
        System.out.println(new BinarySearch().search(a, a.length, 93));
    }

    /**
     * O(log n)
     */
    private int search(int[] a, int n, int value) {
        int start = 0;
        int end = n - 1;

        while (end >= start) {
            // 注意运算优先级
            int mid = start + ((end - start) >> 1);
            if (value == a[mid]) {
                return mid;
            } else if (value < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
