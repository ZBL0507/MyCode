## item01： SQL执行流程
    1. 客户端 向 服务端 发起请求
    
    2. 服务端查询缓存，若缓存命中，则直接返回，否则进行步骤3 (缓存开关未开启也不会有查询缓存的过程，MySQL8.0不再有这个缓存)
    
    3. 词法解析，语法解析，预处理器进行预处理
    
    4. 查询优化器进行优化
    
    5. 生成执行计划，交于存储引擎进行查询
    
    6. 缓存结果，返回结果
 

<br/><br/>    
## item02： MySQL的profiling
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


<br/><br/>
## item03： MySQL缓存的开启
```sql
-- 查看缓存开关
mysql> show variables like 'query_cache_type';

-- 开启缓存(临时) 或者 配置文件新增：query_cache_type=1
mysql> set query_cache_type = 1;
```


<br/><br/>
## item04： InnoDB缓冲池大小设置
```mysql
show variables like 'innodb_buffer_pool_size';
set innodb_buffer_pool_size = 268435456
```
![](.mysql_images/efbc39e7.png)


<br/><br/>
## item05： 默认innodb缓冲池的个数
```mysql
show variables like 'innodb_buffer_pool_instances';
```
![](.mysql_images/79bc9526.png)


<br/><br/>
## item06： 查看mysql提供的存储引擎
```mysql
show engines ;
```
![](.mysql_images/61cf39fa.png)


<br/><br/>
## item07： InnoDB和MyISAM的区别
    1. MyISAM不支持外键，InnoDB支持外键
    
    2. MyISAM不支持事务，InnoDB支持事务
    
    3. MyISAM是表级锁，即使操作一条记录也会锁住整张表，不适合高并发的操作
       InnoDB是行级锁，操作时只锁某一行，不对其他行有影响，适合高并发的操作
    
    4. MyISAM关注点是性能，节省资源，消耗少，简单业务  InnoDB关注事务，并发写，事务，更大资源


<br/><br/>
## item08： 聚簇索引
    聚簇索引并不是一种单独的索引类型，而是一种数据存储方式（所有的数据记录都存储在了叶子节点），也就是所谓的索引即数据，数据即索引。
    
    术语"聚簇"表示数据行和相邻的键值聚簇的存储在一起
    
    特点：
        1. 使用记录主键值的大小进行记录和页的排序，这包括三个方面的含义：
            - 页内的记录是按照主键的大小顺序排成一个单向链表。
            - 各个存放用户记录的页也是根据页中用户记录的主键大小顺序的排成一个双向链表。
            - 存放目录项记录的页分为不同的层次，在同一层次中的页也是根据页中目录项记录的主键大小顺序的排成一个双向链表。
        2. B+树的叶子节点存储的是完整的用户记录。
            - 所谓完整的用户记录，就是指这个记录中存储了所有列的值（包括隐藏列）。
            
    我们把具有这两种特性的B+树称为聚簇索引，所有完整的用户记录都存放在这个聚簇索引的叶子节点处。
    这种聚簇索引并不需要我们在mysql语句中显示的使用index语句去创建，InnoDB存储引擎会自动的为我们创建聚簇索引。

    优点：
        - 数据访问更快，因为聚簇索引将索引和数据保存在同一个B+树中，因此从聚簇索引中获取数据比非聚簇索引更快。
        - 聚簇索引对于主键的排序查找和范围查找速度非常快。
        - 按照聚簇索引索引的排列顺序，查询显示一定范围数据的时候，由于数据都是紧密相连，数据库不用从多个数据块中提取数据，所以节省了大量的io操作。

    缺点：
        - 插入速度严重依赖插入顺序，按照主键的顺序插入是最快的方式，否则将会出现页分裂，严重影响性能。
          因此，对于InnoDB表，我们一般都会定义一个自增的ID列为主键
        - 更新主键的代价很高，因为将会导致被更新的行移动。因此，对于InnoDB表，我们一般定义主键为不可更新。
        - 二级索引访问需要两次索引查找，第一次找到主键值，第二次根据主键值找到行数据。

    限制：
        - 对于mysql数据库目前只有InnoDB数据引擎支持聚簇索引，而MyISAM并不支持聚簇索引。
        - 由于数据物理存储排序方式只能有一种，所以每个mysql的表只能有一个聚簇索引，一般情况下就是该表的主键。
        - 如果没有定义主键，InnoDB会选择非空的唯一索引代替。如果没有这样的索引，InnoDB会隐士的定义一个主键来作为聚簇索引。
        - 为了充分利用聚簇索引的聚簇的特性，所以InnoDB表的主键列尽量选用有序的顺序id，而不建议用无序的id，比如：uuid，md5，hash，字符串列作为主键无法保证数据的顺序增长。

#### 聚簇索引示例图：
![](.mysql_images/b00b1134.png)


