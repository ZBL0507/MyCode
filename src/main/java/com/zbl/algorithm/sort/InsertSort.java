package com.zbl.algorithm.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 3, -1, 0, 56, 7, 9};
        insertSort(arr);
    }

    /**
     * 插入排序
     *
     * @param arr 待排序的数组，这里使用整形演示算法
     */
    public static void insertSort(int[] arr) {
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while (key < arr[j]) {
                j--;
                if (j == -1)
                    break;
            }
            for (int k = i; k > j + 1; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j + 1] = key;
        }
    }
}
