package com.zbl.algorithm.practice._0318;

public class Test002 {

    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, 1, 2, 45, 564, 5676, 9045};
        int index = search(arr, -1);
        int index2 = search(arr, 9045);
        int index3 = search(arr, 45);
        int[] arr2 = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3};
        int ll = searchLeft(arr2, 0);
        int ll2 = searchLeft(arr2, 1);
        int ll3 = searchLeft(arr2, 2);
        int ll4 = searchLeft(arr2, 3);
    }

    //在一个有序的数组中寻找，>= 某个数最左侧的位置。
    public static int searchLeft(int[] arr, int key) {
        int leftIndex = arr.length;

        int low = 0;
        int hig = arr.length - 1;

        int mid = (low + hig) / 2;

        while (low <= hig) {
            if (key <= arr[mid]) {
                if (mid < leftIndex) {
                    leftIndex = mid;
                }
                hig = mid - 1;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
            mid = (low + hig) / 2;
        }

        return leftIndex == arr.length ? -1 : leftIndex;
    }

    public static int search(int[] arr, int key) {
        if (arr == null) {
            return -1;
        }

        int low = 0;
        int hig = arr.length - 1;

        int mid = low + (hig - low) / 2;

        while (low < hig && arr[mid] != key) {
            if (key < arr[mid]) {
                hig = mid - 1;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
            mid = low + (hig - low) / 2;
        }

        return arr[mid] == key ? mid : -1;
    }

}