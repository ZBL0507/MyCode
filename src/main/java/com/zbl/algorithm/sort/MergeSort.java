package com.zbl.algorithm.sort;

import com.zbl.util.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-1, 2342, -7897, 43, 11, 6, -9, -119};
        ArrayUtils.printArr(arr);
        mergeSort(arr);
        ArrayUtils.printArr(arr);

    }

    @SuppressWarnings("all")
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 对数组arr的子区间[begin, end]采用归并排序, 注意 begin <= end;
     *
     * @param arr   待排序的数组
     * @param begin 开始下标, include
     * @param end   结束下标, include
     */
    @SuppressWarnings("all")
    public static void mergeSort(int[] arr, int begin, int end) {
        if (begin == end)
            return;
        int mid = (begin + end) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    /**
     * 归并排序核心步骤-归并,注意：p <= q < r
     *
     * @param arr 归并前后的数组，这里采用整形数组演示算法
     * @param p   [p, q] 待归并的前半数组，
     * @param q   [p, q] 待归并的前半数组，
     * @param r   [q+1, r] 待归并的后半数组，
     */
    @SuppressWarnings("all")
    public static void merge(int[] arr, int p, int q, int r) {
        int lLength = q - p + 1;
        int rLength = r - q;

        int[] lArr = new int[lLength];
        int[] rArr = new int[rLength];

        //拷贝左半数组
        for (int i = p, k = 0; i <= q; i++, k++) {
            lArr[k] = arr[i];
        }

        //拷贝右半数组
        for (int i = q + 1, k = 0; i <= r; i++, k++) {
            rArr[k] = arr[i];
        }

        int lLoopCount = lArr.length;
        int rLoopCount = rArr.length;
        int i = 0;
        int j = 0;

        //归并
        for (int k = p; k <= r; k++) {
            if (lLoopCount > 0 && lArr[i] <= rArr[j]) {
                arr[k] = lArr[i++];
                lLoopCount--;
                if (i == lArr.length)
                    i--;
                continue;
            }
            if (rLoopCount > 0 && rArr[j] <= lArr[i]) {
                arr[k] = rArr[j++];
                rLoopCount--;
                if (j == rArr.length)
                    j--;
                continue;
            }
            if (lLoopCount > 0) {
                arr[k] = lArr[i++];
                lLoopCount--;
            }
            if (rLoopCount > 0) {
                arr[k] = rArr[j++];
                rLoopCount--;
            }
        }
    }
}
