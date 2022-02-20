package com.zbl.algorithm.interview;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 */
public class Test001 {
    public static void main(String[] args) {
        turnTimes("CMA");
    }

    public static int validNum (int N) {
        // write code here
        /*
         * 通过演算可知f(1) = 2, f(2) = 3, f(3) = 5, f(4) = 8, f(5) = 13
         * 得出递推公式 f(n) = f(n - 1) + f(n - 2);
         */
        if (N == 1) {
            return 2;
        }
        if (N == 2) {
            return 3;
        }

        return validNum(N - 1) + validNum(N - 2);
    }

    public static int turnTimes (String s) {
        // write code here
        /*
         * 我们可以认为给定字符串就是一个数字，A -> 0, B -> 1, ... Z -> 25;
         * 我们即可当作26进制数字来处理
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), i);
        }

        char[] chars = s.toCharArray();
        int value = map.get(chars[0]) * 26 * 26 + map.get(chars[1]) * 26 + map.get(chars[2]);
        //1665 = CMB
        return 1665 - value;
    }

}
