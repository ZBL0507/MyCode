package com.zbl.ds.container;

import com.zbl.ds.structure.LRUStructure;


/**
 * 实现效率低下，不再推荐使用！！！
 * 推荐使用{@link LRUCache} 和 {@link LRUCacheV2}代替
 *
 * @author zbl
 * @version 1.0
 * @since 2022/1/17 14:43
 * <p>
 * 最近最少使用
 */
@Deprecated
public class LRU {

    /**
     * 真正存储数据的结构
     */
    private LRUStructure lruStructure;

    /**
     * LRU存储数据量的大小
     */
    private int size;

    /**
     * 初始化一个空的LRU结构，LRU存储数据量的大小设置为10
     */
    public LRU() {
        this.lruStructure = new LRUStructure();
        this.size = 10;
    }

    /**
     * 初始化一个空的LRU结构，LRU存储数据量的大小设置为size
     */
    public LRU(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("incorrect size: " + size);

        this.lruStructure = new LRUStructure();
        this.size = size;
    }

    /**
     * 新增加一对 key-val
     *
     * @param key key
     * @param val val
     */
    public void pushFont(Object key, Object val) {
        if (lruStructure.size() == size) {
            lruStructure.removeLast();
        }
        lruStructure.putEle(key, val);
    }

    /**
     * 访问元素key
     *
     * @param key key
     * @return 如果有这个元素，则返回， 否则返回null
     */
    public Object get(Object key) {
        return lruStructure.get(key);
    }

    /**
     * 删除一个key
     *
     * @param key key
     */
    public void removeKey(Object key) {
        lruStructure.removeKey(key);
    }

    /**
     * 移除LRUStructure结构中最长时间未使用的元素
     */
    public void removeLast() {
        lruStructure.removeLast();
    }

    /**
     * 以字符串的格式打印LRUStructure中所有的元素
     */
    public void printStr() {
        lruStructure.printStr();
    }
}
