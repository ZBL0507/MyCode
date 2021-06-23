package com.zbl.ds.container;

import java.util.Comparator;

/**
 * 数据结构-堆， 默认是小根堆  存入堆中的元素必须是可比较的
 * <p>
 * 注意：堆 只支持从堆顶弹出一个元素，访问堆顶元素，向堆中加入一个元素这三类操作，
 * 其他操作一律不支持 ！
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/21 11:45
 */
public class Heap<T> {

    /**
     * 真正用于存储数据的结构-动态数组(当这个数组满时，会进行扩容，目前先不支持缩容)
     */
    private Object[] array;

    /**
     * 底层动态数组扩容时的扩展因子，eles扩容时，新的容量 = 老的容量 * FACTOR
     */
    private static final double FACTOR = 1.5;

    /**
     * 初始容量：11，eles数组的初始容量  概率统计下的值
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    /**
     * 堆中已有元素的个数
     */
    private int size;

    /**
     * 比较器，堆构造的时候初始化，如果为null则使用自然排序
     */
    private final Comparator<? super T> comparator;


    /**
     * 无参构造器
     */
    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    /**
     * 构造器
     *
     * @param comparator 比较器
     */
    public Heap(Comparator<? super T> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    /**
     * 构造器
     *
     * @param capacity 堆的初始容量
     */
    public Heap(int capacity) {
        this(capacity, null);
    }

    /**
     * 构造器
     *
     * @param capacity   堆的初始容量
     * @param comparator 比较器
     */
    public Heap(int capacity, Comparator<? super T> comparator) {
        if (capacity < 1)
            throw new IllegalArgumentException("" + capacity);

        //设定最小容量就是默认值11，防止用户设置的太小
        if (capacity < DEFAULT_INITIAL_CAPACITY)
            capacity = DEFAULT_INITIAL_CAPACITY;

        this.array = new Object[capacity];
        this.comparator = comparator;
    }

    /**
     * 底层数组扩容
     */
    private void grow() {
        int oldCapacity = this.array.length;
        int newCapacity = (int) (oldCapacity * FACTOR);

        Object[] newEles = new Object[newCapacity];
        //数据迁移
        System.arraycopy(array, 0, newEles, 0, oldCapacity);
        //引用新的数组
        array = newEles;
    }

    /**
     * 清空整个堆
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
        size = 0;
    }

    /**
     * 获取堆中元素的个数
     *
     * @return 堆中元素的个数
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取堆顶的元素（此方法并不会弹出对顶元素）
     *
     * @return 返回对顶的元素，如果堆为空，则返回null
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        return size == 0 ? null : (T) array[0];
    }

    /**
     * 向堆中添加一个元素
     *
     * @param value 待添加的元素
     * @return 添加成功返回true，否则返回false
     */
    public boolean add(T value) {
        if (value == null)
            throw new NullPointerException("value : " + null);

        //如果数组已满，数组成长
        if (size + 1 > array.length)
            grow();

        array[size++] = value;

        if (size == 1)
            return true;

        heapifyOfUp(size - 1);

        return true;
    }

    /**
     * 弹出堆顶元素
     *
     * @return 堆顶元素，如果堆为空则返回null
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0)
            return null;

        T value = (T) array[0];

        swap(array, 0, --size);
        array[size] = null; // clear to let GC do its work

        heapifyOfDown(0);

        return value;
    }

    /**
     * 向下的堆化  此操作往往是由于堆顶元素弹出之后新的堆顶元素向下堆化以保证堆的特性而触发的
     *
     * @param index 触发向下堆化的下标
     */
    @SuppressWarnings("unchecked")
    private void heapifyOfDown(int index) {
        //父节点下标
        int parentIndex = index;
        //左孩子下标
        int leftChildIndex = (index << 1) + 1;
        //右孩子下标
        int rightChildIndex = leftChildIndex + 1;

        //用于记录左右孩子值“小”者的下标
        int minIndex;

        if (comparator != null) {  // 比较器定义的“大小”
            while (leftChildIndex < size) {
                if (rightChildIndex < size) { //存在右孩子
                    if (comparator.compare((T) array[leftChildIndex], (T) array[rightChildIndex]) < 0)
                        minIndex = leftChildIndex;
                    else
                        minIndex = rightChildIndex;

                    //父“大于”子，子上来，父下去
                    if (comparator.compare((T) array[parentIndex], (T) array[minIndex]) > 0)
                        swap(array, parentIndex, minIndex);

                    //新的父节点下标
                    parentIndex = minIndex;
                    //新的左孩子下标
                    leftChildIndex = (parentIndex << 1) + 1;
                    //新的右孩子下标
                    rightChildIndex = leftChildIndex + 1;
                } else { //不存在右孩子
                    //父“大于”子，子上来，父下去
                    if (comparator.compare((T) array[parentIndex], (T) array[leftChildIndex]) > 0)
                        swap(array, parentIndex, leftChildIndex);

                    //新的父节点下标
                    parentIndex = leftChildIndex;
                    //新的左孩子下标
                    leftChildIndex = (parentIndex << 1) + 1;
                    //新的右孩子下标
                    rightChildIndex = leftChildIndex + 1;
                }
            }
        } else {  // 自然排序的“大小”
            while (leftChildIndex < size) {
                if (rightChildIndex < size) { //存在右孩子
                    Comparable<? super T> parent = (Comparable<? super T>) array[parentIndex];
                    Comparable<? super T> leftChild = (Comparable<? super T>) array[leftChildIndex];

                    if (leftChild.compareTo((T) array[rightChildIndex]) < 0)
                        minIndex = leftChildIndex;
                    else
                        minIndex = rightChildIndex;

                    //父“大于”子，子上来，父下去
                    if (parent.compareTo((T) array[minIndex]) > 0)
                        swap(array, parentIndex, minIndex);

                    //新的父节点下标
                    parentIndex = minIndex;
                    //新的左孩子下标
                    leftChildIndex = (parentIndex << 1) + 1;
                    //新的右孩子下标
                    rightChildIndex = leftChildIndex + 1;
                } else { //不存在右孩子
                    Comparable<? super T> parent = (Comparable<? super T>) array[parentIndex];

                    if (parent.compareTo((T) array[leftChildIndex]) > 0)
                        swap(array, parentIndex, leftChildIndex);

                    //新的父节点下标
                    parentIndex = leftChildIndex;
                    //新的左孩子下标
                    leftChildIndex = (parentIndex << 1) + 1;
                    //新的右孩子下标
                    rightChildIndex = leftChildIndex + 1;
                }
            }
        }

    }

    /**
     * 向上的堆化  此操作往往是由于向堆中添加一个元素之后触发的
     *
     * @param index 触发向上堆化的元素下标
     */
    @SuppressWarnings("unchecked")
    private void heapifyOfUp(int index) {
        int childIndex = index;
        int parentIndex = (childIndex - 1) >> 1;

        if (comparator != null) {  // 比较器定义的“大小”
            while (parentIndex >= 0 &&
                    parentIndex < childIndex &&
                    comparator.compare((T) array[childIndex], (T) array[parentIndex]) < 0) {
                //堆化，“小”的向上走, “大”的向下走
                swap(array, childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (parentIndex - 1) >> 1;
            }
        } else {  // 自然排序的“大小”
            Comparable<? super T> key = (Comparable<? super T>) array[index];
            while (parentIndex >= 0 &&
                    parentIndex < childIndex &&
                    key.compareTo((T) array[parentIndex]) < 0) {
                //堆化，“小”的向上走, “大”的向下走
                swap(array, childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (parentIndex - 1) >> 1;
                key = (Comparable<? super T>) array[childIndex];
            }
        }

    }

    /**
     * 交换指定数组上两个下标对应的值
     *
     * @param arr 指定数组
     * @param i1  下标1
     * @param i2  下标2
     */
    private void swap(Object[] arr, int i1, int i2) {
        Object temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
