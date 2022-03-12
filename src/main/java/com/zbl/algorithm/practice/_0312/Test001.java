package com.zbl.algorithm.practice._0312;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 输入描述：
 * 输入正整数N（N不大于100）
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 * 示例1
 * 输入：
 * 4
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/12 16:28
 */
public class Test001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anInt = scanner.nextInt();

        List<LinkedList<Integer>> nums = new ArrayList<>();

        int n = 0;

        for (int i = 0; i < anInt; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                list.addLast(++n);
            }
            nums.add(list);
        }

        //System.out.println(nums);

        for (int i = 0; i < anInt; i++) {
            StringBuilder str = new StringBuilder();
            for (LinkedList<Integer> num : nums) {
                if (!num.isEmpty()) {
                    str.append(num.removeLast()).append(" ");
                }
            }
            System.out.println(str);
        }
    }
}
