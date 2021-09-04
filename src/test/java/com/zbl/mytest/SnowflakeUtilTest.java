package com.zbl.mytest;

import cn.hutool.core.lang.Snowflake;
import com.zbl.util.SnowflakeUtil;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/9/4 14:56
 */
public class SnowflakeUtilTest {
    private final static Snowflake SNOWFLAKE = new Snowflake();

    @Test
    public void test01() {
        long count = 100_0000L;
        long startTime = System.nanoTime();
        for (long i = 0; i < count; i++) {
            long nextId = SNOWFLAKE.nextId();
            String to64Radix = SnowflakeUtil.to64Radix(nextId);
            long toLong = SnowflakeUtil.toLong(to64Radix);
            if (nextId != toLong) {
                throw new RuntimeException("test fail " +
                        "nextId=" + nextId
                        + ", to64Radix=" + to64Radix
                        + ", toLong=" + toLong);
            }
        }
        System.out.println("use time nanoTime : " + (System.nanoTime() - startTime));
        System.out.println("test success pass!");
    }

    @Test
    public void myTest002() {
        for (int i = 0; i < 100; i++) {
            System.out.println("test number : " + (i + 1));
            test01();
        }
    }

    @Test
    public void myTest003() {
        long nextId = SNOWFLAKE.nextId();
        System.out.println("nextId: " + nextId);
        String to64Radix = SnowflakeUtil.to64Radix(nextId);
        System.out.println("to64Radix: " + to64Radix);
        long toLong = SnowflakeUtil.toLong(to64Radix);
        System.out.println("toLong: " + toLong);
    }
}
