package com.zbl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyApplicationTest {

    @Test
    public void test() {
        System.out.println("SpringBoot单元测试");
    }
}
