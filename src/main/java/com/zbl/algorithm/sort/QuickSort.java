package com.zbl.algorithm.sort;

@SuppressWarnings("all")
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {19, 34, 65, -5, -14, 345431, -34, -75, 3487};
        quickSort(ints);
    }

    /**
     * 快速排序
     *
     * @param arr 待排序数组，这里使用整形数组来演示算法
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对于给定数组给定区间[begin, end]，快速排序
     *
     * @param arr   待排序数组，这里使用整形数组来演示算法
     * @param begin 待排序区间的开始
     * @param end   待排序区间的结束
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;
        int position = findPosition(arr, begin, end);
        quickSort(arr, begin, position - 1);
        quickSort(arr, position + 1, end);
    }

    /**
     * 快速排序核心步骤，寻找位置（每经过一轮寻找位置操作，会将标志元素放到最终的位置上，并返回这个位置下标）
     *
     * @param arr   给定的数组
     * @param begin 待寻找区间的开始
     * @param end   待寻找区间的结束
     * @return 返回找到的位置
     */
    public static int findPosition(int[] arr, int begin, int end) {
        //取标志元素
        int key = arr[begin];

        int i = begin;
        int j = end;

        while (i < j) {
            //这里使用 >= 是为了稳定排序
            while (i < j && arr[j] >= key)
                j--;
            if (i == j)
                break;
            arr[i++] = arr[j];

            //这里没有使用 <= 是为了稳定排序
            while (i < j && arr[i] < key)
                i++;
            arr[j--] = arr[i];
        }

        //将标志元素放入最终的位置
        arr[i] = key;
        return i;
    }
}
