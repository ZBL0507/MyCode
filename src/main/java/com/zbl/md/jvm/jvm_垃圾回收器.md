# jvm_垃圾回收器

<br>

## 1. 查看默认使用的垃圾回收器
```text
vm: -XX:+PrintCommandLineFlags -version

程序打印如下：(机器物理内存16GB)
-XX:G1ConcRefinementThreads=8 -XX:GCDrainStackTargetSize=64 -XX:InitialHeapSize=268435456 -XX:MaxHeapSize=4294967296 -XX:+PrintCommandLineFlags 
-XX:ReservedCodeCacheSize=251658240 -XX:+SegmentedCodeCache -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC 
openjdk version "11.0.13" 2021-10-19 LTS
OpenJDK Runtime Environment Zulu11.52+13-CA (build 11.0.13+8-LTS)
OpenJDK 64-Bit Server VM Zulu11.52+13-CA (build 11.0.13+8-LTS, mixed mode)
```

<br>
<br>

## 2. jvm都有哪些垃圾回收器
```text
UseSerialGC 

UseParallelGC

UseParallelOldGC

UseConcMarkSweepGC

UseG1GC
```




