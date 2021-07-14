package com.zbl.algorithm.leetcode;

import com.zbl.util.ArrayUtils;

import java.util.ArrayList;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/14 10:00
 */
public class Test0049SetZeroes {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("处理之前：");
        ArrayUtils.printArr(matrix1);
        setZeroes(matrix1);
        System.out.println("处理之后：");
        ArrayUtils.printArr(matrix1);
    }

    private static void setZeroes(int[][] matrix) {
        ArrayList<Node4StoreRL> cache = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    cache.add(new Node4StoreRL(i, j));
                }
            }
        }

        for (Node4StoreRL e : cache) {
            handleRow(matrix, e.row);
            handleColumn(matrix, e.column);
        }
    }

    /**
     * 将指定的矩阵某一列置为0
     *
     * @param matrix 指定的矩阵
     * @param column 指定的列
     */
    private static void handleColumn(int[][] matrix, int column) {
        if (column < 0 || column >= matrix[0].length)
            return;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    /**
     * 将指定的矩阵某一行置为0
     *
     * @param matrix 指定的矩阵
     * @param row    指定的行
     */
    private static void handleRow(int[][] matrix, int row) {
        if (row < 0 || row >= matrix.length)
            return;

        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    // 用于存储行和列的结构
    static class Node4StoreRL {
        int row;
        int column;

        Node4StoreRL(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
