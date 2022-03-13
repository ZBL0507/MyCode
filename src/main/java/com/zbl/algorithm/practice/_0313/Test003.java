package com.zbl.algorithm.practice._0313;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/13 09:24
 */
public class Test003 {
    public static void main(String[] args) {
        HashMap<String, pai> map = new HashMap<>();
        for (String paiStr : "3,4,5,6,7,8,9,10".split(",")) {
            map.put(paiStr, new pai(paiStr, Integer.parseInt(paiStr)));
        }
        map.put("J", new pai("J", 11));
        map.put("Q", new pai("Q", 12));
        map.put("K", new pai("K", 13));
        map.put("A", new pai("A", 14));
        map.put("2", new pai("2", 15));

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        TreeSet<pai> pais = new TreeSet<>(Comparator.comparingInt(o -> o.order));

        for (String s : split) {
            pais.add(map.get(s));
        }

        if (pais.size() < 5) {
            System.out.println("No");
            return;
        }

        HashSet<LinkedList<pai>> resSet = new HashSet<>();
        LinkedList<pai> deque = new LinkedList<>();
        for (pai pai : pais) {
            if (!deque.isEmpty()) {
                //说明不连续
                if (deque.getLast().order + 1 != pai.order) {
                    if (deque.size() >= 5) {
                        resSet.add(deque);
                    }
                    deque = new LinkedList<>();
                }
            }
            deque.addLast(pai);
        }
        if (deque.size() >= 5) {
            resSet.add(deque);
        }

        for (LinkedList<pai> list : resSet) {
            System.out.println(list.stream().map(e -> e.code).collect(Collectors.joining(" ")));
        }

    }

    static class pai {
        String code;

        int order;

        public pai(String code, int order) {
            this.code = code;
            this.order = order;
        }
    }
}