<br/><br/>
## item09： 二级索引（辅助索引，非聚簇索引）
![](.mysql_images/a38d4746.png)
```text
概念：回表
    我们根据这个以c2列大小排序的B+树只能确定我们要查找记录的主键值，所以如果我们想根据c2列的值查找到完整的用户记录的话，
    仍然需要到聚簇索引中再查一遍，这个过程称为回表。也就是根据c2列的值查询一条完整的用户记录需要使用到2棵B+树！
    
问题：为什么我们还要一次回表操作呢？直接把完整的用户记录放到叶子节点不行吗？
回答：
    如果把完整的用户记录放到叶子节点是可以不用回表，但是太占地方了，相当于每建立一棵B+树都需要把所有的用户记录再拷贝一遍，这就有点太浪费存储空间了。
    
因为这种按照非主键列建立的B+树需要一次回表操作才可以定位到完整的用户记录，所以这种B+树也被称为二级索引（英文名：secondary index），
或者辅助索引，由于我们使用的是c2列的大小作为B+树的排序规则，所以我们也称这个B+树是为c2列建立的索引。

非聚簇索引的存在不影响数据在聚簇索引中的组织，所以一张表可以有多个非聚簇索引。
```

<br/><br/>
## item10： 联合索引
![](.mysql_images/2e8f9b9f.png)


<br/><br/>
## item11： InnoDB的B+树索引的注意事项
```text
1. 根页面位置万年不动
   - 每当为某个表创建一个B+树索引（聚簇索引不是人为创建的，默认就有）的时候，都会为这个索引创建一个根节点页面。
     最开始表中没有数据的时候，每个B+树索引对应的根节点中既没有用户记录，也没有目录项记录。
   - 随后向表中插入用户记录时，先把用户记录存储到这个根节点中。
   - 当根节点中的可用空间用完时继续插入记录，此时会将根节点中的所有记录复制到一个新分配的页，比如页a中，然后对这个新页进行页分裂的操作，
     得到另一个新页，比如页b。这时新插入的记录根据键值（也就是聚簇索引中的主键值，二级索引中对应的索引列的值）的大小就会被分配到页a或者页b中，而根节点便升级为存储目录项记录的页。
   
   这个过程特别注意的是：一个B+树索引的根节点自诞生之日起，便不会再移动。这样只要我们对某个表建立一个索引，那么它的根节点的页号便会被记录到某个地方，
   然后凡是InnoDB存储引擎需要用到这个索引的时候，都会从那个固定的地方取出根节点的页号，从而来访问这个索引。
   
   
2. 内节点中目录项记录的唯一性
   B+树索引的内节点中目录项记录的内容是索引项+页号的搭配，但是这个搭配对于二级索引来说有点不严谨，假设表中的数据如下：
   c1           c2         c3
   1            1          'u'
   3            1          'd'
   5            1          'y'
   7            1          'a'
   如果二级索引中目录项记录的内容只是索引列+页号的搭配的话，那么为c2列建立的索引后的B+树应该长这样：
```
![](.mysql_images/7c42c348.png)
```text
  如果我们想插入一行记录，其中c1，c2，c3的值分别是：9，1，'c'，那么在修改这个为c2列建立的二级索引对应的B+树时便碰到了个大问题：
  由于页3中存储的目录项记录是由c2列+页号的值构成的，页3中的两条目录项记录对应的c2列的值都是1，而我们新插入的这条记录的c2列的值也是1，
  那我们这条新插入的记录到底应该放到页4中，还是页5中？？？
  
  为了让新插入的记录能够找到自己在那个页里，我们需要保证在B+树的同一层内节点目录项记录除页号这个字段以外是唯一的，所以对于二级索引的内节点的目录项记录的内容实际上是由三个部分构成的：
  + 索引列的值
  + 主键值
  + 页号
  也就是我们把主键值也添加到二级索引内节点中的目录项记录了，这样就能保证B+树每一层节点中各条目录项记录除页号这个字段外是唯一的，
  所以我们为c2列建立二级索引后的示意图实际上应该是这样子的：
```
![](.mysql_images/4e0aec30.png)
```text
  这样我们再插入记录（9，1，’c’）时，由于 页3中存储的目录项记录是由c2列 ＋ 主键 ＋ 页号的值构成的，可以先把新记录的c2列的值和页3中各目录项记录的c2列的值作比较，
  如果c2列的值相同的话，可以接着比较主键值，因为B+树同一层中不同目录项记录的C2列 ＋ 主键的值肯定是不一样的，所以最后肯定能定位唯一的一条目录项记录，在本例中最后确定新记录应该被插入到页5中。

3. 一个页面最少存储2条记录
   一个B+树只需要很少的层级就可以轻松存储数亿条记录，查询速度相当不错！这是因为B+树本质上就是一个大的多层级目录，每经过一个目录时都会过滤掉许多无效的子目录，
   直到最后访问到存储真实数据的目录。那如果个大的目录中只存放—个子目录是个啥效果呢？那就是目录层级非常非常非常多，而且最后的那个存放真实数据的目录中只能存放一条记录。
   费了半天劲只能存放一条真实的用户记录？所以InnoDB的一个数据页至少可以存放两条记录。
```

