package com.zbl.ds.structure;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/1/17 15:12
 * <p>
 * LRU存储数据的结构
 */
public class LRUStructure {

    /**
     * 存储数据的结构，方便快速访问和删除元素
     */
    private HashMap<Object, Object> eles;

    /**
     * 存储数据的顺序结构
     */
    private LinkedList<Object> deque;

    public LRUStructure() {
        this.eles = new HashMap<>();
        this.deque = new LinkedList<>();
    }

    /**
     * 向LRU结构中增加一个元素
     *
     * @param key key
     * @param val val
     */
    public void putEle(Object key, Object val) {
        eles.put(key, val);
        deque.remove(key);
        deque.addFirst(key);
    }

    /**
     * 访问元素
     *
     * @param key key
     * @return 如果存在则返回key对应val，否则返回null
     */
    public Object get(Object key) {
        Object val = eles.get(key);
        if (val != null) {
            //将访问的元素放到最前面
            deque.remove(key);
            deque.addFirst(key);
        }
        return val;
    }

    /**
     * 删除一个key
     *
     * @param key key
     */
    public void removeKey(Object key) {
        eles.remove(key);
        deque.remove(key);
    }

    /**
     * 移除LRUStructure结构中最长时间未使用的元素
     */
    public void removeLast() {
        if (deque.isEmpty())
            return;

        eles.remove(deque.getLast());
        deque.removeLast();
    }

    /**
     * 以字符串的格式打印LRUStructure中所有的元素
     */
    public void printStr() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        if (!deque.isEmpty()) {
            deque.forEach(e -> {
                Object val = eles.get(e);
                builder.append(" ").append(e).append("=").append(val).append(",");
            });
        }
        if (builder.charAt(builder.length() - 1) == ',') {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(" }");
        System.out.println(builder.toString());
    }

    /**
     * 获取LRUStructure的元素数量
     *
     * @return LRUStructure的元素数量
     */
    public int size() {
        return deque.size();
    }
}
