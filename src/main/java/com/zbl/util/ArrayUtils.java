package com.zbl.util;

@SuppressWarnings("unused")
public class ArrayUtils {
    /**
     * 打印数组
     *
     * @param arr 给定的数组
     */
    public static void printArr(final int[] arr) {
        for (int e : arr) {
            System.out.print(e + "\t");
        }
        System.out.println();
    }

    /**
     * 对于给定的数组和两个下标，进行两个元素的交换
     *
     * @param arr    给定的数组
     * @param index1 下标1
     * @param index2 下标2
     */
    public static void swap(final int[] arr, final int index1, final int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 比较两个数组是否一样
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 一样返回true， 否则返回false
     */
    public static boolean compare(final int[] arr1, final int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    /**
     * 数组拷贝， 深拷贝
     * @param arr 待拷贝的数组
     * @return 拷贝出的副本
     */
    public static int[] copy(final int[] arr) {
        int[] target = new int[arr.length];
        System.arraycopy(arr, 0, target, 0, target.length);
        return target;
    }
}