<br/><br/>
## item12： MyISAM索引结构
#### MyISAM中的索引方案虽然也使用树形结构，但是却将索引和数据分开存储：
+ 将表中的记录按照记录的插入顺序单独存储在一个文件中，成为数据文件，这个文件并不划分为若干个数据页，有多少记录就往这个文件中塞多少记录就成了。
  由于在插入数据的时候并没有刻意按照主键大小排序，所以我们并不能在这些数据上使用二分法进行查找。
  
+ 使用MyISAM存储引擎的表会把索引信息另外存储到一个称为索引文件的另一个文件中。MyISAM会单独为表的主键创建一个索引，
  只不过在索引的叶子节点中存储的不是完整的用户记录，而是主键值+数据记录地址的组合
  
![](.MySQL_images/0e845eee.png)


<br/><br/>
## item13： MyISAM与InnoDB对比
#### MyISAM的索引方式都是“非聚簇”的，与InnoDB包含1个聚簇索引是不同的。
+ 在InnoDB存储引擎中，我们只需要根据主键值对聚簇索引进行一次查找就能找到对应的记录，而在MyISAM中却需要进行一次回表操作，
  意味着MyISAM中建立的索引相当于全部都是二级索引。
  
+ InnoDB的数据文件本身就是索引文件，而MyISAM索引文件和数据文件是分离的，索引文件仅保存数据记录的地址。
+ InnoDB的非聚簇索引data域存储相应记录的主键值，而MyISAM索引记录的是地址。换句话说，InnoDB的所有非聚簇索引都在引用主键作为data域。
+ MyISAM的回表操作是十分快速的，因为是拿着地址偏移量直接到文件中取数据的，反观InnoDB是通过获取主键之后再去聚簇索引里找记录，虽然说也不慢，
  但还是比不上直接用地址去访问。
+ InnoDB要求表必须有主键（MyISAM可以没有）。如果没有显示指定，则MySQL系统会自动选择一个可以非空且唯一标识数据记录的列作为主键。
  如果不存在这种列，则MySQL自动为InnoDB表生成一个隐含字段作为主键，这个字段长度为6个字节，类型为长整型。
  

<br/><br/>
## item14： B+树和B树的差异：
+ 有k个孩子的节点就有k个关键字，也就是孩子数量=关键字数量，而B树中，孩子数量=关键字数量+1。

+ 非叶子节点的关键字也会同时存在在子节点中，并且是在子节点中所有关键字的最大（最小）。
+ 非叶子节点仅用于索引，不保存数据记录，跟记录有关的信息都放在叶子节点中。而B树中，非叶子节点既保存索引，也保存数据。
+ 所有关键字都在叶子节点出现，叶子节点构成一个有序的链表，而且叶子节点本身按照关键字的大小从小到大顺序链接。
![](.MySQL_images/a81319a4.png)


<br/><br/>
## item15： B+树的存储能力如何？为何说一般查找行记录，最多只需1~3次磁盘IO
```text
InnoDB存储引擎中也的大小为16KB，一般表的主键类型为int（占用4个字节），或者bigint（占用8个字节），指针类型也一般为4个或8个字节，
也就是说一个页（B+Tree中的一个节点）中大概存储16KB/(8B+8B)=1K个键值（因为是估计值，方便计算，这里的K取值为1000。）
也就是说一个深度为3的B+Tree索引可以维护1000*1000*1000=10亿条记录。（这里假定一个数据页也存储1000条行记录数据了）

实际情况中每个节点可能不能填充满，因此在数据库中，B+Tree的高度一般都在2~4层。
MySQL的InnoDB存储引擎在设计时是将根节点常驻内存的，也就是说查找某一行键值的行记录时最多只需要1~3次磁盘I/O操作。
```


<br/><br/>
## item16： InnoDB数据存储结构
+ 数据库的存储结构：页
  + 磁盘与内存交互基本单位：页
    ```text
    InnoDB将数据划分为若干个页，InnoDB中页的大小默认为16KB
    在数据库中，不论读一行，还是读多行，都是将这些行所在的页进行加载。也就是说，数据库管理存储空间的基本单位是页（Page）,
    数据库I/O操作的最小单位是页。
    ```
    InnoDB数据页的大小：
      ![](.MySQL_images/3405d9ee.png)
  + 数据页的7个部分：
      ![](.MySQL_images/abb4af0d.png)
    + 文件头：
      ![](.MySQL_images/e01694fe.png)
    + 文件尾：
      ![](.MySQL_images/7fde9aea.png)
    + 空闲空间：
      ![](.MySQL_images/0d15982b.png)
    + 用户记录：
      ![](.MySQL_images/676a6406.png)
    + 最小最大记录
      ![](.MySQL_images/1cc2bcef.png)
      
      ![](.MySQL_images/deee0418.png)
    + 页目录
    + 页面头部：
      ![](.MySQL_images/2be67bf4.png)
      
+ InnoDB行格式
  ![](.MySQL_images/f652b076.png)
  
  ![](.MySQL_images/c6195cb0.png)
  
  ![](.MySQL_images/da046d4c.png)
  

