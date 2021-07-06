package com.zbl.ds.container;

/**
 * 数据结构-栈
 * 采用适配器模式实现，用动态数组适配出栈结构
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/6 16:37
 */
public class MyStack<T> {

    /**
     * 真正保存元素的结构
     */
    private DynamicArray<T> elements;


    /**
     * 无参构造器
     */
    public MyStack() {
        this.elements = new DynamicArray<>();
    }


    /**
     * 向栈中压入一个元素
     *
     * @param value 待压入的元素
     * @return 压入成功返回true， 否则返回false
     */
    public boolean push(T value) {
        return elements.add(value);
    }

    /**
     * 从栈中弹出一个元素
     *
     * @return 返回弹出的元素, 如果栈为空则返回null
     */
    public T pop() {
        if (elements.isNotEmpty())
            return elements.removeLastElement();

        return null;
    }

    /**
     * 访问栈顶元素
     *
     * @return 栈顶元素，如果栈为空则返回null
     */
    public T peek() {
        if (elements.isNotEmpty())
            return elements.get(elements.size() - 1);

        return null;
    }

    /**
     * 判断栈是否为空
     *
     * @return 如果栈为空则返回true， 否则返回false
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * 判断栈是否不为空
     *
     * @return 如果栈不为空则返回true， 否则返回false
     */
    public boolean isNotEmpty() {
        return elements.isNotEmpty();
    }

    /**
     * 获取栈中元素的数量
     *
     * @return 栈中元素的数量
     */
    public int size() {
        return elements.size();
    }
}
