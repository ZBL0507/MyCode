package com.zbl.algorithm.practice._0312;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 输出分解后的string
 * 示例1
 * 输入：
 * 6
 * 输出：
 * 31+33+35+37+39+41
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/12 16:51
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anInt = scanner.nextInt();
        int count = anInt;

        anInt = anInt * anInt * anInt;

        LinkedList<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        for (int i = 0; i < count - 1; i++) {
            deque.addLast(deque.getLast() + 2);
        }

        Integer sum = deque.stream().reduce(0, Integer::sum);
        while (sum != anInt) {
            deque.removeFirst();
            deque.addLast(deque.getLast() + 2);
            sum = deque.stream().reduce(0, Integer::sum);
        }

        System.out.println(deque.stream().map(Object::toString).collect(Collectors.joining("+")));
    }
}
