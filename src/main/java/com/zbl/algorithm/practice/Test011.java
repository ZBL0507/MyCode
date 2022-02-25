package com.zbl.algorithm.practice;

import java.util.*;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 * <p>
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述：
 * 输出合并后的键值对（多行）
 * <p>
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 * 示例2
 * 输入：
 * 3
 * 0 1
 * 0 2
 * 8 9
 * 输出：
 * 0 3
 * 8 9
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/25 21:03
 */
public class Test011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int key = Integer.parseInt(split[0]);
            List<Integer> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(Integer.parseInt(split[1]));
                map.put(key, list);
                continue;
            }
            list.add(Integer.parseInt(split[1]));
            map.put(key, list);
        }

        map.forEach((key, value) -> System.out.println(key + " " + (value.stream().reduce(0, Integer::sum))));

    }
}
