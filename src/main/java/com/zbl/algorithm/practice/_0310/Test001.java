package com.zbl.algorithm.practice._0310;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 数据范围：输入的字符串长度满足 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入：
 * aabcddd
 * 输出：
 * aaddd
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/10 15:00
 */
public class Test001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] line = {scanner.nextLine()};
        char[] charArray = line[0].toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : charArray) {
            Integer cnt = map.get(ch);
            if (cnt == null) {
                map.put(ch, 0);
                continue;
            }
            cnt++;
            map.put(ch, cnt);
        }

        ArrayList<Mydata> list = new ArrayList<>();
        map.forEach((key, value) -> {
            Mydata mydata = new Mydata();
            mydata.ch = key;
            mydata.cnt = value;
            list.add(mydata);
        });

        list.sort(Comparator.comparingInt(o -> o.cnt));

        ArrayList<Mydata> exclude = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).cnt == list.get(i + 1).cnt) {
                exclude.add(list.get(i));
            } else {
                exclude.add(list.get(i));
                break;
            }
        }

        exclude.forEach(e -> line[0] = line[0].replaceAll(e.ch + "", ""));
        System.out.println(line[0]);
    }

    static class Mydata {
        char ch;
        int cnt;
    }
}