<br/><br/>
## item17： 索引的分类
+ 从功能逻辑上分类：
    1. 普通索引
    
    2. 唯一索引
    3. 主键索引
    4. 全文索引
    
+ 从物理实现上分类：
    1. 聚簇索引
    
    2. 非聚簇索引
    
+ 按字段个数分类：
    1. 单列索引
    
    2. 联合索引
 
<br/><br/>   
## item18： 创建索引的三种方式
+ 创建表的时候就创建索引
  ```mysql
  # 隐式的方式创建索引，在声明有主键约束、唯一性约束、外键约束的字段上，会自动的添加相关的索引
  CREATE DATABASE dbtest2;

  USE dbtest2;

  CREATE TABLE dept(
      dept_id INT PRIMARY KEY AUTO_INCREMENT,
      dept_name VARCHAR(20)
  );

  CREATE TABLE emp(
      emp_id INT PRIMARY KEY AUTO_INCREMENT,
      emp_name VARCHAR(20) UNIQUE,
      dept_id INT,
      CONSTRAINT emp_dept_id_fk FOREIGN KEY(dept_id) REFERENCES dept(dept_id)
  );
  
  # 显示的创建索引
  # 基本语法：
  CREATE TABLE table_name [col_name data_type] [UNIQUE|FULLTEXT|SPATIAL] [INDEX|KEY] [index_name] (col_name [length]) [ASC|DESC]
  # 1.创建普通的索引
  CREATE TABLE book (
      book_id INT,
      book_name VARCHAR(100),
      AUTHORS VARCHAR(100),
      info VARCHAR(100),
      COMMENT VARCHAR(100),
      year_publication YEAR,
      #声明索引
      INDEX idx_bname(book_name)
  );
 
  # 2.创建唯一索引
  CREATE TABLE book1 (
      book_id INT,
      book_name VARCHAR(100),
      AUTHORS VARCHAR(100),
      info VARCHAR(100),
      COMMENT VARCHAR(100),
      year_publication YEAR,
      #声明索引
      unique INDEX idx_bname(book_name)
  );
  
  # 3.创建联合索引
  CREATE TABLE book2 (
      book_id INT,
      book_name VARCHAR(100),
      AUTHORS VARCHAR(100),
      info VARCHAR(100),
      COMMENT VARCHAR(100),
      year_publication YEAR,
      #声明索引
      INDEX idx_name_info(book_name, info)
  );
  ```
+ 在已经存在的表上创建索引1
  ```mysql
  CREATE TABLE book3 (
      book_id INT,
      book_name VARCHAR(100),
      AUTHORS VARCHAR(100),
      info VARCHAR(100),
      COMMENT VARCHAR(100),
      year_publication YEAR
  );
  alter table book3 add index idx_cmt(COMMENT);
  alter table book3 add unique uk_idx_bname(book_name);
  alter table book3 add index mul_bid_bname_info(book_id, book_name, info);
  ```
+ 在已经存在的表上创建索引2
  ```mysql
  CREATE TABLE book4 (
      book_id INT,
      book_name VARCHAR(100),
      AUTHORS VARCHAR(100),
      info VARCHAR(100),
      COMMENT VARCHAR(100),
      year_publication YEAR
  );
  create index idx_cmt on book4(COMMENT);
  create unique index uk_idx_bname on book4(book_name);
  create index mul_bid_bname_info on book4(book_id, book_name, info);
  ```  

<br/><br/>
## item19： 删除索引的方式
```mysql
CREATE TABLE book5 (
    book_id INT,
    book_name VARCHAR(100),
    AUTHORS VARCHAR(100),
    info VARCHAR(100),
    COMMENT VARCHAR(100),
    year_publication YEAR
);
create index idx_cmt on book5(COMMENT);
create unique index uk_idx_bname on book5(book_name);
create index mul_bid_bname_info on book5(book_id, book_name, info);

# 方式一
alter table book5 drop index idx_cmt;

# 方式二
drop index uk_idx_bname on book5;
# 提示：
# 删除表中的列时，如果要删除的列为索引的组成部分，则该列也会从索引中删除。如果组成索引的所有列都被删除，则整个索引将被删除。
```

<br/><br/>
## item20： MySQL8.0索引新特性
1. 支持降序索引

2. 隐藏索引

<br/><br/>
## item21： 哪些情况适合创建索引
1. 字段的数值有唯一性的限制
2. 频繁作为 where 查询条件的字段
3. 经常 group by 和 order by 的列
4. update、delete 的 where 条件列
5. distinct 字段需要创建索引
6. 多表join连接操作时，创建索引注意事项
   ```text
   1. 首先，连接表的数量尽量不要超过 3 张，因为每增加一张表就当于增加了一次嵌套的循环，数量级增长会非常快，严重影响查询的效率。
   2. 其次, 对 WHERE 条件创建索引，因为WHERE才是对数据条件的过滤。如果在数据量非常大的情况下，没有WHERE条件过滤是非常可怕的。
   3. 最后, 对用于连接的字段创建索引，并且该字段在多张表中的类型必须一致。   
   ```
