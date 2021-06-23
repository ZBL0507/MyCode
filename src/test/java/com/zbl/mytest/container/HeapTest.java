package com.zbl.mytest.container;

import com.zbl.ds.container.Heap;
import org.junit.Test;

import java.util.Comparator;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/6/21 17:58
 */
public class HeapTest {
    @Test
    public void testHeap() {
        Heap<Integer> heap = new Heap<>();
        System.out.println("初始情况下堆中元素的个数：" + heap.size());
        System.out.println(heap.peek());
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        heap.add(0);
        heap.add(-1);
        heap.add(-2);
        heap.add(-3);
        heap.add(-4);
        System.out.println("堆中元素的个数：" + heap.size());
        heap.clear();
        System.out.println("堆中元素的个数：" + heap.size());

        System.out.println(heap.peek());
    }

    @Test
    public void testHeap2() {
        Heap<Integer> heap = new Heap<>(Comparator.reverseOrder());
        System.out.println("初始情况下堆中元素的个数：" + heap.size());
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        System.out.println("堆中元素的个数：" + heap.size());
        System.out.println(heap.peek());
        System.out.println("堆中元素的个数：" + heap.size());
    }

    @Test
    public void testHeap3() {
        Heap<Integer> heap = new Heap<>(8);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(15);
        heap.add(-15);
        heap.add(-15);
        heap.add(1);
    }

    @Test
    public void testHeap4() {
        Heap<Integer> heap = new Heap<>(7, Comparator.reverseOrder());
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(3);
        heap.add(4);
        heap.add(4);
        heap.add(5);
        heap.add(6);
    }

    @Test
    public void testHeapPop() {
        Heap<Integer> heap = new Heap<>();
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        System.out.println("堆的大小：" + heap.size());

        for (; !heap.isEmpty(); ) {
            System.out.println(heap.pop());
        }
    }

    @Test
    public void testHeapPop2() {
        Heap<Integer> heap = new Heap<>(Comparator.reverseOrder());
        heap.add(9);
        heap.add(8);
        heap.add(8);
        heap.add(6);
        heap.add(1);
        heap.add(1);
        heap.add(31);
        heap.add(2);
        heap.add(1);
        heap.add(1);
        heap.add(1);

        for (; !heap.isEmpty(); ) {
            System.out.println(heap.pop());
        }
    }
}
