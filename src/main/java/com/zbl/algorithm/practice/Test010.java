package com.zbl.algorithm.practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 数据范围：保证结果在 1≤n≤2^32-1
 *
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * 示例1
 * 输入：
 * 0xA
 * 0xAA
 * 输出：
 * 10
 * 170
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/25 14:43
 */
public class Test010 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.substring(2);
            line = new StringBuilder(line).reverse().toString();

            char[] charArray = line.toCharArray();
            int res = map.get(charArray[0]);

            for (int i = 1; i < charArray.length; i++) {
                Integer num = map.get(charArray[i]);
                for (int j = 0; j < i; j++) {
                    num *= 16;
                }
                res += num;
            }

            System.out.println(res);
        }
    }
}
