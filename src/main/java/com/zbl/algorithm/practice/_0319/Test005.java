package com.zbl.algorithm.practice._0319;

/**
 * 顺时针打印矩阵
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/19 20:34
 */
public class Test005 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] flag = new int[4][4];

        walk(arr, flag, 0, 0);
        System.out.println();
    }

    public static void walk(int[][] arr, int[][] flag, int i, int j) {
        walkRight(arr, flag, 0, 0);
        walkDown(arr, flag, 0, 3);
    }

    public static void walkRight(int[][] arr, int[][] flag, int i, int j) {
        //判断是否越界 和 是否走过
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length
                || flag[i][j] == 1) {
            return;
        }

        flag[i][j] = 1;
        System.out.print(arr[i][j] + " ");

        walkRight(arr, flag, i, j + 1);
    }

    public static void walkDown(int[][] arr, int[][] flag, int i, int j) {
        //判断是否越界 和 是否走过
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length
                || flag[i][j] == 1) {
            return;
        }

        flag[i][j] = 1;
        System.out.print(arr[i][j] + " ");

        walkDown(arr, flag, i + 1, j);
    }

    public static void walkLeft(int[][] arr, int[][] flag, int i, int j) {
        //判断是否越界 和 是否走过
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length
                || flag[i][j] == 1) {
            return;
        }

        flag[i][j] = 1;
        System.out.print(arr[i][j] + " ");

        walkLeft(arr, flag, i, j - 1);
    }

    public static void walkUp(int[][] arr, int[][] flag, int i, int j) {
        //判断是否越界 和 是否走过
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length
                || flag[i][j] == 1) {
            return;
        }

        flag[i][j] = 1;
        System.out.print(arr[i][j] + " ");

        walkUp(arr, flag, i - 1, j);
    }
}
