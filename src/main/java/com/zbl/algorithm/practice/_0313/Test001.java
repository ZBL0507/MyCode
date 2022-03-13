package com.zbl.algorithm.practice._0313;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/13 09:25
 */
public class Test001 {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            people.add(new Person(i));
        }

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m >= 100 || m <= 1) {
            System.out.println("ERROR!");
        }

        int cnt = 0;

        while (people.size() >= m) {
            cnt++;
            Person person = people.removeFirst();
            if (cnt == m) {
                cnt = 0;
            } else {
                people.addLast(person);
            }
        }

        people.sort((Comparator.comparingInt(o -> o.numNo)));

        System.out.println(people.stream().map(e -> e.numNo +"").collect(Collectors.joining(",")));
    }

    static class Person {
        //人的数字编号
        int numNo;

        public Person(int numNo) {
            this.numNo = numNo;
        }
    }

}
