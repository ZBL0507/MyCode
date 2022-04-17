# docker安装mysql主从复制

<br>

### 1. 新建主服务器容器实例 3307
```shell
docker run -p 3307:3306 \
--name mysql-master \
-v /tmp/mydata/mysql-master/log:/var/log/mysql \
-v /tmp/mydata/mysql-master/data:/var/lib/mysql \
-v /tmp/mydata/mysql-master/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql/mysql-server
```

### 2. 进入 /tmp/mydata/mysql-master/conf 目录下新建 my.cnf
```text
[mysqld]
## 设置server_id, 同一局域网中需要唯一
server_id=101
## 指定不需要同步的数据库名称
binlog-ignore-db=mysql
## 开启二进制日志功能
log-bin=mall-mysql-bin
## 设置二进制日志使用内存大小（事务）
binlog_cache_size=1M
## 设置使用的二进制日志格式（mixed, statement, row）
binlog_format=mixed
## 二进制日志过期清理时间，默认值为0；表示不自动清理。
expire_logs_days=7
## 跳过主从复制中遇到的所有错误或者指定类型的错误，避免slave端复制中断
## 如：1062错误是指一些主键重复，1032错误是因为主从数据库数据不一致
slave_skip_errors=1062
```

### 3. 修改完配置后重启 master 实例
```shell
docker restart mysql-master
```

### 4. 进入 mysql-master 容器
```shell
docker exec -it mysql-master bash
```

### 5. master 容器实例内创建数据同步用户
```shell
mysql> create user 'slave'@'%'identified by '123456';
mysql> create user 'slave'@'%'identified with 'mysql_native_password' by '123456';

mysql> grant replication slave, replication client on *.* to 'slave'@'%';
```

### 6. 新建从服务器容器实例 3308
```shell
docker run -p 3308:3306 \
--name mysql-slave \
-v /tmp/mydata/mysql-slave/log:/var/log/mysql \
-v /tmp/mydata/mysql-slave/data:/var/lib/mysql \
-v /tmp/mydata/mysql-slave/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql/mysql-server
```

### 7. 进入 /tmp/mydata/mysql-slave/conf 目录下新建 my.cnf
```text
[mysqld]
## 设置server_id, 同一局域网中需要唯一
server_id=102
## 指定不需要同步的数据库名称
binlog-ignore-db=mysql
## 开启二进制日志功能, 以备slave作为其它数据库实例的master时使用
log-bin=mall-mysql-slave1-bin
## 设置二进制日志使用内存大小（事务）
binlog_cache_size=1M
## 设置使用的二进制日志格式（mixed, statement, row）
binlog_format=mixed
## 二进制日志过期清理时间，默认值为0；表示不自动清理。
expire_logs_days=7
## 跳过主从复制中遇到的所有错误或者指定类型的错误，避免slave端复制中断
## 如：1062错误是指一些主键重复，1032错误是因为主从数据库数据不一致
slave_skip_errors=1062
## relay_log 配置中继日志
relay_log=mall-mysql-relay-bin
## log_slave_updates表示slave将复制事件写进自己的二进制日志
log_slave_updates=1
## slave 设置为只读（具有super权限的用户除外）
read_only=1

```

### 8. 修改完配置后重启 slave 实例
```shell
docker restart mysql-slave
```

### 9. 在主数据库中查看主从同步状态
```shell
mysql> show master status;
+-----------------------+----------+--------------+------------------+-------------------+
| File                  | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+-----------------------+----------+--------------+------------------+-------------------+
| mall-mysql-bin.000002 |      156 |              | mysql            |                   |
+-----------------------+----------+--------------+------------------+-------------------+
1 row in set (0.01 sec)
```

### 10. 进入 mysql-slave 容器
```shell
docker exec -it mysql-slave bash
```

### 11. 在从数据库中配置主从复制
```shell
mysql> change master to master_host='192.168.1.29',
    -> master_user='slave', master_password='123456',
    -> master_port=3307,
    -> master_log_file='mall-mysql-bin.000002', master_log_pos=156,
    -> master_connect_retry=30;
Query OK, 0 rows affected, 10 warnings (0.13 sec)
```

### 12. 在从数据库中查看主从同步状态
```shell
mysql> show slave status \G;
*************************** 1. row ***************************
               Slave_IO_State:
                  Master_Host: 192.168.1.29
                  Master_User: slave
                  Master_Port: 3307
                Connect_Retry: 30
              Master_Log_File: mall-mysql-bin.000001
          Read_Master_Log_Pos: 710
               Relay_Log_File: mall-mysql-relay-bin.000001
                Relay_Log_Pos: 4
        Relay_Master_Log_File: mall-mysql-bin.000001
             Slave_IO_Running: No
            Slave_SQL_Running: No
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 710
              Relay_Log_Space: 156
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
        Seconds_Behind_Master: NULL
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 0
                  Master_UUID:
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State:
           Master_Retry_Count: 86400
                  Master_Bind:
      Last_IO_Error_Timestamp:
     Last_SQL_Error_Timestamp:
               Master_SSL_Crl:
           Master_SSL_Crlpath:
           Retrieved_Gtid_Set:
            Executed_Gtid_Set:
                Auto_Position: 0
         Replicate_Rewrite_DB:
                 Channel_Name:
           Master_TLS_Version:
       Master_public_key_path:
        Get_master_public_key: 0
            Network_Namespace:
1 row in set, 1 warning (0.00 sec)

ERROR:
No query specified
```
### 13. 在从数据库中开启主从同步
```shell
mysql> start slave;
Query OK, 0 rows affected, 1 warning (0.08 sec)
```

### 14. 查看从数据库状态发现已经同步
```shell
mysql> show slave status \G;
*************************** 1. row ***************************
               Slave_IO_State: Waiting for source to send event
                  Master_Host: 192.168.1.29
                  Master_User: slave
                  Master_Port: 3307
                Connect_Retry: 30
              Master_Log_File: mall-mysql-bin.000002
          Read_Master_Log_Pos: 156
               Relay_Log_File: mall-mysql-relay-bin.000002
                Relay_Log_Pos: 329
        Relay_Master_Log_File: mall-mysql-bin.000002
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes
              Replicate_Do_DB: 
          Replicate_Ignore_DB: 
           Replicate_Do_Table: 
       Replicate_Ignore_Table: 
      Replicate_Wild_Do_Table: 
  Replicate_Wild_Ignore_Table: 
                   Last_Errno: 0
                   Last_Error: 
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 156
              Relay_Log_Space: 543
              Until_Condition: None
               Until_Log_File: 
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File: 
           Master_SSL_CA_Path: 
              Master_SSL_Cert: 
            Master_SSL_Cipher: 
               Master_SSL_Key: 
        Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error: 
               Last_SQL_Errno: 0
               Last_SQL_Error: 
  Replicate_Ignore_Server_Ids: 
             Master_Server_Id: 101
                  Master_UUID: 865387c1-be55-11ec-820a-0242ac110002
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: Replica has read all relay log; waiting for more updates
           Master_Retry_Count: 86400
                  Master_Bind: 
      Last_IO_Error_Timestamp: 
     Last_SQL_Error_Timestamp: 
               Master_SSL_Crl: 
           Master_SSL_Crlpath: 
           Retrieved_Gtid_Set: 
            Executed_Gtid_Set: 
                Auto_Position: 0
         Replicate_Rewrite_DB: 
                 Channel_Name: 
           Master_TLS_Version: 
       Master_public_key_path: 
        Get_master_public_key: 0
            Network_Namespace: 
1 row in set, 1 warning (0.02 sec)

ERROR: 
No query specified

```

### 15. 主从复制测试


