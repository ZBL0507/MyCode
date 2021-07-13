package com.zbl;

import com.zbl.circular.dependency.A;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("unused")
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        A a = context.getBean("a", A.class);

        Object b = context.getBean("b");
    }
}
