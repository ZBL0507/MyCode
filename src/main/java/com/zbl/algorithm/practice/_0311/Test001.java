package com.zbl.algorithm.practice._0311;

import java.util.Scanner;

/**
 * 描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：1\le |s|\le 250\1≤∣s∣≤250
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 * <p>
 * 输出描述：
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 * 示例1
 * 输入：
 * add123#$%#%#O
 * 150175017(&^%&$vabovbao
 * A 1 0 11
 * 输出：
 * 1
 * 0
 * 1
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 10:25
 */
public class Test001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] charArray = line.toCharArray();

            int cnt = 0;
            for (char ch : charArray)
                if (ch >= 'A' && ch <= 'Z')
                    cnt++;

            System.out.println(cnt);
        }
    }
}
