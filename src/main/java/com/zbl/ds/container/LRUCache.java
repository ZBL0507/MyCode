package com.zbl.ds.container;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用{@link LinkedHashMap}实现一个LRU缓存结构。
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/5 12:02
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * 缓存大小
     */
    private final int capacity;

    /**
     * 指定lru缓存大小的构造函数
     *
     * @param capacity lru缓存大小
     */
    public LRUCache(int capacity) {
        super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
        this.capacity = capacity;
    }

    /**
     * 指定底层hashmap构造参数和lru缓存大小的构造函数
     *
     * @param initialCapacity 底层hashmap的初始容量
     * @param loadFactor      底层hashmap的负载因子
     * @param capacity        lru缓存大小
     */
    public LRUCache(int initialCapacity, float loadFactor, int capacity) {
        super(initialCapacity, loadFactor, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}
