package com.zbl.algorithm.practice._0313;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/13 09:24
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mnStr = scanner.nextLine();
        String[] mn = mnStr.split(" ");
        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);
        if (n > 10_0000 || n < 1) {
            System.out.println("NULL");
            return;
        }
        if (m > 10_0000 || m < 1) {
            System.out.println("NULL");
            return;
        }

        ArrayList<String> teamList = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            if (s.endsWith("0")) {
                teamList.add(s.substring(0, s.length() - 2));
            } else {
                nodes.add(new Node(s));
            }
        }

        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < teamList.size() - 1; i++) {
            String[] split1 = teamList.get(i).split(" ");
            String[] split2 = teamList.get(i + 1).split(" ");
            if (split1[0].equals(split2[0])) {
                temp.add(split1[1] + " " + split2[1]);
            }
            if (split1[1].equals(split2[0])) {
                temp.add(split1[0] + " " + split2[1]);
            }
        }
        teamList.addAll(temp);
        temp = null;

        HashSet<String> teamSet = new HashSet<>(teamList);

        for (Node node : nodes) {
            if (node.index3 == 2) {
                System.out.println("da pian zi");
            } else if (teamSet.contains(node.str12)) {
                System.out.println("we are a team");
            } else {
                System.out.println("we are not a team");
            }
        }
    }


    static class Node {
        String str12;

        int index1;
        int index2;
        int index3;

        boolean team = false;

        public Node(String str) {
            String[] split = str.split(" ");
            this.index1 = Integer.parseInt(split[0]);
            this.index2 = Integer.parseInt(split[1]);
            this.index3 = Integer.parseInt(split[2]);

            this.str12 = index1 + " " + index2;

            if (this.index3 == 0) {
                this.team = true;
            }
        }
    }
}
