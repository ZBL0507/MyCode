package com.zbl.algorithm.practice._0311;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int      m_nKey;
 * ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针
 * 数据范围：链表长度满足 1 \le n \le 1000 \1≤n≤1000  ， k \le n \k≤n  ，链表中数据满足 0 \le val \le 10000 \0≤val≤10000
 * 本题有多组样例输入。
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述：
 * 输出一个整数
 * 示例1
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 输出：
 * 5
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 11:50
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            try {
                int nodeCount = Integer.parseInt(scanner.nextLine());
                String line = scanner.nextLine();
                int index = Integer.parseInt(scanner.nextLine());

                String[] split = line.split(" ");

                int[] arr = new int[nodeCount];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(split[i]);
                }
                if (index == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(arr[nodeCount - index]);
                }
            } catch (Exception e) {
                throw new NullPointerException();
            } finally {
            }
        }
    }

    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }
}
