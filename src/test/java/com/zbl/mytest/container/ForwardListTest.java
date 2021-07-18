package com.zbl.mytest.container;

import com.zbl.ds.container.DynamicArray;
import com.zbl.ds.container.ForwardList;
import org.junit.Test;

public class ForwardListTest {

    @Test
    public void testForwardList() {
        ForwardList<Integer> forwardList = new ForwardList<>();
        forwardList.insert(1);
        forwardList.insert(2);
        forwardList.insert(3);
        forwardList.insert(4, false);
        forwardList.insert(5, false);
        forwardList.insert(6, false);
        forwardList.insert(7);
        forwardList.insert(8);
        forwardList.insert(9);
        System.out.println(forwardList);
    }

    @Test
    public void testForwardList2() {
        Integer[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 90, 0};
        ForwardList<Integer> forwardList = new ForwardList<>(arr);
        System.out.println(forwardList);
        forwardList.remove(1);
        System.out.println(forwardList);
        forwardList.remove(90);
        System.out.println(forwardList);
        forwardList.remove(90);
        System.out.println(forwardList);
        forwardList.remove(0);
        System.out.println(forwardList);
        forwardList.remove(2);
        System.out.println(forwardList);
        forwardList.remove(4);
        System.out.println(forwardList);
        forwardList.remove(5);
        System.out.println(forwardList);
        forwardList.remove(6);
        System.out.println(forwardList);
        forwardList.remove(7);
        System.out.println(forwardList);
        forwardList.remove(8);
        System.out.println(forwardList);
        forwardList.remove(9);
        System.out.println(forwardList);
        forwardList.remove(0);
        System.out.println(forwardList);
    }

    @Test
    public void testForwardList3() {
        Integer[] arr = {1, 2, 2, 3, 3, 3, 3, 1, 90, 0};
        ForwardList<Integer> forwardList = new ForwardList<>(arr);
        System.out.println(forwardList);
        forwardList.removeAll(1);
        System.out.println(forwardList);
        forwardList.removeAll(2);
        System.out.println(forwardList);
        forwardList.removeAll(3);
        System.out.println(forwardList);
    }

    @Test
    public void testForwardList4() {
        Integer[] arr = {1, 2, 2, 3, 3, 3, 3, 1, 90, 0};
        ForwardList<Integer> forwardList = new ForwardList<>(arr);
        System.out.println(forwardList.isEmpty());
        while (!forwardList.isEmpty())
            System.out.println(forwardList.pop());
        System.out.println(forwardList.isEmpty());
    }

    @Test
    public void testForwardList5() {
        ForwardList<Integer> forwardList = new ForwardList<>();
        forwardList.insert(12);
        forwardList.insert(13);
        forwardList.insert(14);
        forwardList.insert(15);
        System.out.println(forwardList);
        DynamicArray<Integer> array = forwardList.toDynamicArray();
        System.out.println(array);
    }
}
