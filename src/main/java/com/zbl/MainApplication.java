package com.zbl;

import com.zbl.circular.dependency.A;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

@SuppressWarnings("unused")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {

        System.out.println("Get JDK Default GC for jdk"
                + System.getProperty("java.version") + " - "
                + System.getProperty("java.vm.name") + ":");

        for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println(gcBean.getName());
        }

        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        A a = context.getBean("a", A.class);

        Object b = context.getBean("b");
    }
}
