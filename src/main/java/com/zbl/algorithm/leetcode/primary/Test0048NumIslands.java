package com.zbl.algorithm.leetcode.primary;


/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/13 14:04
 */
@SuppressWarnings("unused")
public class Test0048NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int num = numIslands(grid);

    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    walk(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void walk(char[][] grid, int i, int j) {
        //基本情况：排除越界的情况，递归的去走遍它前后左右的'1', '0'不走, 走过了也不走
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == '0' || grid[i][j] == '2')
            return;

        if (grid[i][j] == '1')
            grid[i][j] = '2';  //标记为2，表示它已经被访问过

        walk(grid, i, j - 1);  //左
        walk(grid, i, j + 1);  //右
        walk(grid, i - 1, j);  //上
        walk(grid, i + 1, j);  //下
    }
}
