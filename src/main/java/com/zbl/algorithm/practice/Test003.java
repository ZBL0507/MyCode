package com.zbl.algorithm.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * <p>
 * 数据范围： 1 <= n < 1000  ，元素大小满足 0 ≤ val ≤ 100000
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 * <p>
 * 输出描述：
 * 输出排好序的数字
 * <p>
 * 示例1
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出：
 * 1 2 3 4 9 25 55 64
 * <p>
 * 示例2
 * 输入：
 * 5
 * 1 2 3 4 5
 * 1
 * 输出：
 * 5 4 3 2 1
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/16 9:46
 */
public class Test003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String arrStr = scanner.nextLine();
        String[] arrStrEle = arrStr.split(" ");
        String sortType = scanner.nextLine();

        Integer[] arr = new Integer[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrStrEle[i]);
        }

        Arrays.sort(arr);

        if ("0".equals(sortType)) {
            Arrays.sort(arr);
        }
        if ("1".equals(sortType)) {
            Arrays.sort(arr, (o1, o2) -> o2 - o1);
        }
        printArr(arr);
    }

    private static void printArr(Integer[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
