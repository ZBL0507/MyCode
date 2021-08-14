package com.zbl.algorithm.leetcode;

import java.util.HashSet;

/**
 * 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/14 21:26
 */
@SuppressWarnings("all")
public class Test0054IsValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                         {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean isValidSudoku = isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean validColumn = isValidColumn(board, i);
            if (!validColumn)
                return false;
            boolean validRow = isValidRow(board, i);
            if (!validRow)
                return false;
        }

        boolean b1 = checkUnitMatrix(board, 0, 0);
        if (!b1)
            return false;
        boolean b2 = checkUnitMatrix(board, 0, 3);
        if (!b2)
            return false;
        boolean b3 = checkUnitMatrix(board, 0, 6);
        if (!b3)
            return false;
        boolean b4 = checkUnitMatrix(board, 3, 0);
        if (!b4)
            return false;
        boolean b5 = checkUnitMatrix(board, 3, 3);
        if (!b5)
            return false;
        boolean b6 = checkUnitMatrix(board, 3, 6);
        if (!b6)
            return false;
        boolean b7 = checkUnitMatrix(board, 6, 0);
        if (!b7)
            return false;
        boolean b8 = checkUnitMatrix(board, 6, 3);
        if (!b8)
            return false;

        return checkUnitMatrix(board, 6, 6);
    }

    private static boolean isValidColumn(char[][] board, int column) {
        int length = board.length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (board[i][column] != '.') {
                if (set.contains(board[i][column]))
                    return false;
                set.add(board[i][column]);
            }
        }
        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        int length = board[0].length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (board[row][i] != '.') {
                if (set.contains(board[row][i]))
                    return false;
                set.add(board[row][i]);
            }
        }
        return true;
    }

    private static boolean checkUnitMatrix(char[][] board, int row, int column) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }
}
