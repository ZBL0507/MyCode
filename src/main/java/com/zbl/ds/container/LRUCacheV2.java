package com.zbl.ds.container;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个lru缓存结构
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/5 16:58
 */
public class LRUCacheV2<K, V> {

    /**
     * 缓存大小
     */
    private final int capacity;

    /**
     * 用于快速访问
     */
    Map<K, Node<K, V>> map;

    /**
     * 用于有序排列
     */
    DoubleLinkedList<K, V> doubleLinkedList;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public Node<K, V> get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node<K, V> node = map.get(key);
        doubleLinkedList.remove(node);
        doubleLinkedList.addTail(node);

        return node;
    }

    public void add(K key, V val) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = val;
            map.put(key, node);
            doubleLinkedList.remove(node);
        } else {
            node = new Node<>(key, val);
            map.put(key, node);
        }
        doubleLinkedList.addTail(node);

        if (map.size() > capacity) {
            Node<K, V> firstNode = doubleLinkedList.getFirstNode();
            map.remove(firstNode.key);
            doubleLinkedList.remove(firstNode);
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LRUCache:{ ");
        for (Node<K, V> p = doubleLinkedList.head.next; p != doubleLinkedList.tail; p = p.next) {
            builder.append(p.toString()).append("; ");
        }
        if (builder.toString().contains("Node")) {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(" }");
        return builder.toString();
    }

    /**
     * 构建一个双向的链表，里面存放的就是{@link Node}
     *
     * @param <K> node key type
     * @param <V> node value type
     */
    static class DoubleLinkedList<K, V> {
        /**
         * 头部哨兵节点，不存储实际元素
         */
        Node<K, V> head;

        /**
         * 尾部哨兵节点，不存储实际元素
         */
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加元素到链表头部
         *
         * @param node 待添加的元素
         */
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        /**
         * 添加元素到链表尾部
         *
         * @param node 待添加的元素
         */
        public void addTail(Node<K, V> node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
        }

        /**
         * 从链表中删除一个节点
         *
         * @param node 待删除的节点
         */
        public void remove(Node<K, V> node) {
            if (null == node)
                return;

            if (node == head || node == tail)
                return;

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        /**
         * 获取链表中的最后一个有效节点
         *
         * @return 如果有则返回最后一个有效节点，否则返回null
         */
        public Node<K, V> getLastNode() {
            Node<K, V> lastNode = tail.next;
            return lastNode == head ? null : lastNode;
        }

        /**
         * 获取链表中的第一个有效节点
         *
         * @return 如果有则返回第一个有效节点，否则返回null
         */
        public Node<K, V> getFirstNode() {
            Node<K, V> firstNode = head.next;
            return firstNode == tail ? null : firstNode;
        }


    }

    /**
     * 用于存放元素的节点
     *
     * @param <K> key的类型
     * @param <V> value的类型
     */
    static class Node<K, V> {
        K key;
        V value;

        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
