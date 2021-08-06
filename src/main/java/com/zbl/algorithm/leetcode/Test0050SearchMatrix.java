package com.zbl.algorithm.leetcode;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ], target = 20
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/5 15:34
 */
public class Test0050SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}

        };
        int target = 13;
        boolean res = searchMatrix(matrix, target);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == target)
                return true;
        }

        int cloum = findCloum(matrix, target);
        for (int[] ints : matrix) {
            if (ints[cloum] == target)
                return true;
        }

        row--;
        //回溯
        while (row >= 0) {
            for (int i = 0; i < matrix[row].length; i++) {
                if (matrix[row][i] == target)
                    return true;
            }
            row--;
        }

        return false;
    }

    private static int findRow(int[][] matrix, int target) {
        int length = matrix.length;
        int index = 0;
        for (int i = 0; i < length && matrix[i][0] <= target; i++) {
            index = i;
        }

        return index;
    }

    private static int findCloum(int[][] matrix, int target) {
        int[] ints = matrix[0];
        int length = ints.length;
        int index = 0;
        for (int i = 0; i < length && ints[i] <= target; i++) {
            index = i;
        }

        return index;
    }
}
