package com.zbl.circular.dependency;

import org.springframework.stereotype.Component;

@Component
public class CC {

    public CC() {
        System.out.println("CC...CC()...");
    }
}
