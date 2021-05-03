package com.zbl.circular.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 循环依赖演示
 * Error creating bean with name 'a': Requested bean is currently in creation:
 * Is there an unresolvable circular reference?
 */
@Component
@Scope("prototype")
@SuppressWarnings("unused")
public class B {

    @SuppressWarnings("all")
    @Autowired
    private A a;

    /*public B(A a) {
        this.a = a;
    }*/
}
