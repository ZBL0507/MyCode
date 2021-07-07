package com.zbl.mytest.container;

import com.zbl.ds.container.MyStack;
import org.junit.Test;

/**
 * @author zbl
 * @version 1.0
 * @since 2021/7/6 16:55
 */
public class MyStackTest {
    @Test
    public void testPush() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.push(5));

        System.out.println("栈中元素数量：" + stack.size());

        while (stack.isNotEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void testPop() {
        MyStack<String> stack = new MyStack<>();

        stack.push("11111111");
        stack.push("22222222");
        stack.push("3333333");
        stack.push("44444444");

        System.out.println("栈顶元素" + stack.peek());

        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }
}
