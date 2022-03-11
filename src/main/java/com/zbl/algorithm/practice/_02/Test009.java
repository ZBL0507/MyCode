package com.zbl.algorithm.practice._02;

import java.util.Scanner;

/**
 * 描述
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * （注：本题有多组输入）
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1
 * 输入：
 * abc
 * 123456789
 * 输出：
 * abc00000
 * 12345678
 * 90000000
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/25 14:14
 */
public class Test009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            while (str.length() > 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
            char[] chars = new char[]{'0','0','0','0','0','0','0','0'};
            for (int i = 0; i < str.length(); i++) {
                chars[i] = str.charAt(i);
            }
            System.out.println(new String(chars));
        }
    }
}
