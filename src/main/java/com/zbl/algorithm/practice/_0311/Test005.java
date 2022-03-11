package com.zbl.algorithm.practice._0311;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，这个密码可以通过一种算法由更简单的密码YUANzhi1987变换而成，
 * 这个更简单的密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
 * 就这么简单，渊子把更简单的密码中出现的小写字母都变成对应的数字，数字和其它的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，不就是 y 了嘛，简单吧。
 * 记住，Z 往后移是 a 哦。
 * 数据范围： 输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 本题有多组样例输入
 * 输入描述：
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 输出描述：
 * 输出渊子真正的密文
 * 示例1
 * 输入：
 * YUANzhi1987
 * 输出：
 * zvbo9441987
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 14:43
 */
public class Test005 {
    public static void main(String[] args) {
        HashMap<Character, Object> map = new HashMap<>();
        for (char ch : "abc".toCharArray()) {
            map.put(ch, 2);
        }

        for (char ch : "def".toCharArray()) {
            map.put(ch, 3);
        }

        for (char ch : "ghi".toCharArray()) {
            map.put(ch, 4);
        }

        for (char ch : "jkl".toCharArray()) {
            map.put(ch, 5);
        }

        for (char ch : "mno".toCharArray()) {
            map.put(ch, 6);
        }

        for (char ch : "pqrs".toCharArray()) {
            map.put(ch, 7);
        }

        for (char ch : "tuv".toCharArray()) {
            map.put(ch, 8);
        }

        for (char ch : "wxyz".toCharArray()) {
            map.put(ch, 9);
        }

        for (char ch : "ABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray()) {
            map.put(ch, (char)(ch + 33));
        }
        map.put('Z', 'a');

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            for (char ch : line.toCharArray()) {
                Object o = map.get(ch);
                if (o == null) {
                    builder.append(ch);
                } else {
                    builder.append(o);
                }
            }
            System.out.println(builder);
        }
    }
}
