### sql执行流程
    1. 客户端 向 服务端 发起请求
    
    2. 服务端查询缓存，若缓存命中，则直接返回，否则进行步骤3 (mysql8.0不再有这个缓存)
    
    3. 词法解析，语法解析，预处理器进行预处理
    
    4. 查询优化器进行优化
    
    5. 生成执行计划，交于存储引擎进行查询
    
    6. 缓存结果，返回结果
    
### mysql的profiling
```sql
-- 通过开启profiling来了解查询语句的执行过程及耗时
-- select @@profiling; 或者 show variables like '%profiling%'; 查看是否开启计划，开启它可以让mysql收集在sql执行时所使用的资源情况
mysql> select @@profiling;
mysql> show variables like '%profiling%';

-- 临时开启profiling
mysql> set profiling = 1;

-- 使用show profiles;查看语句的执行过程及耗时
mysql> show profiles;
```
