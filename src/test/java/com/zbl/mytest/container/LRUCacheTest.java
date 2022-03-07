package com.zbl.mytest.container;

import com.zbl.ds.container.LRUCache;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/5 12:16
 */
public class LRUCacheTest {

    @Test
    public void testLRUCache() {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "1");
        lruCache.put(2, "2");
        lruCache.put(3, "3");
        System.out.println(lruCache);

        lruCache.put(4, "4");
        System.out.println(lruCache);

        lruCache.get(2);
        System.out.println(lruCache);

        lruCache.put(5, "5");
        System.out.println(lruCache);
    }

    @Test
    public void testLRUCache2() {
        LRUCache<Integer, String> lruCache = new LRUCache<>(15, 0.7f, 3);
        lruCache.put(1, "1");
        lruCache.put(2, "2");
        lruCache.put(3, "3");
        System.out.println(lruCache);

        lruCache.put(4, "4");
        System.out.println(lruCache);

        lruCache.get(2);
        System.out.println(lruCache);

        lruCache.put(5, "5");
        System.out.println(lruCache);
    }
}