7. 使用列的类型小的创建索引
   ```text
   + 这里所说的类型大小指的就是该类型表示数据范围的大小(int, bigint)
   + 数据类型越小，在查询时进行的比较操作越快
   + 数据类型越小，索引占用的存储空间就越少，在一个数据页内就可以放下更多的记录，从而减少磁盘I/O带来的性能损耗，
     也就意味着可以把更多的数据页缓存在内存中，从而加快读写效率。
   ```
8. 使用字符串前缀创建索引
   ```text
   + B+树索引中的记录需要把该列的完整字符存储起来，更费时。而且字符串越长，在索引中占用的存储空间越大。
   + 如果B+树索引中索引列存储的字符串很长，那在做字符串比较时会占用更多的时间。
   + 我们可以通过截取字段的前面一部分内容建立索引，这个就叫 前缀索引。这样在查找记录时虽然不能精确的定位到记录的位置，
     但是能定位到相应前缀所在的位置，然后根据前缀相同的记录的主键值回表查询完整的字符串值。
     既节约空间，又减少了字符串的比较时间，还大体能解决排序的问题。       
     alter table shop add index(address(12)) #添加一个前缀索引    
     count(distinct left(列名, 索引长度)) / count(*) #计算区分度，区分度达到33%就可以做索引了
   + 注意：因为二级索引中不包含完整的address列信息，所以无法对前12个字符相同，后边的字符不同的记录进行排序，
          也就是使用索引列前缀的方式 无法支持使用索引排序，只能使用文件排序。
   ```
9. 区分度高(散列性高)的列适合作为索引

10. 使用最频繁的列放到联合索引的左侧
11. 在多个字段都要创建索引的情况下，联合索引优于单值索引。


<br/><br/>
## item22： 哪些情况不适合创建索引
1. 在where(group by, order by)中使用不到的字段，不要设置索引

2. 数据量小的表最好不要使用索引
3. 有大量重复数据的列上不要建立索引
4. 避免对经常更新的表创建过多的索引
5. 不建议用无序的值作为索引
6. 删除不再使用或者很少使用的索引
7. 不要定义冗余或重复的索引


<br/><br/>
## item23: 性能分析工具的使用
### 1. 数据库服务器的优化步骤
![](.MySQL_images/79eabbab.png)

![](.MySQL_images/cdda601b.png)

![](.MySQL_images/c350a69b.png)

![](.MySQL_images/8b3a578b.png)

### 2. 查看系统性能参数
在```MySQL```中，可以使用```show status```语句查询一些```MySQL```数据库服务器的```性能参数```、```执行频率``` <br/>
```show status```语句语法如下：
```text
show [global|session] status like '参数';
```
+ Connections: 连接MySQL服务器的次数。

+ Uptime: MySQL服务器的上线时间。

+ Slow_queries: 慢查询的此时。

+ Innodb_rows_read: Select查询返回的行数。

+ Innodb_rows_inserted: 执行insert操作插入的行数。

+ Innodb_rows_updated: 执行update操作更新的行数。

+ Innodb_rows_deleted: 执行delete操作删除的行数。

+ Com_select: 查询操作的次数。

+ Com_insert: 插入操作的次数。对于批量插入的insert操作，只累加一次。

+ Com_update: 更新操作的次数

+ Com_delete: 删除操作的次数

### 3. 统计SQL的查询成本：last_query_cost

### 4. 定位执行慢的SQL：慢查询日志
+ ```MySQL```的慢查询日志，用来记录再```MySQL```中```响应时间超过阈值```的语句，具体指运行时间超过```long_query_time```值的```SQL```,
  则会被记录到慢查询日志中，```long_query_time```的默认值为10，意思是运行10秒以上(不含10秒)的语句。
+ 默认情况下，```MySQL```数据库```没有开启慢查询日志```，需要我们手动来设置这个参数。```如果不是调优需要的话，一般不建议启动该参数```，因为开启慢查询日志会或多或少带来一定的性能影响。

+ 开启慢查询日志参数slow_query_log <br/>
  在使用前，我们需要先看下慢查询是否已经开启，使用下面这条命令即可：
  ```mysql
  mysql> show variables like '%slow_query_log%';
  ```
  ![](.MySQL_images/82366b3a.png)
  <br/>
  如果看到```slow_query_log=OFF```,我们可以使用下面命令打开：
  ```mysql
  mysql> set global slow_query_log='ON';
  ```
+ 修改long_query_time阈值
  ```mysql
  mysql> set global long_query_time = 1; #修改慢查询阈值时间为1秒
  ```
+ 配置文件的方式修改
  ![](.MySQL_images/9c699436.png)
  
+ 补充说明
  ![](.MySQL_images/f260001a.png)
  

### 5. 慢查询日志分析工具：mysqldumpslow
+ 在生产环境中，如果要分析慢查询日志，```MySQL```提供了日志分析工具```mysqldumpslow```<br>
  查看```mysqldumpslow```的帮助信息
  ```text
  mysqldumpslow --help #这个不是mysql命令，需要在终端中运行
  ``` 
  ![](.MySQL_images/fbcf4975.png)
  
