package com.zbl.mytest.container;

import com.zbl.ds.container.DynamicArray;
import com.zbl.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DynamicArrayTest {
    @Test
    public void add() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < 25; i++) {
            dynamicArray.add(i);
        }
        System.out.println(dynamicArray.get(24));
        System.out.println(dynamicArray.get(7));
        System.out.println(dynamicArray.get(11));
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray);
    }

    @Test
    public void add2() {
        DynamicArray<Long> array = new DynamicArray<>(15, 1.2);
        for (long i = 0; i < 30; i++) {
            array.add(i);
        }
        System.out.println(array);
        Object[] longs = array.toArray();
        ArrayUtils.printArr(longs);
    }

    @Test
    public void add3() {
        DynamicArray<String> array = new DynamicArray<>(14);
        for (int i = 0; i < 20; i++) {
            array.add(UUID.randomUUID().toString().substring(0, 5));
        }
        String s = array.get(4);
        System.out.println(s);
        System.out.println(array.toString());
        Object[] objects = array.toArray();
        ArrayUtils.printArr(objects);
    }

    @Test
    public void add4() {
        List<String> list = Arrays.asList("23", "34", "2345", "sdu");
        DynamicArray<String> array = new DynamicArray<>(list);
        System.out.println(array);
    }

    @Test
    public void add5() {
        long[] longs = {1L, 23L, 4L, 5L, 6L};
        DynamicArray<Object> array = new DynamicArray<>(longs);
        System.out.println(array);
    }

    @Test
    public void myTest() {
        Integer[] integers = {12, 2445, 4, 675, 78, 89};
        DynamicArray<Integer> array = new DynamicArray<>(integers);
        System.out.println(array);
    }

    @Test
    public void add6() {
        List<String> list = Arrays.asList("23", "34", "2345", "sdu");
        DynamicArray<String> array = new DynamicArray<>();
        array.addAll(list);
        System.out.println(array);
    }
}
