package com.zbl.ds.container;

import java.lang.reflect.Array;
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
     * array的长度，即动态数组的容量
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
     * 判断数组是否为空
     *
     * @return 如果为空返回true，否则返回false
     */
    @SuppressWarnings("all")
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断数组是否不空
     *
     * @return 如果为不空返回true，否则返回false
     */
    public boolean isNotEmpty() {
        return !isEmpty();
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
        if (size == 0)
            return "[ ]";

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(array[i]).append("  ");
        }
        builder.deleteCharAt(builder.length() - 1);
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
    @SuppressWarnings("all")
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
     * 将动态数组转化为普通数组
     *
     * @param newType 要转化的数组类型
     * @return 普通数组
     */
    public T[] toArray(Class<? extends T[]> newType) {
        @SuppressWarnings("all")
        T[] arr = ((Object) newType == (Object) Object[].class)
                ? (T[]) new Object[size]
                : (T[]) Array.newInstance(newType.getComponentType(), size);
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

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            array[i] = null;

        size = 0;
    }

    /**
     * 在动态数组中删除指定的元素（只删除第一次出现的）
     *
     * @param value 指定的元素
     * @return 删除成功返回true，删除失败返回false，找不到指定的元素也认为删除成功
     */
    @SuppressWarnings("all")
    public boolean remove(T value) {
        if (null == value)
            throw new NullPointerException();

        for (int i = 0; i < size; i++)
            if (value.equals(array[i])) {
                if (size - 1 - i > 0)
                    System.arraycopy(array, i + 1, array, i, array.length - 1 - i);

                array[--size] = null; // clear to let GC do its work
                return true;
            }

        return true;
    }

    /**
     * 删除动态数组中指定下标上的元素，并返回这个删除的元素
     *
     * @param index 指定的下标
     * @return 删除的元素
     */
    public T remove(int index) {
        if (index < 0)
            throw new IllegalArgumentException("" + index);

        if (index >= size)
            throw new IndexOutOfBoundsException("" + index);

        //保存待删除的元素
        T value = array[index];

        if (size - 1 - index > 0)
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);

        array[--size] = null; // clear to let GC do its work

        return value;
    }

    /**
     * 删除动态数组中第一个元素，并返回
     *
     * @return 返回动态数组中第一个元素，若动态数组为空则返回null
     */
    public T removeFirstElement() {
        if (0 == size)
            return null;
        return remove(0);
    }

    /**
     * 删除动态数组中最后一个元素，并返回
     *
     * @return 返回动态数组中最后一个元素，若动态数组为空则返回null
     */
    public T removeLastElement() {
        if (0 == size)
            return null;
        return remove(size - 1);
    }
}
