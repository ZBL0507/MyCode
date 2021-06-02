package com.zbl.ds.structure;

/**
 * 单向节点： A -> B -> C -> D
 * @param <T> 泛型
 */
@SuppressWarnings("unused")
public class ForwardListNode<T> {

    /**
     * 数据域，保存数据
     */
    public T value;

    /**
     * 指针域，指向下一个节点
     */
    public ForwardListNode<T> next;

    public ForwardListNode() {
    }

    public ForwardListNode(T value) {
        this.value = value;
    }

    public ForwardListNode(T value, ForwardListNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
