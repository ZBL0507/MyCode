package com.zbl.algorithm.sort;

import com.zbl.util.ArrayUtils;
import com.zbl.util.RandomUtils;

import java.util.Arrays;

@SuppressWarnings("unused")
public class HeapSort {
    private final static int arraySize = 500_000;

    public static void main(String[] args) {
        //int[] arr = {5, 3, 7, 8, 2, 9, 10, 17};
        testHeapSort(50);
    }

    /**
     * 排序功能测试
     *
     * @param count 测试样本量
     */
    private static void testHeapSort(int count) {
        System.out.println("=============================检测开始=============================");
        for (int i = 0; i < count; i++) {
            int[] sourceArr = new int[arraySize];
            for (int j = 0; j < sourceArr.length; j++) {
                sourceArr[j] = RandomUtils.randomInt(0 - arraySize, arraySize);
            }
            int[] targetArr = ArrayUtils.copy(sourceArr);

            heapSort(sourceArr);
            Arrays.sort(targetArr);
            if (!ArrayUtils.compare(sourceArr, targetArr)) {
                System.out.println("=============================第"+ (i + 1) +"检测出错误=============================");
                System.out.println("sourceArr:");
                ArrayUtils.printArr(sourceArr);
                System.out.println("targetArr");
                ArrayUtils.printArr(targetArr);
                break;
            }
            System.out.println("第" + (i + 1) + "组测试通过");
        }
        System.out.println("=============================检测通过=============================");
    }

    /**
     * 对于给定的数组，初始化堆(大根堆)
     *
     * @param arr 给定的数组
     */
    private static void initHeap(int[] arr) {
        int hs = heapInsert(arr, 0, 0);
        for (int i = 1; i < arr.length; i++) {
            hs = heapInsert(arr, i, hs);
        }
    }

    /**
     * 将数组相应下标上的元素插入到堆中
     *
     * @param arr      给定的数组
     * @param index    给定的下标
     * @param heapSize 新元素插入之前堆的大小
     * @return 新元素插入之后堆的大小
     */
    private static int heapInsert(final int[] arr, final int index, final int heapSize) {
        int hs = heapSize;
        ArrayUtils.swap(arr, index, hs++);

        //新插入一个元素，保持整个大根堆的特性
        int modify = hs - 1;
        int parent = (modify - 1) / 2;
        while (modify > parent && arr[modify] > arr[parent]) {
            ArrayUtils.swap(arr, modify, parent);
            modify = parent;
            parent = (modify - 1) / 2;
        }

        //返回堆大小
        return hs;
    }

    /**
     * 向下的堆化： 当 index 位置上的元素发生变化 向下堆化以继续保持堆的特性
     *
     * @param arr      代表堆的数组
     * @param index    需要调整元素的下标
     * @param heapSize 堆的大小
     */
    private static void heapifyOfDown(final int[] arr, final int index, final int heapSize) {
        //堆化
        int parent = index;
        int left = parent * 2 + 1;  //初始的左孩子
        int right = parent * 2 + 2; //初始的右孩子
        int largestIndex;   //用来记录左、右孩子(如果有)中较大值的下标
        if (left < heapSize && right < heapSize) {
            //如果有左、右孩子，记录较大值的下标
            largestIndex = arr[left] > arr[right] ? left : right;
        } else if (left < heapSize) {
            //如果只有左孩子，那么较大值的下标就是左孩子的下标
            largestIndex = left;
        } else {
            //如果没有左、右孩子，将parent赋值给largestIndex用来结束循环
            largestIndex = parent;
        }
        //开始调整
        while (parent < largestIndex && arr[parent] < arr[largestIndex]) {
            ArrayUtils.swap(arr, parent, largestIndex);
            parent = largestIndex;  // 新的parent
            left = parent * 2 + 1;  // 新的左孩子(如果有)
            right = parent * 2 + 2; // 新的右孩子(如果有)
            if (left < heapSize && right < heapSize) {
                //如果有左、右孩子，记录较大值的下标
                largestIndex = arr[left] > arr[right] ? left : right;
            } else if (left < heapSize) {
                //如果只有左孩子，那么较大值的下标就是左孩子的下标
                largestIndex = left;
            } else {
                //如果没有左、右孩子，将parent赋值给largestIndex用来结束循环
                largestIndex = parent;
            }
        }
    }

    /**
     * 将堆顶的元素从堆中脱离出来
     *
     * @param arr      数组代表的堆
     * @param heapSize 堆顶元素脱离之前堆的大小
     * @return 堆顶元素脱离之后堆的大小
     */
    private static int popFromHeap(final int[] arr, final int heapSize) {
        if (heapSize > arr.length || heapSize <= 0) {
            throw new IllegalArgumentException("非法的堆大小heapSize：" + heapSize);
        }
        int hs = heapSize;
        ArrayUtils.swap(arr, 0, --hs);
        heapifyOfDown(arr, 0, hs);
        return hs;
    }

    /**
     * 对于给定的数组，堆排序
     *
     * @param arr 给定的数组
     */
    private static void heapSort(int[] arr) {
        initHeap(arr);
        for (int hs = arr.length; hs > 0; hs--) {
            popFromHeap(arr, hs);
        }
    }
}
