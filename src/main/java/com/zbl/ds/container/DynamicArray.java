package com.zbl.ds.container;

import java.util.Arrays;
import java.util.Collection;

/**
 * 动态数组(支持随机访问, 最大容量：Integer.MAX_VALUE)
 */
@SuppressWarnings("unused")
public class DynamicArray<T> {
    /**
     * 真正存储元素的数组
     */
    private T[] array = null;

    /**
     * array初始容量
     */
    private static final int INIT_CAPACITY = 10;

    /**
     * 有效元素的个数
     */
    private int size;

    /**
     * array的长度
     */
    private int capacity;

    /**
     * 默认的扩展因子
     */
    private static final double DEFAULT_FACTOR = 1.5;

    /**
     * 扩展因子
     */
    private double factor;

    /**
     * 空参构造器
     */
    public DynamicArray() {
        this.factor = DEFAULT_FACTOR;
    }

    /**
     * 带有数组容量的构造器
     *
     * @param length 指定的数组容量
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int length) {
        if (length < INIT_CAPACITY) {  //对输入参数进行调整
            length = INIT_CAPACITY;
        }
        this.array = (T[]) new Object[length];
        this.capacity = length;
        this.factor = DEFAULT_FACTOR;
    }

    /**
     * 带有数组容量和扩展因子的构造器
     *
     * @param length 指定的数组容量
     * @param factor 扩展因子
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int length, double factor) {
        if (length < INIT_CAPACITY) {  //对输入参数进行调整
            length = INIT_CAPACITY;
        }
        array = (T[]) new Object[length];
        this.capacity = length;

        if (factor < DEFAULT_FACTOR) { //对输入参数进行调整
            factor = DEFAULT_FACTOR;
        }
        this.factor = factor;
    }

    /**
     * 构造函数，将一个集合构造成为一个动态数组
     *
     * @param collection 给定的集合
     */
    public DynamicArray(Collection<? extends T> collection) {
        this();
        collection.forEach(this::add);
    }

    /**
     * 构造函数，将一个普通数组构造成为一个动态数组
     *
     * @param arr 给定的普通数组
     */
    public DynamicArray(T[] arr) {
        this();
        Arrays.stream(arr).forEach(this::add);
    }

    /**
     * 构造函数，将一个普通数组构造成为一个动态数组
     *
     * @param arr 给定的普通数组
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int[] arr) {
        this();
        Arrays.stream(arr).forEach(e -> this.add((T) new Integer(e)));
    }

    /**
     * 构造函数，将一个普通数组构造成为一个动态数组
     *
     * @param arr 给定的普通数组
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(long[] arr) {
        this();
        Arrays.stream(arr).forEach(e -> this.add((T) new Long(e)));
    }


    /**
     * 当前数组元素个数
     *
     * @return 当前数组元素个数
     */
    public int size() {
        return this.size;
    }

    /**
     * 获取指定下标上的元素
     *
     * @param index 下标
     * @return 该下标对应的元素
     */
    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("" + index);
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("" + index);
        }
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(array[i]).append("\t");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    /**
     * 向动态数组中加入一个元素
     *
     * @param value 待加入的元素
     * @return 加入成功返回true，否则返回false
     */
    public boolean add(T value) {
        if (size + 1 > capacity) {
            arrayExtend();
        }
        array[size++] = value;
        return true;
    }

    /**
     * 向动态数组中加入多个元素
     *
     * @param values 待加入的多个元素
     * @return 加入成功返回true，否则返回false
     */
    public boolean addAll(T... values) {
        Arrays.stream(values).forEach(this::add);
        return true;
    }

    /**
     * 向动态数组中加入多个元素
     *
     * @param values 待加入的多个元素
     * @return 加入成功返回true，否则返回false
     */
    public boolean addAll(Collection<? extends T> values) {
        values.forEach(this::add);
        return true;
    }


    /**
     * 将动态数组转化为普通数组
     *
     * @return 普通数组
     */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(array, 0, arr, 0, arr.length);
        return arr;
    }


    /**
     * array扩容
     */
    @SuppressWarnings("unchecked")
    private void arrayExtend() {
        if (null == array) {  // 一开始array为空直接初始化为长度为INIT_CAPACITY的数组
            this.array = (T[]) new Object[capacity == 0 ? INIT_CAPACITY : capacity];
            this.capacity = capacity == 0 ? INIT_CAPACITY : capacity;
            return;
        }
        //扩容
        int oldCapacity = this.capacity;
        int newCapacity = (int) (oldCapacity * factor); // 新的容量
        this.capacity = newCapacity;

        T[] oldArray = this.array;
        T[] newArray = (T[]) new Object[newCapacity]; // 开一个新的数组
        // 老数组中元素迁移到新数组中去
        if (size >= 0)
            System.arraycopy(oldArray, 0, newArray, 0, size);
        this.array = newArray;  // array去引用新的数组
    }
}