### 6. 关闭慢查询日志
+ 方式1: 永久性方式<br/>
        修改配置文件
    ```text
    [mysqld]
    slow_query_log=OFF
    # 或者注释掉，或者删除掉
    # slow_query_log=OFF
    ```
+ 方式2: 临时性关闭
    ```mysql
    mysql> set global slow_query_log = off;
    ```
    
### 7. 删除慢查询日志
   ```text
    mysqladmin -uroot -p flush-logs slow
   ```


<br/><br/>
## item24: 查看SQL执行成本：show profile
+ show profile 是 MySQL提供的可以用来分析当前会话中SQL都做了什么、执行的资源消耗情况的工具，可用于sql调优的测量。默认情况下处于关闭状态，并保存最近15次的运行结果<br/>
  在会话级别开启这个功能：
  ```mysql
  mysql> show variables like 'profiling';
  mysql> set profiling = 'on';
  mysql> show profiles;
  mysql> show profile for query 23;
  ```


<br/><br/>
## item25： 分析查询语句：explain 
### 1. 能做什么？
+ 表的读取顺序

+ 数据读取操作的操作类型
+ 哪些索引可以使用
+ 哪些索引被实际使用
+ 表之间的引用
+ 每张表有多少行被优化器查询


### 2. 版本情况
+ ```MySQL5.6.3```以前只能```explain select```；```MySQL5.6.3```以后就可以```explain select，update，delete```

+ 在5.7以前的版本中，想要显示```partitions```需要使用```explain partitions```命令；想要显示```filtered```需要使用```explain extended```命令。在5.7版本后，默认```explain```直接显示```partitions```和```filtered```中的信息。


### 3. 基本语法
```text
explain select select_options

或者

describe select select_options
```
```explain```语句输出的各个列的作用如下:

![](.MySQL_images/72465d6d.png)


### 4. explain各列作用
+ table 
  ```text
  表名
  查询的每一行记录都对应着一个单表
  ```
 

 
+ id <br>
  + 在一个大的查询语句中每个select关键字都对应一个唯一的id
  
  + id如果相同，可以认为是一组，从上往下顺序执行
  + 在所有组中，id值越大，优先级越高，越先执行
  + 关注点：id号每个号码，表示一趟独立的查询，一个sql的查询趟数越少越好
  

+ select_type
  + 一条大的查询语句里边可以包含若干个select关键字，每个select关键字代表着一个小的查询语句，而每个select关键字的from子句中都可以包含若干表（这些表用来做连接查询），
    每一张表都对应着执行计划输出中的一条记录，对于在同一个select关键字中的表来说，它们的id值是相同的。
    
  + MySQL为每一个select关键字代表的小查询都定义了一个称之为select_type的属性，意思是我们只要知道了某个小查询的select_type属性，
    就知道了这个小查询在整个大查询中扮演了一个什么角色，select_type的取值：
    + SIMPLE： 查询语句中不包含'UNION'或者子查询的查询都算作是'SIMPLE'类型，连接查询也算是'SIMPLE'类型。
    + PRIMARY： 对于包含'union'或者'union all'或者子查询的大查询来说，它是由几个小查询组成的，
      其中最左边的查询的'select_type'值就是'PRIMARY'
    + UNION： 对于包含'union'或者'union all'的大查询来说，它是由几个小查询组成的，其中除了最左边的那个小查询以外，
      其余的小查询的'select_type'值就是'UNION'
    + UNION RESULT： mysql选择使用临时表来完成'union'查询的去重工作，针对该临时表的查询的'select_type'就是'UNION RESULT'
    + SUBQUERY： 如果包含子查询的查询语句不能转为对应的'semi-join'的形式，并且该子查询是不相关子查询。
      该子查询的第一个'select'关键字代表的那个查询的'select_type'就是'SUBQUERY'
    + DEPENDENT SUBQUERY： 如果包含子查询的查询语句不能转为对应的'semi-join'的形式，并且该子查询是相关子查询。
      则该子查询的第一个'select'关键字代表的那个查询的'select_type'就是'DEPENDENT SUBQUERY'
      <br/>注意的是，select_type为DEPENDENT SUBQUERY的查询可能会被执行多次。
    + DEPENDENT UNION： 在包含'union'或者'union all'的大查询中，如果各个小查询都依赖于外层查询的话，那除了最左边的那个小查询之外，
      其余的小查询的'select_type'的值就是'DEPENDENT UNION'
    + DERIVED： 对于包含'派生表'的查询，该派生表对应的子查询的'select_type'就是'DERIVED'
    + MATERIALIZED： 当查询优化器在执行包含子查询的语句时，选择将子查询物化之后与外层查询进行连接查询时，
      该子查询对应的'select_type'属性就是'MATERIALIZED'
  
 
+ partitions
  <br>代表分区表的命中情况，非分区表，该项为NULL。一般情况下我们的查询语句的执行计划的partitions列的值都是NULL
  

