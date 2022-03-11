package com.zbl.algorithm.practice._0311;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。
 * 入口点为[0,0],既第一格是可以走的路。
 * 数据范围： 2 \le n,m \le 10 \2≤n,m≤10  ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1
 * <p>
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。
 * 数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 * 示例1
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * 示例2
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 * 说明：
 * 注意：不能斜着走！！
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 17:09
 */
public class Test008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mn = scanner.nextLine();
        String[] nmArr = mn.split(" ");
        int n = Integer.parseInt(nmArr[0]);
        int m = Integer.parseInt(nmArr[1]);

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] rowNums = line.split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(rowNums[j]);
            }
        }

        int[][] flag = new int[n][m];
        ArrayList<String> list = new ArrayList<>();
        walk(list, flag, arr, 0, 0);

        System.out.println("(0,0)");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    private static int walk(List<String> list, int[][] flag, int[][] arr, int n, int m) {
        //防止越界
        if (n >= arr.length || m >= arr[0].length || n < 0 || m < 0) {
            return 0;
        }
        //如果走过 或者 不能走
        if (flag[n][m] == 1 || arr[n][m] == 1) {
            return 0;
        }
        //标记为走过
        flag[n][m] = 1;
        if (n == arr.length - 1 && m == arr[0].length - 1) {
            //标记为正确的路径
            return 2;
        }

        //上
        int up = walk(list, flag, arr, n - 1, m);
        if (up == 2) {
            //标记为正确的路径
            flag[n - 1][m] = 2;
            list.add("(" + (n - 1) + "," + m + ")");
            return 2;
        }
        //右
        int right = walk(list, flag, arr, n, m + 1);
        if (right == 2) {
            //标记为正确的路径
            flag[n][m + 1] = 2;
            list.add("(" + n + "," + (m + 1) + ")");
            return 2;
        }
        //下
        int down = walk(list, flag, arr, n + 1, m);
        if (down == 2) {
            //标记为正确的路径
            flag[n + 1][m] = 2;
            list.add("(" + (n + 1) + "," + m + ")");
            return 2;
        }
        //左
        int left = walk(list, flag, arr, n, m - 1);
        if (left == 2) {
            //标记为正确的路径
            flag[n][m - 1] = 2;
            list.add("(" + n + "," + (m - 1) + ")");
            return 2;
        }
        return 1;
    }
}
