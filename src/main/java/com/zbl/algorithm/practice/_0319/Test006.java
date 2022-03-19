package com.zbl.algorithm.practice._0319;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 寻找两个集合中的公共元素
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/19 21:15
 */
public class Test006 {
    public static void main(String[] args) {
        int[] arr1 = {2, 34, 45, 6, 67, 8, 78, 45, 34, 3, 4, 4, 3};
        int[] arr2 = {323, 435, 567, 78, 34, 44, 3, 3};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr1) {
            Integer count = map.get(e);
            if (count == null) {
                count = 1;
            }
            count++;
            map.put(e, count);
        }

        for (int e : arr2) {
            Integer count = map.get(e);
            if (count == null) {
                continue;
            }
            if (count > 1) {
                count--;
                map.put(e, count);
            } else {
                map.remove(e);
            }

            System.out.print(e + " ");
        }
    }
}