+ type
  + 执行计划的一条记录就代表着mysql对某个表的执行查询时的访问方法，又称"访问类型"，其中的type列就表明了这个访问方法是啥，是较为重要的一个指标。
    比如，看到type列的值是ref，表明mysql即将使用ref访问方法来执行对s1表的查询。
  + 访问方法有：system, const, eq_ref, ref, fulltext, ref_or_null, index_merge, unique_subquery, index_subquery, range, index, all.
  + 详细解释：
    + system： 当表中'只有一条记录'并且该表使用的存储引擎的统计数据是精确的，比如MyISAM, Memory, 那么对该表的访问方法就是system
      ```mysql
      explain select * from t; # 表t中只有一条记录
      ```
    + const： 当我们根据主键或者唯一二级索引列与常数进行等值匹配时，对表的访问方法就是const
      ```mysql
      explain select * from s1 where id = 1222;
      explain select * from s1 where key2 = 8080;
      ```
    + eq_ref： 在连接查询时，如果被驱动表是通过主键或者唯一二级索引列等值匹配的方式进行访问的（如果该主键或者唯一二级索引是联合索引的话，所有的索引列都必须进行等值比较），
      则对该被驱动表的访问方法就是eq_ref
      ```mysql
      explain select * from s1 inner join s2 on s1.id = s2.id;
      ```
    + ref： 当通过普通的二级索引列与常量进行等值匹配时来查询某个表，那么对该表的访问方法就可能是ref
      ```mysql
      explain select * from s1 where key1 = 'a';
      ```
    + ref_or_null： 当对普通的二级索引进行等值匹配查询，该索引列的值也可以是'NULL'值时，那么对该表的访问方法就可能是ref_or_null
      ```mysql
      explain select * from s1 where key1 = 'a' or key1 is null;
      ```
    + index_merge： 单表访问方法时在某些场景下可以使用'intersection'，'union'，'sort-union'这三种索引合并的方式来执行查询
      ```mysql
      explain select * from s1 where key1 = 'a' or key3 = 'b';
      ```
    + unique_subquery： unique_subquery是针对在一些包含'in'子查询的查询语句中，如果查询优化器决定将'in'子查询转换为'exists'子查询，
      而且子查询可以使用到主键进行等值匹配的话，那么该子查询执行计划的type列的值就是unique_subquery
      ```mysql
      explain select * from s1 
            where key2 in (select id from s2 where s1.key1 = s2.key1) or key3 = 'a';
      ```
    + range： 如果使用索引获取某些范围区间的记录，那么就可能使用的到range访问方法
      ```mysql
      explain select * from s1 where key1 in ('a', 'b', 'c');
      explain select * from s1 where key1 > 'a' and key1 < 'b';
      ```
    + index： 当我们可以使用索引覆盖，但需要扫描全部当索引记录时，该表的访问方法就是index
      ```mysql
      explain select key_part2 from s1 where key_part3 = 'a';
      ```
    + all： 全表扫描
      ```mysql
      explain select * from s1;
      ```
      
+ possible_key和key
  + possible_key: 可能用到的索引
  + key: 实际用到的索引
  

+ key_len: 实际使用到的索引长度（即：字节数）
          <br>帮你检查是否充分的利用上了索引，值越大越好（针对联合索引）。
  

+ ref
  <br>当使用索引列等值查询时，与索引列进行等值匹配的对象信息


+ rows
  <br>预估的需要读取的记录条数
  

+ filtered
  + 某个表经过搜索条件过滤后剩余记录条数的百分比
  + 如果使用的时索引执行的单表扫描，那么计算时需要估计出满足除使用到对应索引的搜索条件外的其他搜索条件的记录有多少条。
  + 对于单表查询来说，这个filtered列的值没什么意义，我们更关注在连接查询中驱动表对应的执行计划记录中的filtered值，它决定了被驱动表要执行的次数（即：rows * filtered）


