package com.zbl.mytest.container;

import com.zbl.ds.container.LRUCacheV2;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/3/5 18:00
 */
public class LRUCacheV2Test {

    @Test
    public void test() {
        LRUCacheV2<Integer, String> lruCacheV2 = new LRUCacheV2<>(3);
        lruCacheV2.add(1,"111");
        lruCacheV2.add(2,"222");
        lruCacheV2.add(3,"333");
        System.out.println(lruCacheV2);

        lruCacheV2.get(1);
        System.out.println(lruCacheV2);

        lruCacheV2.add(4, "444");
        lruCacheV2.add(4, "444");
        lruCacheV2.add(4, "444");
        lruCacheV2.add(4, "444");
        System.out.println(lruCacheV2);

        lruCacheV2.add(5, "555");
        System.out.println(lruCacheV2);
    }
}
