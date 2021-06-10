package com.zbl.mytest.container;

import com.zbl.circular.dependency.CC;
import com.zbl.ds.container.DynamicArray;
import com.zbl.util.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
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
    public void add8() {
        Integer[] integers = {12, 2445, 4, 675, 78, 89};
        DynamicArray<Integer> array = new DynamicArray<>(integers);
        System.out.println(array);
        Integer[] toArray = array.toArray(integers.getClass());
        ArrayUtils.printArr(toArray);
    }

    @Test
    public void add6() {
        List<String> list = Arrays.asList("23", "34", "2345", "sdu");
        DynamicArray<String> array = new DynamicArray<>();
        array.addAll(list);
        System.out.println(array);
    }

    @Test
    public void add7() {
        List<String> list = Arrays.asList("23", "34", "2345", "sdu");
        DynamicArray<String> array = new DynamicArray<>();
        System.out.println(array.addAll(list));
        System.out.println(array);
        String[] strings = array.toArray(String[].class);
        ArrayUtils.printArr(strings);
    }

    @Test
    public void remove() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.addAll(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

        System.out.println("当前数组大小：" + array.size());
        while (!array.isEmpty()) {
            array.remove(2);
            System.out.println("当前数组大小：" + array.size());
        }

        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
        System.out.println("当前数组大小：" + array.size());
        array.remove(2);
    }

    @Test
    public void remove2() {
        DynamicArray<String> array = new DynamicArray<>();
        array.addAll("haha", "haha", "haha", "haha", "haha", "haha", "haha", "haha");
        System.out.println("当前数组大小：" + array.size());
        while (array.isNotEmpty()) {
            array.remove("haha");
            System.out.println("当前数组大小：" + array.size());
        }
    }

    @Test
    public void remove3() {
        DynamicArray<CC> array = new DynamicArray<>();
        CC c1 = new CC();
        array.add(c1);
        CC c2 = new CC();
        array.add(c2);
        array.remove(c2);
        System.out.println(array);
        array.remove(c1);
        System.out.println(array);
    }

    @Test
    public void remove4() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.addAll(1, 23, 4, 5, 6, 6, 77, 7);
        System.out.println(array);
        Integer remove = array.remove(2);
        System.out.println(remove);
        System.out.println(array);
        array.remove(array.size() - 1);
        System.out.println(array);
    }

    @Test
    public void remove5() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.addAll(123, 324, 3465, 4576, 767678, 78989, 345, 456);
        while (array.isNotEmpty())
            System.out.println(array.removeLastElement());
    }

    @Test
    public void remove6() {
        DynamicArray<Integer> array = new DynamicArray<>();
        boolean b = array.addAll(123, 324, 3465, 4576, 767678, 78989, 345, 456);
        System.out.println(b);
        while (array.isNotEmpty())
            System.out.println(array.removeFirstElement());
    }
}
