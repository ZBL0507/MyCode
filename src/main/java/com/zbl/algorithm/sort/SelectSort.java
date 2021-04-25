package com.zbl.algorithm.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {234, 456547, 879, 890, 0, 4, 76, -3, -4375, 657, 234324, 457};
        selectSort(arr);
    }

    /**
     * 选择排序
     *
     * @param arr 待排序的数组，这里使用整形数组演示算法
     */
    @SuppressWarnings("all")
    public static void selectSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
