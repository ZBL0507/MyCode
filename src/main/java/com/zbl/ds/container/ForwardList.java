package com.zbl.ds.container;

import com.zbl.ds.structure.ForwardListNode;

import java.util.Collection;

/**
 * 单向链表， 形如：A -> B -> C -> D
 *
 * @param <T> 泛型
 */
@SuppressWarnings("unused")
public class ForwardList<T> {

    /**
     * 链表头节点, 不保存实际数据，为了方便操作链表使用
     */
    private ForwardListNode<T> head;

    /**
     * 链表尾节点
     */
    private ForwardListNode<T> tail;

    public ForwardList() {
        ForwardListNode<T> node = new ForwardListNode<>();
        this.head = node;
        this.tail = node;
    }

    public ForwardList(T[] arr) {
        this();
        for (T value : arr) {
            this.insert(value);
        }
    }

    public ForwardList(Collection<T> collection) {
        this();
        collection.forEach(this::insert);
    }

    /**
     * 在链表中插入一个元素
     *
     * @param value 待插入的元素
     * @return 插入成功返回true， 失败返回false
     */
    public boolean insert(T value) {
        if (null == value)
            throw new NullPointerException();

        return insert(value, true);
    }

    /**
     * 在链表中插入一个元素
     *
     * @param isTailIn 是否是尾插入
     * @param value    待插入的元素
     * @return 插入成功返回true， 失败返回false
     */
    public boolean insert(T value, boolean isTailIn) {
        if (null == value)
            throw new NullPointerException();

        ForwardListNode<T> node = new ForwardListNode<>(value);
        if (isTailIn) {
            return insert(node);
        }
        return insert(node, false);
    }

    /**
     * 判断是否是一个空链表， 即一个有效节点都没有的链表为空
     *
     * @return 如果链表为空则返回true， 否则返回false
     */
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    /**
     * 删除链表中第一个有效的节点，并返回该节点的数据值
     *
     * @return 第一个有效节点的数据值， 如果没有第一个有效节点则返回null
     */
    public T pop() {
        T v = null;

        ForwardListNode<T> pre, p;
        pre = this.head;
        p = this.head.next;

        if (null != p) {
            pre.next = p.next;
            p.next = null;
            v = p.value;
        }

        if (null == this.head.next) {
            this.tail = this.head;
        }

        return v;
    }

    /**
     * 删除链表中元素为给定值的节点， 只删除从头到尾第一次满足条件的节点
     *
     * @param value 给定值
     * @return 删除成功返回元素值，否则返回null
     */
    public T remove(T value) {
        T v = null;

        ForwardListNode<T> pre, p;
        pre = this.head;
        p = this.head.next;
        for (; p != null; p = p.next, pre = pre.next) {
            if (p.value.equals(value)) {
                pre.next = p.next;
                v = p.value;
                p.next = null;
                break;
            }
        }

        if (null == this.head.next) {
            this.tail = this.head;
        }

        return v;
    }

    /**
     * 删除链表中元素为给定值的节点
     *
     * @param value 给定值
     * @return 删除成功返回元素值，否则返回null
     */
    public T removeAll(T value) {
        T v = null;

        ForwardListNode<T> pre, p;
        pre = this.head;
        p = this.head.next;
        for (; p != null; ) {
            if (p.value.equals(value)) {
                pre.next = p.next;
                v = p.value;
                p.next = null;
                p = pre.next;
                continue;
            }
            p = p.next;
            pre = pre.next;
        }

        if (null == this.head.next) {
            this.tail = this.head;
        }

        return v;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("head");
        ForwardListNode<T> p = this.head.next;
        for (; p != null; p = p.next) {
            str.append(" -> ").append(p.value);
        }
        return str.toString();
    }

    /**
     * 插入新节点进链表
     *
     * @param node 待插入的节点
     * @return 插入成功返回true， 失败返回false
     */
    private boolean insert(ForwardListNode<T> node) {
        return insert(node, true);
    }

    /**
     * 插入新节点进链表
     *
     * @param node     待插入的节点
     * @param isTailIn 是否是尾插入
     * @return 插入成功返回true， 失败返回false
     */
    private boolean insert(ForwardListNode<T> node, boolean isTailIn) {
        if (isTailIn) {
            return insertInTail(node);
        } else {
            return insertInHead(node);
        }
    }

    /**
     * 插入节点到链表头部
     *
     * @param node 待插入的节点
     * @return 插入成功返回true， 失败返回false
     */
    private boolean insertInHead(ForwardListNode<T> node) {
        node.next = this.head.next;
        this.head.next = node;
        return true;
    }

    /**
     * 插入节点到链表尾部
     *
     * @param node 待插入的节点
     * @return 插入成功返回true， 失败返回false
     */
    private boolean insertInTail(ForwardListNode<T> node) {
        this.tail.next = node;
        this.tail = node;
        return true;
    }

    /**
     * 将单向链表转化为一个动态数组
     *
     * @return 转化后的动态数组
     */
    public DynamicArray<T> toDynamicArray() {
        DynamicArray<T> dynamicArray = new DynamicArray<>();
        ForwardListNode<T> p = this.head.next;
        for (; p != null; p = p.next)
            dynamicArray.add(p.value);

        return dynamicArray;
    }
}
