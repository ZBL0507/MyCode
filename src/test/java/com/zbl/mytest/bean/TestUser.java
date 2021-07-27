package com.zbl.mytest.bean;

import java.util.HashMap;

/**
 * 这个bean就是为了测试{@link HashMap} 并没有特殊含义
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/27 10:34
 */
public class TestUser {

    private int val;

    public TestUser(int val) {
        this.val = val;
    }

    /**
     * 重写 hashCode() 就是为了哈希冲突 方便调试 {@link HashMap}
     *
     * @return 同一个哈希值
     */
    @Override
    public int hashCode() {
        return 12345678;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "val=" + val +
                '}';
    }
}
