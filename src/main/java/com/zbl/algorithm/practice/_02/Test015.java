package com.zbl.algorithm.practice._02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围：字符串长度满足 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/9 21:26
 */
public class Test015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String countStr = scanner.nextLine();
        int count = Integer.parseInt(countStr);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextLine());
        }

        list.sort(String::compareTo);

        list.forEach(System.out::println);
    }
}
