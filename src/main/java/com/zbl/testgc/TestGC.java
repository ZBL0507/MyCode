package com.zbl.testgc;

/**
 * -XX:InitialHeapSize=16777216
 * -XX:MaxHeapSize=16777216
 * -XX:+PrintCommandLineFlags
 * -XX:+PrintGCDetails
 * -XX:-UseLargePagesIndividualAllocation
 */
@SuppressWarnings("unused")
public class TestGC {
    public static void main(String[] args) {
        System.out.println("hhh");
        byte[] bytes = new byte[10944 * 1024];
    }
}
