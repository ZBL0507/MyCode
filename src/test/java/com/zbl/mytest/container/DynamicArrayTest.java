package com.zbl.mytest.container;

import com.zbl.ds.container.DynamicArray;
import org.junit.Test;

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
}
