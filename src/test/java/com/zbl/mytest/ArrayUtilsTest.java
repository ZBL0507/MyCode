package com.zbl.mytest;

import com.zbl.util.ArrayUtils;
import org.junit.Test;

@SuppressWarnings("unused")
public class ArrayUtilsTest {

    @Test
    public void compare() {
        int[] arr1 = {2, 3, 4};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {3, 4};
        int[] arr4 = {2, 3, 4};
        boolean b = ArrayUtils.compare(arr1, arr2);
        boolean b2 = ArrayUtils.compare(arr1, arr3);
        boolean b3 = ArrayUtils.compare(arr1, arr4);
    }
}
