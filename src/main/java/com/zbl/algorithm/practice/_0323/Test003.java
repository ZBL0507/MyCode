package com.zbl.algorithm.practice._0323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/4/2 20:17
 */
public class Test003 {
    public static void main(String[] args) {
        String input = "258";

        HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        int total = 1;
        char[] chars = input.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Character.getNumericValue(chars[i]);
            total *= map.get(nums[i]).size();
        }

        ArrayList<String> res = new ArrayList<>(total);

        for (int num : nums) {
            List<Character> characters = map.get(num);
            if (res.isEmpty()) {
                for (Character ch : characters) {
                    res.add(ch.toString());
                }
            } else {
                ArrayList<String> temp = new ArrayList<>(total);
                for (String re : res) {
                    for (Character ch : characters) {
                        temp.add(re + ch);
                    }
                }
                res = temp;
            }
        }

        System.out.println(res.size());
        System.out.println(res);
    }
}
