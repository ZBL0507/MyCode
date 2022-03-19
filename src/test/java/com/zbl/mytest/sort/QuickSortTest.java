package com.zbl.mytest.sort;

import com.zbl.algorithm.practice._0319.Test003;
import com.zbl.util.ArrayUtils;
import com.zbl.util.RandomUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/19 12:46
 */
public class QuickSortTest {

    @Test
    public void testMyQuickSort() {
        //测试样本数量
        int count = 1000_0000;
        int length = 1000;

        for (int i = 0; i < count; i++) {
            int[] arr1 = RandomUtils.randomIntArray(length);
            int[] arr2 = ArrayUtils.copy(arr1);

            Test003.quickSort(arr1, 0 , arr1.length - 1);
            Arrays.sort(arr2);

            if (!ArrayUtils.compare(arr1, arr2)) {
                System.out.println("测试用例未通过。。。");
                System.out.println("标准答案：");
                ArrayUtils.printArr(arr2);
                System.out.println("你的答案：");
                ArrayUtils.printArr(arr1);
                return;
            }
        }
        System.out.println("所有用例均已通过！！！");
    }
}
