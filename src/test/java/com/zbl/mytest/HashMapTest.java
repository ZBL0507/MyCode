package com.zbl.mytest;

import com.zbl.mytest.bean.TestUser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/7/27 10:37
 */
public class HashMapTest {

    static class User {
        @Override
        public int hashCode() {
            return 808908;
        }
    }

    @Test
    public void testHashMap() {
        HashMap<User, User> map = new HashMap<>(128);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            map.put(user, user);
        }
    }


    @Test
    public void testPut() {
        /*
         *  1. HashMap 何时初始化？
         *  第一次放入元素的时候，才开始初始化 transient Node<K,V>[] table 数组;
         *  当未指定初始容量或指定的初始容量小于16时，table数组都初始化为16大小
         *
         *  2. 负载因子
         *  默认的负载因子：static final float DEFAULT_LOAD_FACTOR = 0.75f;
         *
         *  3. 带初始容量的构造函数
         *  当指定的容量小于16时，会调整容量为16
         *  当指定的容量大于16且小于32时，会调整容量为32，依次类推
         *  这样的做法完全是为了方便计算下标
         *      tab[i = (n - 1) & hash]  其中 n 为table数组的长度， 每次将table数组的长度调整为2^x 就是为了方便与运算
         *
         *  4. 哈希冲突时，树化的过程
         *  首先是采用拉链法解决冲突，当链的长度超过8(超过8时！！！)时，才准备树化(这时是准备树化，并不一定是树化)
         *  并且是先将元素挂在链上才进一步准备是否要真的树化
         *  树化的时候会有如下判断
         *  if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY) {
         *     resize();
         *  }   其中， static final int MIN_TREEIFY_CAPACITY = 64;
         *
         */
        HashMap<TestUser, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(new TestUser(i), i);
        }

        System.out.println("map.size: " + map.size());

        for (Map.Entry<TestUser, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }
}
