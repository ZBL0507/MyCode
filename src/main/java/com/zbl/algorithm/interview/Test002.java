package com.zbl.algorithm.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 求两个集合中不重复的元素
 * <p>
 * int[] l1 = {2, 2, 3, 3, 5};
 * int[] l2 = {3, 5, 5, 6};
 * <p>
 * ===> [2,2,6]
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/2 10:04
 */
public class Test002 {
    public static void main(String[] args) {

        int[] l1 = {2, 2, 3, 5, 6, 6, 6, 90};
        int[] l2 = {3, 3, 6, 6};

        resolve1(l1, l2);
        resolve2(l1, l2);
    }

    private static void resolve2(int[] l1, int[] l2) {
        List<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int v : l1) {
            set.add(v);
        }
        for (int value : l2) {
            if (!set.contains(value)) {
                list.add(value);
            }
        }

        set = new HashSet<>();
        for (int v : l2) {
            set.add(v);
        }
        for (int value : l1) {
            if (!set.contains(value)) {
                list.add(value);
            }
        }

        list.sort(Integer::compareTo);
        System.out.println(list);
    }

    private static void resolve1(int[] l1, int[] l2) {
        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < l1.length && p2 < l2.length) {
            if (l1[p1] < l2[p2]) {
                list.add(l1[p1]);
                p1++;
            } else if (l2[p2] < l1[p1]) {
                list.add(l2[p2]);
                p2++;
            } else {
                while (p1 + 1 < l1.length && l1[p1] == l1[p1 + 1]) {
                    p1++;
                }
                while (p2 + 1 < l2.length && l2[p2] == l2[p2 + 1]) {
                    p2++;
                }
                if (l1[p1] == l2[p2]) {
                    p1++;
                    p2++;
                }
            }
        }

        while (p1 < l1.length) {
            list.add(l1[p1]);
            p1++;
        }
        while (p2 < l2.length) {
            list.add(l2[p2]);
            p2++;
        }

        System.out.println(list);
    }
}
