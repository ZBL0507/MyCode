# jvm常用参数

## 1. 堆初始大小
```text
-Xms 初始大小内存，默认为物理内存1/64 

等价于 -XX:InitialHeapSize
```

<br>
<br>

## 2. 堆最大大小
```text
-Xmx 堆最大大小，默认为物理内存的1/4

等价于 —XX:MaxHeapSize
```

<br>
<br>

## 3. 栈大小
```text
-Xss 设置单个线程栈的大小，一般默认为512K～1024K

等价于 -XX:ThreadStackSize
```

<br>
<br>

## 4. 打印gc日志
```text
-XX:+PrintGCDetails

zulu jdk11 的一个案例:(macos12.2.1系统，物理内存大小16GB)
vm: -XX:+PrintGCDetails

[0.002s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
[0.006s][info   ][gc,heap] Heap region size: 1M
[0.006s][info   ][gc     ] Using G1
[0.006s][info   ][gc,heap,coops] Heap address: 0x00000006c0000000, size: 4096 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
[0.073s][info   ][gc,heap,exit ] Heap
[0.073s][info   ][gc,heap,exit ]  garbage-first heap   total 262144K, used 2048K [0x00000006c0000000, 0x00000007c0000000)
[0.073s][info   ][gc,heap,exit ]   region size 1024K, 3 young (3072K), 0 survivors (0K)
[0.073s][info   ][gc,heap,exit ]  Metaspace       used 5870K, capacity 5961K, committed 6272K, reserved 1056768K
[0.073s][info   ][gc,heap,exit ]   class space    used 512K, capacity 543K, committed 640K, reserved 1048576K
```

