+ extra：一些额外信息
  + no tables used： 当查询语句没有from子句时将会提示该信息，比如
    ```mysql
    explain select 1;
    ```
  + impossible where： 查询语句的where子句永远为false时将会提示该额外信息
    ```mysql
    explain select * from s1 where 1 != 1;
    ```
  + using where： 当我们使用全表扫描来执行对某个表的查询，并且该语句的where子句中有针对该表的搜索条件时，在extra列中会提示该额外信息
    <br> 当使用索引访问来执行对某个表的查询，并且该语句的where子句中有除了该索引包含的列之外的其他搜索条件时，在extra列中也会提示该信息
    ```mysql
    explain select * from s1 where common_field = 'a';
    explain select * from s1 where key1 = 'a' and common_field = 'a';
    ```
  + select tables optimized away： 当查询列表处有min或者max聚合函数，但是并没有符合where子句中的搜索条件的记录时，将会提示该额外信息
    ```mysql
    explain select min(key1) from s1 where key1 = '表中不存在的数据';
    ```
  + using index： 当我们的查询列表以及搜索条件中只包含属于某个索引的列，也就是在可以使用覆盖索引的情况下，在extra列将会提示该信息。比如说下面这个查询只需要用到'idx_key1'而不需要回表操作
    ```mysql
    explain select key1 from s1 where key1 = 'a';
    explain select key1, id from s1 where key1 = 'a';
    ```
  + using index condition： 有些搜索条件中虽然出现了索引列，但是却不能使用到索引列
    ```mysql
    explain select * from s1 where key1 > 'z' and key1 like '%a';
    ```
  + using join buffer： 在连接查询执行过程中，当被驱动表不能有效的利用索引加快访问速度的时候，mysql一般会为其分配一块名叫'join buffer'的内存来加快查询速度，也就是我们讲的'基于块的嵌套循环算法'
    ```mysql
    explain select * from s1 inner join s2 on s1.common_field = s2.common_field;
    ```
  + not exists： 当我们使用左外连接时，如果where子句中包含要求被驱动表的某个列等于'NULL'值的搜索条件，而且那个列又是不允许存储'NULL'值的，那么在该表的执行计划的extra列就会提示该信息
    ```mysql
    explain select * from s1 left join s2 on s1.key1 = s2.key1 where s2.id is null ;
    ```
  + using union： 如果执行计划的extra列出现列using intersect(...)提示，说明准备使用intersect索引合并的方式执行查询，括号中的'...'表示需要进行索引合并的索引名称<br>
    如果出现了using union(...)提示，说明准备使用union索引合并的方式执行查询<br>
    如果出现了using sort_union(...)提示，说明准备使用'sort-union'索引合并的方式执行查询。
    ```mysql
    explain select * from s1 where key1 = 'a' or key3 = 'b';
    ```
  + zero limit： 当我们的limit子句的参数为0时，表示压根不打算从表中读出任何记录，将会提示该信息。
    ```mysql
    explain select * from s1 limit 0;
    ```
  + using filesort： 很多情况下排序操作无法使用到索引，只能在内存中（记录较少的时候）或者磁盘中（记录较多的时候）进行排序，mysql把这种在内存中或者磁盘上进行排序的方式统称为文件排序（filesort）<br>
    如果某个查询需要使用文件排序的方式执行查询，就会在执行计划的extra列中显示'using filesort'
    ```mysql
    explain select * from s1 order by common_field limit 10;
    ```
  + using temporary： 在许多查询的执行过程中，mysql可能会借助临时表来完成一些功能，比如去重，排序之类的，比如我们在执行许多包含distinct，group by，union等子句的查询过程中，
    如果不能有效利用索引来完成查询，mysql很有可能寻求通过建立内部的临时表来执行查询。如果查询中使用到了内部的临时表，在执行计划的extra列将会显示using temporary提示
    ```mysql
    explain select distinct common_field from s1;
    explain select common_field, count(*) as amount from s1 group by common_field;
    ```
    
### 5. explain的注意点
+ explain不考虑各种cache
+ explain不能显示mysql在执行查询时所作的优化工作
+ explain不会告诉你关于触发器，存储过程的信息或用户自定义函数对查询的影响情况
+ 部分统计信息是估算的，并不是精确值


<br/><br/>
## item26： explain的进一步使用
### 1. explain四种输出格式
+ 传统格式
  <br>传统格式简单明了，输出是一个表格形式，概要说明查询计划
  ```mysql
  explain select s1.key1, s2.key1 from s1 left join s2 on s1.key1 = s2.key1 where s2.common_field is not null ;
  ```
  ![](.MySQL_images/312e17bf.png)
+ json格式
  <br>传统格式中介绍的explain语句输出中缺少列一个衡量执行计划好坏的重要属性——成本。而json格式是四种格式里面输出信息最详尽的格式，里面包含了执行的成本信息。
  + json格式：在explain单词和真正的查询语句中间加上format = json。
    ```mysql
    explain format = json select ...
    ```
  + explain的column与json的对应关系：
    ![](.MySQL_images/44db18f6.png)
+ tree格式
  <br>tree格式是8.0.16版本之后引入的新格式，主要根据查询的各个部分之间的关系和各部分的执行顺序来描述如何查询。
  ```mysql
  explain format = tree select ...
  ```
+ 可视化输出
  <br>可视化输出，可以通过MySQL Workbench可视化查看MySQL的执行计划。通过点击Workbench的放大镜图标，即可生成可视化的查询计划。
  ![](.MySQL_images/a1595c44.png)
  
### 2. show warnings的使用
    在我们使用explain语句查看了某个查询计划后，紧接着还可以使用show warnings语句查看与这个查询的执行计划有关的一些扩展信息，比如：
    explain select ...;
    show warnings;
    通常可以看到show warnings展示出来的信息有三个字段，分别是level，code，message。
    我们最常见的就是code为1003的信息，当code为1003时，message字段展示的信息类似于查询优化器将我们的查询语句重写后的语句。
    比如有时会将我们写的外连接优化为内连接，有时会将我们写的子查询优化为连接查询。








