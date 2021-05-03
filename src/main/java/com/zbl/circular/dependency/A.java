package com.zbl.circular.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 循环依赖演示(单例情况下可以spring自己可以解决循环依赖)
 * Error creating bean with name 'a': Requested bean is currently in creation:
 * Is there an unresolvable circular reference?
 */
@Component
//@Scope("prototype")
@SuppressWarnings("unused")
public class A {

    @SuppressWarnings("all")
    @Autowired
    private B b;

    public A() {
        System.out.println("A...A()...");
    }

    /*
     * 切记：构造注入无法解决循环依赖问题，无论是单例还是多例
     *  ***************************
        APPLICATION FAILED TO START
        ***************************

        Description:

        The dependencies of some of the beans in the application context form a cycle:

        ┌─────┐
        |  a defined in file [D:\ideaProject\MyCode\target\classes\com\zbl\circular\dependency\A.class]
        ↑     ↓
        |  b defined in file [D:\ideaProject\MyCode\target\classes\com\zbl\circular\dependency\B.class]
        └─────┘
     *
     */
    /*public A(B b) {
        this.b = b;
    }*/
}
