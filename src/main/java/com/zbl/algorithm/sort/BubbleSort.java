package com.zbl.algorithm.sort;


public class BubbleSort {
    public static void main(String[] args) {

        int[] arr1 = {1, 32432, 56, 687, 879, -345, 74, 768};

        bubbleSortV1(arr1);
        bubbleSortV2(arr1);

    }

    /**
     * 冒泡排序v1
     *
     * @param arr 待排序的数组，这里使用整形数组演示算法
     */
    @SuppressWarnings("Duplicates")
    private static void bubbleSortV1(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序v2
     *
     * @param arr 待排序的数组，这里使用整形数组演示算法
     */
    @SuppressWarnings("Duplicates")
    private static void bubbleSortV2(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            int swapCount = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
            if (0 == swapCount) {
                break;
            }
        }
    }
}
