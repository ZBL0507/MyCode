package com.zbl.algorithm.practice._0420;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 牛牛今年上幼儿园了，老师叫他学习减法
 * 老师给了他五个数，他每次操作可以选择其中4个进行减一
 * 减一之后的数字不能小于0，因为幼儿园没有接触过负数
 * 现在牛牛想知道，自己最多可以进行多少次这样的操作
 *
 * @author zbl
 * @version 1.0
 * @since 2022/4/20 11:51
 */
public class Test001 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 5, 4, 5, 3);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(integers);

        int count = 0;

        while (heap.size() >= 4) {
            Integer n1 = heap.poll();
            int n2 = heap.poll();
            int n3 = heap.poll();
            int n4 = heap.poll();
            if (n1 > 0 && n2 > 0 && n3 > 0 && n4 > 0) {
                heap.add(n1 - 1);
                heap.add(n2 - 1);
                heap.add(n3 - 1);
                heap.add(n4 - 1);
                count++;
            }
        }

        System.out.println(count);
    }
}


// 3, 5, 4, 5, 3
// 2, 4, 3, 4, 3
// 2, 3, 2, 3, 2
// 1, 2, 1, 2, 2
// 0, 1, 1, 1, 1
// 0, 0, 0, 0, 0

