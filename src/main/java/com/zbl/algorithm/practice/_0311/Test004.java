package com.zbl.algorithm.practice._0311;

import java.util.Scanner;

/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 输入一行字符串，可以有空格
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 * 示例1
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出：
 * 26
 * 3
 * 10
 * 12
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 12:14
 */
public class Test004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int chCnt = 0;
        int digitCnt = 0;
        int spanceCnt = 0;
        int othersCnt = 0;

        for (char ch : str.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')) {
                chCnt++;
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                digitCnt++;
                continue;
            }
            if (ch == ' ') {
                spanceCnt++;
                continue;
            }
            othersCnt++;
        }

        System.out.println(chCnt);
        System.out.println(spanceCnt);
        System.out.println(digitCnt);
        System.out.println(othersCnt);
    }
}
