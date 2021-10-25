package com.zbl.algorithm.leetcode.intermediate;

import java.util.Stack;

/**
 * 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ], word = "ABCB"
 * 输出：false
 *  
 * <p>
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/25 14:11
 */
public class Test0077Exist {

    static class MyDS0077 {
        int i;
        int j;
        char ch;
    }

    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
    //"ABCEFSADEESE"
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCEFSADEESE";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    private static boolean exist(char[][] board, String word) {
        Stack<MyDS0077> stack = new Stack<>();
        boolean[][] use = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从每一个坐标开始进行dfs,找到则返回true
                dfs(board, use, i, j, word, stack);
                if (stack.size() == word.length())
                    return true;
                stack.clear();
                clsUse(use);
            }
        }
        return false;
    }

    /**
     * 重置使用数组
     *
     * @param use 使用数组
     */
    private static void clsUse(boolean[][] use) {
        for (int i = 0; i < use.length; i++) {
            for (int j = 0; j < use[0].length; j++) {
                use[i][j] = false;
            }
        }
    }

    /**
     * 单词搜索的dfs
     *
     * @param board 二维网格
     * @param use   记忆是否走过
     * @param i     当前搜索的横坐标
     * @param j     当前搜多的纵坐标
     * @param word  待搜索的单词
     * @param stack 用于记忆搜索路径的栈
     */
    private static void dfs(char[][] board, boolean[][] use, int i, int j, String word, Stack<MyDS0077> stack) {
        if (i < 0 || i >= board.length)
            return;
        if (j < 0 || j >= board[0].length)
            return;
        //说明已经找到
        if (stack.size() == word.length())
            return;
        //如果已经走过
        if (use[i][j])
            return;

        if (board[i][j] == word.charAt(stack.size())) {
            MyDS0077 myDS0077 = new MyDS0077();
            myDS0077.ch = board[i][j];
            myDS0077.i = i;
            myDS0077.j = j;
            stack.push(myDS0077);
            use[i][j] = true;

            //走这个位置的上下左右
            //上
            dfs(board, use, i - 1, j, word, stack);
            //右
            dfs(board, use, i, j + 1, word, stack);
            //下
            dfs(board, use, i + 1, j, word, stack);
            //左
            dfs(board, use, i, j - 1, word, stack);

            //回溯处理
            if (stack.size() < word.length()) {
                clsUse(use);
                stack.pop();
                stack.forEach(e -> use[e.i][e.j] = true);
            }
        }
    }
}
