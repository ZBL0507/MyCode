package com.zbl.algorithm.find;

@SuppressWarnings("all")
public class FindIndex {
    public static void main(String[] args) {
        int[] ints = {1, 32, 45, 6, 76, 6, 7};
        int index = find(ints, 6);
        int lastOf = findLastOf(ints, 6);
    }

    /**
     * 在指定的数组中查找给定的元素
     *
     * @param arr     指定的数组
     * @param element 待查找的元素
     * @return 找到返回相应的下标(第一次出现的下标)，否则返回-1
     */
    public static int find(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }

    /**
     * 在指定的数组中查找给定的元素
     *
     * @param arr     指定的数组
     * @param element 待查找的元素
     * @return 找到返回相应的下标(最后一次出现的下标)，否则返回-1
     */
    public static int findLastOf(int[] arr, int element) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }
}
