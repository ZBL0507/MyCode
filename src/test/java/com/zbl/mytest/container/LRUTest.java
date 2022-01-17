package com.zbl.mytest.container;

import com.zbl.ds.container.LRU;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/1/17 17:15
 */
public class LRUTest {

    @Test
    public void test() {
        LRU lru = new LRU(5);
        lru.pushFont(12,"324");
        lru.printStr();
        lru.pushFont("o3uw4","324");
        lru.printStr();
        lru.pushFont("897e45","324");
        lru.pushFont("898734","324");
        lru.printStr();
        lru.pushFont("456","324");
        lru.printStr();
        lru.pushFont("sdfs","324");
        lru.printStr();
        lru.get("o3uw4");
        lru.printStr();
        lru.get("sdfs");
        lru.printStr();
        lru.removeKey("sdfs");
        lru.printStr();
        lru.removeLast();
        lru.printStr();
        lru.removeLast();
        lru.printStr();
        lru.removeLast();
        lru.printStr();
        lru.removeLast();
        lru.printStr();
        lru.removeLast();
        lru.printStr();
    }
}
