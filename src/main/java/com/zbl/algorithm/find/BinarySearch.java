package com.zbl.algorithm.find;

@SuppressWarnings("unused")
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 5, 6, 7, 9, 12, 45};
        int i = binarySearch(ints, 1);
        int i2 = binarySearch(ints, 9);
        int i3 = binarySearch(ints, 45);
        int i4 = binarySearch(ints, 4);
        int i5 = binarySearch(ints, 18);
    }

    /**
     * 二分查找
     *
     * @param arr 待查找的数组
     * @param key 查找的key
     * @return 返回key在数组中的下标，如果不存在就是key要插入的位置
     */
    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low < high) {
            if (key == arr[mid])
                return mid;
            else if (key < arr[mid]) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }
        return mid;
    }
}
