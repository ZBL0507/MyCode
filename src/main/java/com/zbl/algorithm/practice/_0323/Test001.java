package com.zbl.algorithm.practice._0323;

import java.util.HashMap;

/**
 * 两个字符串格式数字的相加，输出结果还是一个字符串
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/23 11:32
 */
public class Test001 {
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

//        System.out.println(map.get('9') + map.get('1'));

        String num1 = "999";
        String num2 = "1";

        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int min = Math.min(chars1.length, chars2.length);
        int max = Math.max(chars1.length, chars2.length);

        int[] flags = new int[max + 1];

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < min; i++) {
            int sum = map.get(chars1[i]) + map.get(chars2[i]) + flags[i];
            if (sum >= 10) {
                flags[i + 1] = 1;
                temp.append(sum - 10);
            } else {
                temp.append(sum);
            }
        }

        if (chars1.length > min) {
            for (int i = min; i < chars1.length; i++) {
                int sum = map.get(chars1[i]) + flags[i];
                if (sum >= 10) {
                    flags[i + 1] = 1;
                    temp.append(sum - 10);
                } else {
                    temp.append(sum);
                }
            }
        }

        if (chars2.length > min) {
            for (int i = min; i < chars2.length; i++) {
                int sum = map.get(chars2[i]) + flags[i];
                if (sum >= 10) {
                    flags[i + 1] = 1;
                    temp.append(sum - 10);
                } else {
                    temp.append(sum);
                }
            }
        }

        if (flags[flags.length - 1] == 1) {
            temp.append(1);
        }

        System.out.println(temp.reverse());
    }
}

